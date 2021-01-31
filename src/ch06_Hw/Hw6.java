package ch06_Hw;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

//hashmap이용

class Country {
	private String name;
	private String city;
}

public class Hw6 {
	static Scanner scan = new Scanner(System.in);
	static HashMap<String, String> map = new HashMap<>();
	public static void main(String[] args) {
		System.out.println("***수도 맞추기 게임을 시작합니다***");
		boolean done = false;
		int count = 0;
		while(!done) {
			System.out.print("입력:1, 퀴즈:2, 종료:3 >>> ");
			String choice = scan.nextLine();
			if(choice.equals("1")) {
				count = insert(count);
				scan.nextLine();
				continue;
			}else if(choice.equals("2")) {
				quiz();
				continue;
			}else if(choice.equals("3")) {
				System.out.println("종료합니다.");
				break;
			}else {
				System.out.println("잘못된 입력입니다.");
			}
		}
	}
	private static void quiz() {
		while(true) {
			Iterator<String> keys = map.keySet().iterator();
			Random ran = new Random();
			ArrayList<String> arr = new ArrayList<>();
			while(keys.hasNext()) {
				arr.add(keys.next());
			}
			String ques = arr.get(ran.nextInt(arr.size()));
			System.out.print(ques + "의 수도는? ");
			String guess = scan.nextLine();
			if(guess.equals("그만")) return;
			if(guess.equals(map.get(ques))) {
				System.out.println("정답!!");
				continue;
			} else {
				System.out.println("아닙니다!!");
				continue;
			}
		}
	}
	private static int insert(int count) {
		while(true) {
			System.out.print("나라와 수도입력" + (count+1) + ">> ");
			String country = scan.next().trim();
			if(country.equals("그만")) break;
			String city = scan.next().trim();
			Iterator<String> keys = map.keySet().iterator();
			while(keys.hasNext()) {
				String s = keys.next();
				if(s.equals(country)) {
					System.out.println(country + "는 이미 있습니다");
					return insert(count);
				}
			}
			if(!(keys.hasNext())) {
				map.put(country, city);
				count++;
			}
		}
		return count;
	}
}
