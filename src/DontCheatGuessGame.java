import java.util.Scanner;

public class DontCheatGuessGame {

	public static void main(String[] args) {

		System.out.println(
				"Czy jesteś gotowy aby zagrać? Jeśli tak to pomyśl o liczbie w zakresie od 0 do 1000, a ja będę musiał zgadnąć w max 10 próbach.");
		System.out.println("Wpisz \'tak\' jeśli jesteś gotowy.");
		String wantToPlay = yesOrNo();

		while (wantToPlay.equals("tak")) {

			int min = 0;
			int max = 1000;
			for (int i = 0; i < 11; i++) {
				int guess = ((max - min) / 2) + min;
				System.out.println(
						"Próba nr." + (i + 1) + ": Zgaduję..... " + guess + ". Czy zgadłem? Wpisz zgadles/mniej/wiecej");
				String answer = ourAnswer();
				if (i != 9 && answer.equals("mniej")) {
					max = guess;
				} else if (i != 9 && answer.equals("wiecej")) {
					min = guess;
				} else if (answer.equals("zgadles")) {
					System.out.println("!!! Wygrałem !!!" + "\n");
					break;
				} else if (i == 9 && guess != 999){
					System.out.println("!!! Nie oszukuj !!!" + "\n");
					break;
				} else {
					System.out.println("!!! Zgaduję 1000 !!!" + "\n");
					break;
				}
			}
			System.out.println(
					"Czy chcesz zagrać jeszcze raz? Jeśli tak to pomyśl o liczbie w zakresie od 0 do 1000, a ja będę musiał zgadnąć w max 10 próbach.");
			System.out.println("Wpisz \'tak\' jeśli jesteś gotowy, lub \'nie\', aby zakończyć grę.");
			wantToPlay = yesOrNo();
		}
		System.out.println("Dziękuję za grę!");
	}

	public static String ourAnswer() {
		Scanner sc = new Scanner(System.in);
		String answer = sc.nextLine();

		while (!(answer.equals("wiecej")) && !(answer.equals("mniej")) && !(answer.equals("zgadles"))
				|| answer.contains(" ")) {
			System.out.println("Wprowadź poprawną odpowiedź (wiecej, mniej, zgadles):");
			answer = sc.nextLine();
		}
		return answer;
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
