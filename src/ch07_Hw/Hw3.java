package ch07_Hw;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Hw3 {
	public static void main(String[] args) {
		File file = new File("c://windows//system.ini");
		FileReader fr = null;
		try {
			fr = new FileReader(file);
			int c;
			while ((c = fr.read()) != -1) {
				char a = (char) c;
				a = Character.toUpperCase(a);
				System.out.print(a);
			}
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
