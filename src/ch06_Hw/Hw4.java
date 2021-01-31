package ch06_Hw;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

class Customer {
	private String name;
	private int point;
	Customer(String name, int point) {
		this.name = name;
		this.point = point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public int getPoint() {
		return this.point;
	}
	
	@Override
	public String toString() {
		return String.format("(%s,%d)", name,point);
	}
}
public class Hw4 {
	static Scanner scan = new Scanner(System.in);
	static HashMap<String,Customer> map = new HashMap<>();
	public static void main(String[] args) {
		System.out.println("** 포인트 관리 프로그램 **");
		while(true) {
			System.out.print("이름과 포인트 입력 >> ");
			String name = scan.next().trim();
			if(name.equals("그만")) break;
			int point = scan.nextInt();
			int p = 0;
			if(map.get(name)!=null) {
				p = map.get(name).getPoint();
				map.get(name).setPoint(point+p);
			} else {
				Customer cus = new Customer(name, point);
				map.put(name, cus);
			}
			Iterator<String> keys = map.keySet().iterator();
			while(keys.hasNext()) {
				System.out.print(map.get(keys.next()));
			}
			System.out.println();
		}
	}
}
