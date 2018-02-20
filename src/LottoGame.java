import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class LottoGame {

	public static void main(String[] args) {

		System.out.println("Wprowadź pierszą liczbę: ");
		int liczbaJeden = getLottoNumber();

		System.out.println("Wprowadź drugą liczbę: ");
		int liczbaDwa = getLottoNumber();

		while (liczbaDwa == liczbaJeden) {
			System.out.println("Wprowadź liczbę 2 różną od pozostałych: ");
			liczbaDwa = getLottoNumber();
		}

		System.out.println("Wprowadź trzecią liczbę: ");
		int liczbaTrzy = getLottoNumber();

		while (liczbaTrzy == liczbaDwa || liczbaTrzy == liczbaJeden) {
			System.out.println("Wprowadź liczbę 3 różną od pozostałych: ");
			liczbaTrzy = getLottoNumber();
		}

		System.out.println("Wprowadź czwartą liczbę: ");
		int liczbaCztery = getLottoNumber();

		while (liczbaCztery == liczbaTrzy || liczbaCztery == liczbaDwa || liczbaCztery == liczbaJeden) {
			System.out.println("Wprowadź liczbę 4 różną od pozostałych: ");
			liczbaCztery = getLottoNumber();
		}
		System.out.println("Wprowadź piątą liczbę: ");
		int liczbaPiec = getLottoNumber();

		while (liczbaPiec == liczbaCztery || liczbaPiec == liczbaTrzy || liczbaPiec == liczbaDwa
				|| liczbaPiec == liczbaJeden) {
			System.out.println("Wprowadź liczbę 5 różną od pozostałych: ");
			liczbaPiec = getLottoNumber();
		}
		System.out.println("Wprowadź szóstą liczbę: ");
		int liczbaSzesc = getLottoNumber();

		while (liczbaSzesc == liczbaPiec || liczbaSzesc == liczbaPiec || liczbaSzesc == liczbaCztery
				|| liczbaSzesc == liczbaTrzy || liczbaSzesc == liczbaDwa || liczbaSzesc == liczbaJeden) {
			System.out.println("Wprowadź liczbę 6 różną od pozostałych: ");
			liczbaSzesc = getLottoNumber();
		}
		int[] wprowadzoneLiczby = { liczbaJeden, liczbaDwa, liczbaTrzy, liczbaCztery, liczbaPiec, liczbaSzesc };
		Arrays.sort(wprowadzoneLiczby);
		System.out.println("Twoje wprowadzone liczby to: "
				+ Arrays.toString(wprowadzoneLiczby).substring(1, Arrays.toString(wprowadzoneLiczby).length() - 1)
				+ ".");

		Random r = new Random();
		int min = 1;
		int max = 49;
		
		// tablica unikalnych wylosowań
		int[] wylosowaneLiczby = new int[wprowadzoneLiczby.length];
		wylosowaneLiczby[0] = r.nextInt((max - min) + 1) + min;

		// po wylosowaniu tworzona jest lista wykluczeń celem uniknięcia powtórzeń
		ArrayList<Integer> czyZawiera = new ArrayList<>();
		czyZawiera.add(wylosowaneLiczby[0]);
		
		for (int i = 1; i < wylosowaneLiczby.length; i++) {
			wylosowaneLiczby[i] = r.nextInt((max - min) + 1) + min;
			while (czyZawiera.contains(wylosowaneLiczby[i])) {
				wylosowaneLiczby[i] = r.nextInt((max - min) + 1) + min;
			}
			czyZawiera.add(wylosowaneLiczby[i]);
		}

		Arrays.sort(wylosowaneLiczby);
		System.out.println("LOTTO wylosowało liczby: "
				+ Arrays.toString(wylosowaneLiczby).substring(1, Arrays.toString(wylosowaneLiczby).length() - 1) + ".");

		int trafienia = 0;

		for (int i = 0; i < wylosowaneLiczby.length; i++) {
			for (int j = 0; j < wprowadzoneLiczby.length; j++) {
				if (wylosowaneLiczby[i] == wprowadzoneLiczby[j]) {
					trafienia++;
				}
			}
		}
		if (trafienia == 0) {
			System.out.println("Niestety nie trafiłeś żadnej liczby.");
		}
		if (trafienia == 1) {
			System.out.println("Trafiłeś JEDNĄ liczbę.");
		}
		if (trafienia == 2) {
			System.out.println("Trafiłeś DWIE liczby.");
		}
		if (trafienia == 3) {
			System.out.println("Gratuluję! Trafiłeś TRÓJKĘ! Wygrywasz żółwika od dewelopera...");
		}
		if (trafienia == 4) {
			System.out.println("Gratuluję! Trafiłeś CZWÓRKĘ!");
		}
		if (trafienia == 5) {
			System.out.println("Gratuluję! Trafiłeś PIĄTKĘ!");
		}
		if (trafienia == 6) {
			System.out.println("WOW!!! TRAFIŁEŚ SZÓSTKĘ!!!!");
		}
	}

	static int getLottoNumber() {
		Scanner sc = new Scanner(System.in);

		while (true) {
			if (sc.hasNextInt()) {
				int points = sc.nextInt();
				if (points >= 1 && points <= 49) {
					return points;
				} else {
					System.out.println("Wprowadź poprawną liczbę (1-49):");
					sc.nextLine();
				}
			} else {
				System.out.println("Wprowadź poprawną liczbę (1-49):");
				sc.nextLine();
			}
		}
	}
}
