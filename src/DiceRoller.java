import java.util.Random;
import java.util.Scanner;

public class DiceRoller {

	public static void main(String[] args) {

		String formula = rollFormulaBuilder();
		if (formula.charAt(formula.length()-1) == '0') {
			System.out.println("Wykonujesz rzut: " + formula.substring(0, formula.length()-2));
		} else {			
			System.out.println("Wykonujesz rzut: " + formula);
		}
		System.out.println("Twój wynik to: " + diceRollResult(formula));
	}

	public static String rollFormulaBuilder() {
		System.out.println("Wprowadź rzut kością w formacie xDy+z, gdzie: ");
		StringBuilder sb = new StringBuilder();
		sb.append(howManyRolls());
		sb.append("D" + diceType());
		sb.append(resultModifier());
		return sb.toString();
	}

	public static int diceRollResult(String formula) {
		Random r = new Random();

		int howManyRolls = Integer.parseInt(formula.substring(0, formula.indexOf('D')));
		int diceType = Integer.parseInt(formula.substring(formula.indexOf('D') + 1, diceTypeIndex(formula)));
		int modifier = Integer.parseInt(formula.substring(diceTypeIndex(formula), formula.length()));

		int min = 1;
		int max = diceType;
		int sum = 0;
		int rzut = 0;
		int result = 0;

		for (int i = 0; i < howManyRolls; i++) {
			rzut = r.nextInt((max - min) + 1) + min;
			sum += rzut;
			System.out.println("Rzut nr " + (i + 1) + " to: " + rzut);
		}
		System.out.println("Suma rzutów: " + sum);
		System.out.println("Modifier to: " + modifier);
		result = sum + modifier;
		return result;
	}

	public static String howManyRolls() {
		Scanner sc = new Scanner(System.in);
		System.out.println("x - to jest ilość rzutów daną koscią:");

		while (true) {
			if (sc.hasNextInt()) {
				int result = sc.nextInt();
				if (result > 0) {
					String resultString = String.valueOf(result);
					return resultString;
				} else {
					System.out.println("Wprowadź ile rzutów daną kością (min. 1 rzut): ");
					sc.nextLine();
				}
			} else {
				System.out.println("Wprowadź ile rzutów daną kością (min. 1 rzut): ");
				sc.nextLine();
			}
		}
	}

	public static String diceType() {
		System.out.println("y - to jest rodzaj kości (D3, D4, D6, D8, D10, D12, D20, D100).");
		System.out.println("Podaj samą ilość boków rodzaju kości (dla D3 podaj \'3\'; dla D100 podaj \'100\' itp.): ");
		Scanner sc = new Scanner(System.in);
		while (true) {
			if (sc.hasNextInt()) {
				int d = sc.nextInt();
				if (d == 3 || d == 4 || d == 6 || d == 8 || d == 10 || d == 12 || d == 20 || d == 100) {
					String dice = String.valueOf(d);
					return dice;
				} else {
					System.out.println("Wprowadź poprawny wynik:");
					sc.nextLine();
				}
			} else {
				System.out.println("Wprowadź poprawny wynik:");
				sc.nextLine();
			}
		}
	}

	public static String resultModifier() {
		System.out.println("z - to jest modyfikator wyniku, np. -12, +8, 0, itp.");
		Scanner sc = new Scanner(System.in);
		while (!sc.hasNextInt()) {
			sc.next();
			System.out.println("Podaj modyfikator wyniku: ");
		}
		int modifier = sc.nextInt();
		String stringMod = "";
		if (modifier > 0) {
			stringMod = "+" + String.valueOf(modifier);
		} else if (modifier < 0) {
			stringMod = "" + String.valueOf(modifier);
		} else {
			stringMod = "+0";
		}
		return stringMod;
	}

	static int diceTypeIndex(String formula) {
		int index = 0;

		String[] allElements = new String[formula.length()];

		for (int i = 0; i < allElements.length; i++) {
			allElements[i] = String.valueOf(formula.charAt(i));
		}
		for (int i = 0; i < allElements.length; i++) {
			if (allElements[i].equals("+") || allElements[i].equals("-")) {
				index = i;
				break;
			} else {
				index = formula.length();
			}
		}
		return index;
	}

}