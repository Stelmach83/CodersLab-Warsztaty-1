import java.util.Random;
import java.util.Scanner;

public class GuessNumber {

	public static void main(String[] args) {
		int min = 1;
		int max = 100;
		Random r = new Random();

		System.out.println("Czy jesteś gotowy aby zagrać w Zgadnij Liczbę? (wpisz tak, lub nie)");
		String wantToPlay = yesOrNo();

		while (wantToPlay.equals("tak")) {
			int computersNum = r.nextInt((max - min) + 1) + min;
			System.out.println("Zgadnij liczbę od " + min + " do " + max + ".");
			int guess = userGuess(min, max);

			while (guess != computersNum && wantToPlay.equals("tak")) {
				if (guess < computersNum) {
					System.out.println("Za mało! Spróbuj ponownie: ");
					guess = userGuess(min, max);
				} else {
					System.out.println("Za dużo! Spróbuj ponownie: ");
					guess = userGuess(min, max);
				}
			}
			System.out.println("ZADŁEŚ! Czy chcesz zagrać ponownie? (wpisz tak, lub nie)");
			wantToPlay = yesOrNo();
		}
		System.out.println("Dziękuję za grę!");
	}

	public static int userGuess(int min, int max) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			if (sc.hasNextInt()) {
				int points = sc.nextInt();
				if (points >= min && points <= max) {
					return points;
				} else {
					System.out.println("Wprowadź poprawną liczbę:");
					sc.nextLine();
				}
			} else {
				System.out.println("Wprowadź poprawną liczbę:");
				sc.nextLine();
			}
		}
	}

	public static String yesOrNo() {
		Scanner sc = new Scanner(System.in);
		String answer = sc.nextLine();

		while (!(answer.equals("nie")) && !(answer.equals("tak")) || answer.contains(" ")) {
			System.out.println("Wprowadź poprawną odpowiedź:");
			answer = sc.nextLine();
		}
		return answer;
	}
}
