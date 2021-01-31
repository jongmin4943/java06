package ch06_Hw;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

class Student2 {
	private String name;
	private String score;
	public Student2(String name, String score) {
		this.name = name;
		this.score = score;
	}
	public String getScore() {
		return score;
	}
	@Override
	public String toString() {
		return String.format("%s", name);
	}
}
public class Hw3 {
	static Scanner scan = new Scanner(System.in);
	static HashMap<String, Student2> map = new HashMap<>();
	public static void main(String[] args) {
		System.out.println("미래 장학금 관리 시스템입니다");
		while(map.size()<5) {
			System.out.print("이름과 학점>> ");
			String name = scan.next().trim();
			String score = scan.next().trim();
			Student2 student = new Student2(name,score);
			map.put(name, student);
		}
		System.out.print("장학생 선발 학점 기준 입력>> ");
		double cutL = scan.nextDouble();
		String qual = "";
		Iterator<String> keys = map.keySet().iterator();
		while(keys.hasNext()) {
			Student2 s = map.get(keys.next());
			String d = s.getScore();
			if(Double.parseDouble(d) > cutL) {
				qual += s + " ";
			}
		}
		System.out.println("장학생 명단 : " + qual);
	}
}
