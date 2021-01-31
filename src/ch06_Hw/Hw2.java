package ch06_Hw;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.StringTokenizer;

//6번
class Location {
	private String city;
	private String lati;
	private String longi;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getLati() {
		return lati;
	}

	public void setLati(String lati) {
		this.lati = lati;
	}

	public String getLongi() {
		return longi;
	}

	public void setLongi(String longi) {
		this.longi = longi;
	}

	@Override
	public String toString() {
		return String.format("%s\t%s\t%s", city, longi, lati);
	}

}

public class Hw2 {
	static HashMap<String, Location> map = new HashMap<>();
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("도시,경도,위도를 입력하세요");
		while (map.size() < 4) {
			Location lo = new Location();
			System.out.print(">> ");
			String sAll = scan.nextLine();
			StringTokenizer st = new StringTokenizer(sAll, ",");
			lo.setCity(st.nextToken().trim());
			lo.setLongi(st.nextToken().trim());
			lo.setLati(st.nextToken().trim());
			map.put(lo.getCity(), lo);
		}
		System.out.println("-----------------");
		Iterator<String> keys = map.keySet().iterator();
		while (keys.hasNext()) {
			System.out.println(map.get(keys.next()));
		}
		System.out.println("-------------------");
		boolean done = false;
		while (!done) {
			System.out.print("도시 이름 >> ");
			String keyword = scan.nextLine();
			Iterator<String> keys2 = map.keySet().iterator();
			while (keys2.hasNext()) {
				if(keyword.equals("그만")){
					done = true;
					break;
				} else if (keyword.equals(keys2.next())) {
					System.out.println(map.get(keyword));
					break;
				} else if (!(keys2.hasNext())) {
					System.out.println(keyword + "는 없습니다");
				}

			}
		}
	}
}
