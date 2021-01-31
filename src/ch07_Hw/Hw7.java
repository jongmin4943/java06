package ch07_Hw;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Hw7 {
	public static void main(String[] args) {
		File file = new File("a.jpg");
		File file2 = new File("b.jpg");
		FileInputStream in = null;
		FileOutputStream out = null;

		try {
			if (!(file2.exists())) {
				file2.createNewFile();
			}
			in = new FileInputStream(file);
			out = new FileOutputStream(file2);
			int c = 0;	//복사할 바이트 index
			int cnt = 0;	//10단위로 쪼개기
			int done = 0;	//10%단위
			byte[] b = in.readAllBytes();
			int process = b.length/10;
			byte[] a = new byte[process];
			while(done<10) {
				out.write(b[c++]);
				a[cnt++] = 1;
				if(a[process-1] == 1) {
					System.out.print("*");
					a = new byte[process];
					done++;
					cnt = 0;
				}
			}
			in.close();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
