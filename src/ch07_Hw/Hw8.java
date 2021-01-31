package ch07_Hw;

import java.io.File;

public class Hw8 {
	public static void main(String[] args) {
		File file = new File("c:/");
		File[] f = file.listFiles();
		long max = 0l;
		File biggestF = null;
		for(int i = 0; i < file.list().length; i++) {
			if(!(f[i].isFile())) {
				continue;
			}
			long size = f[i].length();
			if(size > max) {
				max = size;
				biggestF = f[i];
			}
		}
		System.out.println("가장 큰 파일은 " + biggestF.getName() + max + "바이트");
	}
}
