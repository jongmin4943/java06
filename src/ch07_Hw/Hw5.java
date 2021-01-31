package ch07_Hw;

import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

public class Hw5 {
	public static void main(String[] args) {
		File file = new File("elvis1");
		File file2 = new File("elvis1-복사본");
		FileInputStream in = null;
		FileInputStream in2 = null;
		Scanner scan;
		Scanner scan2;
		boolean same = true;
		System.out.println(file.getName() + "와 " + file2.getName() + "를 비교합니다");
		try {
			in = new FileInputStream(file);
			in2 = new FileInputStream(file2);
			scan = new Scanner(in);
			scan2 = new Scanner(in2);
			while (true) {
				if (scan.hasNext()) {
					if (!(scan.nextLine().equals(scan2.nextLine()))) {
						same = false;
						break;
					}
				}else if (!(scan.hasNext()) && scan2.hasNext()) {
					same = false;
					break;
				} else {
					same = true;
					break;
				}
			}
			if (same) {
				System.out.println("파일이 같습니다.");
			} else {
				System.out.println("파일이 다릅니다.");
			}
			in.close();
			in2.close();
			scan.close();
			scan2.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
