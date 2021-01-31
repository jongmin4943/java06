package ch06_Hw;

import java.util.ArrayList;

interface IStack<T> {
	T pop();
	boolean push(T ob);
}

class MyStack<T> implements IStack<T> {
	ArrayList<T> list = new ArrayList<>();
	@Override
	public T pop() {
		if(list.size() < 1) return null;
		T result = list.get(list.size()-1);
		list.remove(list.size()-1);
		return result;
	}

	@Override
	public boolean push(T ob) {
		list.add(ob);
		return false;
	}
	
}
public class Hw5 {
	public static void main(String[] args) {
		IStack<Integer> stack = new MyStack<Integer>();
		for(int i = 0; i<10; i++) stack.push(i);//10개의 정수 푸쉬
		while(true) { //스택이 빌때까지 pop
			Integer n = stack.pop();
			if(n == null) break;
			System.out.print(n + " ");
		}
	}
}
