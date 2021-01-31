package ch06_Hw;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;

//1번
class HwNo1 {
	static Scanner scan = new Scanner(System.in);

	public static void main() {
		int i = 0;
		int max = 0;
		Vector<Integer> num = new Vector<>();
		System.out.print("정수(-1 : 종료)>>");
		while (i != -1) {
			i = scan.nextInt();
			num.add(i);
		}
		for (int a : num) {
			if (a > max) {
				max = a;
			}
		}
		System.out.print("가장 큰수는 " + max);

	}
}

//2번
class HwNo2 {
	static Scanner scan = new Scanner(System.in);

	public static void main() {
		ArrayList<Character> score = new ArrayList<>();
		char s = ' ';
		double sum = 0;
		System.out.print("6개의 학점을 빈 칸으로 분리 입력(A/B/C/D/F)>>");
		while (score.size() < 6) {
			s = scan.next().trim().charAt(0);
			score.add(s);
		}
		for (char i : score) {
			if (i == 'A') {
				sum += 4.0;
			} else if (i == 'B') {
				sum += 3.0;
			} else if (i == 'C') {
				sum += 2.0;
			} else if (i == 'D') {
				sum += 1.0;
			} else if (i == 'F') {
				sum += 0;
			}
		}
		System.out.println((sum / 6));
	}
}

//3번
class Hw1No3 {
	public static void main() {
		HashMap<String, Integer> nations = new HashMap<>();
		Scanner scan = new Scanner(System.in);
		String nation = "";
		String search = "";
		int popul = 0;
		System.out.println("나라 이름과 인구를 입력하세요.(예 : Korea 5000)");
		while (true) {
			System.out.print("나라 이름, 인구 >>");
			nation = scan.next().trim();
			if (nation.equals("그만")) {
				break;
			}
			popul = scan.nextInt();
			nations.put(nation, popul);
		}
		scan.nextLine();
		while (true) {
			System.out.print("인구 검색 >> ");
			search = scan.nextLine();
			if (search.equals("그만")) {
				break;
			}
			Iterator<String> keys = nations.keySet().iterator();
			while (keys.hasNext()) {
				String key = keys.next();
				if (key.equals(search)) {
					System.out.println(search + "의 인구는 " + nations.get(key));
					break;
				} else if (!(keys.hasNext())) {
					System.out.println(search + "는 없습니다.");
					break;
				}
			}
		}
	}
}

//5번
class Student {
	private String name;
	private String major;
	private String grade;
	private String score;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return String.format("이름 : %s\n학과 : %s\n학번 : %s\n학점평균 : %s", name,major,grade,score);
	}
}

class Hw1No5 {
	static Scanner scan = new Scanner(System.in);
	static ArrayList<Student> arr = new ArrayList<>();
	public static void main() {
		System.out.println("학생 이름,학과,학번,학점평균 입력하세요");
		while(arr.size()<4) {
			Student s = new Student();
			System.out.print(">> ");
			String sAll = scan.nextLine();
			StringTokenizer st = new StringTokenizer(sAll, ",");
			s.setName(st.nextToken().trim());
			s.setMajor(st.nextToken().trim());
			s.setGrade(st.nextToken().trim());
			s.setScore(st.nextToken().trim());
			arr.add(s);
		}
		for(Student s : arr) {
			System.out.println(s);
			System.out.println("---------------");
		}
	}
}
