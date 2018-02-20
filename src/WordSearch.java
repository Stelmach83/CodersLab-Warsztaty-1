import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WordSearch {

	public static void main(String[] args) {

		ArrayList<String> linie = new ArrayList<>();
		Connection connectOnet = Jsoup.connect("http://www.onet.pl/");
		try {
			Document document = connectOnet.get();
			Elements links = document.select("span.title");
			for (Element elem : links) {
				StringTokenizer st = new StringTokenizer(elem.text(), "'%():-?!,. \\\"\\n");
				for (int i = 0; i < st.countTokens(); i++) {
					linie.add(st.nextToken());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		Connection connectWp = Jsoup.connect("http://www.gazeta.pl/");
		try {
			Document document1 = connectWp.get();
			Elements links1 = document1.select("span.title");
			for (Element elem : links1) {
				StringTokenizer st = new StringTokenizer(elem.text(), "/'%():-?!,. \"\n");
				for (int i = 0; i < st.countTokens(); i++) {
					linie.add(st.nextToken());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		String[] slowa = new String[linie.size()];
		for (int i = 0; i < slowa.length; i++) {
			slowa[i] = linie.get(i);
		}

		System.out.println("Wprowadź od jakiej minimalnej długości słowa mam szukać (zakres: 3 - 8 liter): ");
		int minLiter = minLiter();

		ArrayList<String> docelowe = new ArrayList<>();
		for (int i = 0; i < linie.size(); i++) {
			if (linie.get(i).length() >= minLiter && !isNumeric(linie.get(i))) {
				docelowe.add(linie.get(i));
			}
		}
		String[] slowaDocelowe = new String[docelowe.size()];

		for (int i = 0; i < slowaDocelowe.length; i++) {
			slowaDocelowe[i] = docelowe.get(i);
		}

		Arrays.sort(slowaDocelowe);

		System.out
				.println("Ilość wszystkich słów, które mają " + minLiter + " liter(y) i więcej: " + slowaDocelowe.length + " słów");

		ArrayList<String> preWynik = new ArrayList<>();
		Arrays.stream(slowaDocelowe).collect(Collectors.groupingBy(s -> s))
				.forEach((k, v) -> preWynik.add(v.size() + " wystąpień: " + k));

		Collections.sort(preWynik);
		Collections.reverse(preWynik);

		System.out.println("Wprowadź ile topowych słów mam wyświetlić (zakres od 5 do 20 topowych słów): ");
		int top = topIle();
		System.out.println("TOP " + top + " SŁÓW TO: ");
		for (int i = 0; i < top; i++) {
			System.out.println(preWynik.get(i));
		}
	}

	static boolean isNumeric(String str) {
		try {
			int i = Integer.parseInt(str);
			return true;
		} catch (Exception e) {
		}
		return false;
	}

	public static int minLiter() {
		Scanner sc = new Scanner(System.in);

		while (true) {
			if (sc.hasNextInt()) {
				int points = sc.nextInt();
				if (points >= 3 && points <= 8) {
					return points;
				} else {
					System.out.println("Wprowadź poprawną liczbę liter w słowie:");
					sc.nextLine();
				}
			} else {
				System.out.println("Wprowadź poprawną liczbę liter w słowie:");
				sc.nextLine();
			}
		}
	}

	public static int topIle() {
		Scanner sc = new Scanner(System.in);

		while (true) {
			if (sc.hasNextInt()) {
				int points = sc.nextInt();
				if (points >= 5 && points <= 20) {
					return points;
				} else {
					System.out.println("Wprowadź poprawną liczbę topowych słów jaką mam znaleźć:");
					sc.nextLine();
				}
			} else {
				System.out.println("Wprowadź poprawną liczbę topowych słów jaką mam znaleźć:");
				sc.nextLine();
			}
		}
	}
}
