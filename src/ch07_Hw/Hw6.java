package ch07_Hw;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Hw6 {
	public static void main(String[] args) {
		File file = new File("elvis1");
		File file2 = new File("elvis2");
		File file3 = new File("appended");
		FileReader fr = null;
		FileWriter fw = null;
		try {
			fr = new FileReader(file);
			fw = new FileWriter(file3);
			int c;
			while((c = fr.read()) != -1) {
				fw.write((char)c);
			}
			fw.write(13); // 줄 바꾸기
			fr = new FileReader(file2);
			while((c = fr.read()) != -1) {
				fw.write((char)c);
			}
			fr.close();
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
