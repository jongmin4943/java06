package ch07_Hw;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Hw4 {
	public static void main(String[] args) {
		File file = new File("c://windows//system.ini");
		FileReader fr = null;
		Scanner scan = null;
		int count = 1;
		System.out.println(file.getPath() + "파일을 읽어 출력합니다.");
		try {
			fr = new FileReader(file);
			scan = new Scanner(fr);
			String s = "";
			while (scan.hasNext()) {
				s =scan.nextLine();
				System.out.println(count++ +": "+ s);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
