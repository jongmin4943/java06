package ch06_Hw;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

class Word {
	private String kor;
	private String eng;

	public Word(String eng, String kor) {
		this.kor = kor;
		this.eng = eng;
	}

	public String getKor() {
		return kor;
	}

	public void setKor(String kor) {
		this.kor = kor;
	}

	public String getEng() {
		return eng;
	}

	public void setEng(String eng) {
		this.eng = eng;
	}

	@Override
	public String toString() {
		return getKor();
	}
}

class Game {
	Random ran = new Random();

	public void start(ArrayList<Word> arr) {
		Scanner scan = new Scanner(System.in);
		while (true) {
			int ansOfIndex = ran.nextInt(arr.size());
			String que = arr.get(ansOfIndex).getEng();
			String ans = arr.get(ansOfIndex).getKor();
			String wrong1 = arr.get(ran.nextInt(arr.size())).getKor();
			String wrong2 = arr.get(ran.nextInt(arr.size())).getKor();
			String wrong3 = arr.get(ran.nextInt(arr.size())).getKor();
			System.out.println(que + "?");
			while (ans.equals(wrong1)) {
				wrong1 = arr.get(ran.nextInt(arr.size())).getKor();
			}
			while (ans.equals(wrong2) || wrong2.equals(wrong1)) {
				wrong2 = arr.get(ran.nextInt(arr.size())).getKor();
			}
			while (ans.equals(wrong3) || wrong3.equals(wrong1) || wrong3.equals(wrong2)) {
				wrong3 = arr.get(ran.nextInt(arr.size())).getKor();
			}
			int order = (ran.nextInt(4) + 1);
			if (order == 1) {
				System.out.printf("(1)%s (2)%s (3)%s (4)%s >> ", ans, wrong1, wrong2, wrong3);
				String guess = scan.nextLine();
				if (guess.equals("-1"))
					break;
				if (guess.equals("1")) {
					System.out.println("정답 !!");
				} else {
					System.out.println("오답 ㅠㅠ");
				}
			} else if (order == 2) {
				System.out.printf("(1)%s (2)%s (3)%s (4)%s >> ", wrong1, ans, wrong2, wrong3);
				String guess = scan.nextLine();
				if (guess.equals("-1"))
					break;
				if (guess.equals("2")) {
					System.out.println("정답 !!");
				} else {
					System.out.println("오답 ㅠㅠ");
				}
			} else if (order == 3) {
				System.out.printf("(1)%s (2)%s (3)%s (4)%s >> ", wrong1, wrong2, ans, wrong3);
				String guess = scan.nextLine();
				if (guess.equals("-1"))
					break;
				if (guess.equals("3")) {
					System.out.println("정답 !!");
				} else {
					System.out.println("오답 ㅠㅠ");
				}
			} else if (order == 4) {
				System.out.printf("(1)%s (2)%s (3)%s (4)%s >> ", wrong1, wrong2, wrong3, ans);
				String guess = scan.nextLine();
				if (guess.equals("-1"))
					break;
				if (guess.equals("4")) {
					System.out.println("정답 !!");
				} else {
					System.out.println("오답 ㅠㅠ");
				}
			}
		}
	}

}

class Quiz {
	Scanner scan = new Scanner(System.in);
	public ArrayList<Word> create(ArrayList<Word> arr) {
		System.out.println("그만을 입력하면 종료합니다");
		while (true) {
			System.out.print("영어 한글 입력 >> ");
			String eng = scan.next().trim();
			if (eng.equals("그만"))
				break;
			String kor = scan.next().trim();
			arr.add(new Word(eng, kor));
		}
		return arr;
	}
}

public class Hw7 {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("\"명품언어\"의 단어 테스트를 시작합니다.");
		ArrayList<Word> arr = new ArrayList<>();
		while (true) {
			System.out.println("단어테스트:1, 단어 삽입:2, 종료:3>> ");
			String choice = scan.nextLine();
			if (choice.equals("1")) {
				if (arr != null && arr.size() > 0) {
					int count = arr.size();
					System.out.println("현재 " + count + "개의 단어가 들어 있습니다. -1 입력시 종료");
					Game game = new Game();
					game.start(arr);
				} else {
					System.out.println("현재 입력된 단어가 없습니다.");
				}
				continue;
			} else if (choice.equals("2")) {
				Quiz quiz = new Quiz();
				arr = quiz.create(arr);
				continue;
			} else if (choice.equals("3")) {
				System.out.println("종료합니다");
				break;
			} else {
				System.out.println("잘못된 입력입니다.");
				continue;
			}
		}
	}
}
