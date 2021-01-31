package ch07_Hw;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Hw2 {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		System.out.println("전화번호 입력 프로그램입니다.");
		/**
		 * 파일 쓰기
		 */
		File file = new File("c:/temp/phone.txt");
		FileWriter fw = null;
		try {
			fw = new FileWriter(file);
			while (true) {
				System.out.print("이름 전화번호 >> ");
				String name = scan.next().trim();
				if (name.equals("그만"))
					break;
				String number = scan.nextLine();
				fw.write(name+"\t"+number+'\n');
			}
			System.out.println(file.getPath()+"에 저장완료");
			scan.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		/**
		 * 파일 읽기
		 */
		FileReader fr = null;
		BufferedReader br = null;
		String st = "";
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			System.out.println(file.getPath() + "를 출력합니다");
			while(true) {
				st = br.readLine();
				if(st == null) break;
				System.out.print(st+"\n");
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
