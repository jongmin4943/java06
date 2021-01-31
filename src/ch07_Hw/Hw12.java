package ch07_Hw;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class Reader {
	public ArrayList<String> read(File file, ArrayList<String> arr) {
		FileReader fr = null;
		arr = new ArrayList<>();
		try {
			fr = new FileReader(file);
			Scanner scan = new Scanner(fr);
			int c = 0;
			int cnt = 1;
			while ((c = fr.read()) != -1) {
				String s = scan.nextLine();
				arr.add(cnt++ + ": " + s);
			}
			fr.close();
			scan.close();
		} catch (FileNotFoundException e) {
			System.out.println("존재하지 않는 파일입니다. 강제종료합니다.");
			return null;
		} catch (IOException e) {
			System.out.println("잘못된 입력입니다. 강제 종료합니다.");
			return null;
		}
		return arr;
	}
}

class Search {
	Scanner scan = new Scanner(System.in);

	public void find(ArrayList<String> arr) {
		while(true) { 
			System.out.print("검색할 단어나 문장입력>> ");
			int cnt = 0;
			String keyword = scan.nextLine();
			if(keyword.equals("그만")) break;
			for (String a : arr) {
				cnt++;
				if (a.contains(keyword)) {
					System.out.println(a);
					cnt--;
				} else if(cnt == arr.size()) {
					System.out.println("존재하지 않습니다.");
				}
			}
		}
	}
}

public class Hw12 {
	static Scanner scan;
	static ArrayList<String> arr;

	public static void main(String[] args) {
		scan = new Scanner(System.in);
		System.out.println("전체 경로명이 아닌 파일 이름만 입력하는 경우, 파일은 프로젝트 폴더에 있어야 합니다.");
		System.out.print("대상 파일명 입력>> ");
		File file = new File(scan.nextLine());
		Reader rd = new Reader();
		arr = rd.read(file, arr);
		if(arr == null) return;
		Search search = new Search();
		search.find(arr);
	}
}
