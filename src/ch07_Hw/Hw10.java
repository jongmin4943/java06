package ch07_Hw;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Hw10 {
	static HashMap<String, String> map = new HashMap<>();
	static Scanner scan;
	public static void main(String[] args) {
		File file = new File("c:/temp/phone.txt");
		FileReader fr = null;
		try {
			fr = new FileReader(file);
			scan = new Scanner(fr);
			while(scan.hasNext()) {
				String name = scan.next().trim();
				String number = scan.nextLine().trim();
				map.put(name, number);
			}
			fr.close();
			scan.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("총" +map.size()+"개의 전화번호를 읽었습니다.");
		search(map);
	}
	private static void search(HashMap<String, String> map) {
		scan = new Scanner(System.in);
		while(true) {
			System.out.print("이름>> ");
			String keyword = scan.nextLine();
			if(keyword.equals("그만")) break;
			if((map.get(keyword)) != null) {
				System.out.println(map.get(keyword));
				continue;
			} else {
				System.out.println("찾는 이름이 없습니다.");
			}
		}
	}
}
