import java.util.Random;
import java.util.Scanner;

public class DiceRoller {

	public static void main(String[] args) {

		String formula = rollFormulaBuilder();
		String outp = "";
		int formatowanie = 0;

		if (formula.charAt(formula.length() - 1) == '0' && formula.charAt(formula.length() - 2) == '+') {
			if (formula.charAt(0) == '1' && formula.charAt(1) == 'D') {
				outp = "Wykonujesz rzut: " + formula.substring(1, formula.length() - 2);
				int outpL = outp.length() + 6;
				if (outpL % 2 == 0) {
					outpL = outp.length() + 6 + 1;
				}
				System.out.print("\t");
				for (int i = 0; i < outpL + 2; i++) {
					if (i % 2 != 0) {
						System.out.print(" ");
					} else {
						System.out.print("*");
					}
				}
				System.out.println();
				System.out.print("\t");
				System.out.print("*");
				for (int i = 0; i < (outpL - outp.length()) / 2; i++) {
					System.out.print(" ");
				}
				System.out.print(outp);
				for (int i = ((outpL - outp.length()) / 2) + outp.length(); i < outpL; i++) {
					System.out.print(" ");
				}
				System.out.println("*");
				System.out.print("\t");
				for (int i = 0; i < outpL + 2; i++) {
					if (i == 0 || i == outpL + 2 - 1) {
						System.out.print("*");
					} else {
						if (i % 2 != 0) {
							System.out.print(" ");
						} else {
							System.out.print("-");
						}
					}
				}
				System.out.println();
				formatowanie = outpL;

			} else {
				outp = "Wykonujesz rzut: " + formula.substring(0, formula.length() - 2);
				int outpL = outp.length() + 6;
				if (outpL % 2 == 0) {
					outpL = outp.length() + 6 + 1;
				}
				System.out.print("\t");
				for (int i = 0; i < outpL + 2; i++) {
					if (i % 2 != 0) {
						System.out.print(" ");
					} else {
						System.out.print("*");
					}
				}
				System.out.println();
				System.out.print("\t");
				System.out.print("*");
				for (int i = 0; i < (outpL - outp.length()) / 2; i++) {
					System.out.print(" ");
				}
				System.out.print(outp);
				for (int i = ((outpL - outp.length()) / 2) + outp.length(); i < outpL; i++) {
					System.out.print(" ");
				}
				System.out.println("*");
				System.out.print("\t");
				for (int i = 0; i < outpL + 2; i++) {
					if (i == 0 || i == outpL + 2 - 1) {
						System.out.print("*");
					} else {
						if (i % 2 != 0) {
							System.out.print(" ");
						} else {
							System.out.print("-");
						}
					}
				}
				System.out.println();
				formatowanie = outpL;
			}
		} else {
			if (formula.charAt(0) == '1' && formula.charAt(1) == 'D') {
				outp = "Wykonujesz rzut: " + formula.substring(1, formula.length());
				int outpL = outp.length() + 6;
				if (outpL % 2 == 0) {
					outpL = outp.length() + 6 + 1;
				}
				System.out.print("\t");
				for (int i = 0; i < outpL + 2; i++) {
					if (i % 2 != 0) {
						System.out.print(" ");
					} else {
						System.out.print("*");
					}
				}
				System.out.println();
				System.out.print("\t");
				System.out.print("*");
				for (int i = 0; i < (outpL - outp.length()) / 2; i++) {
					System.out.print(" ");
				}
				System.out.print(outp);
				for (int i = ((outpL - outp.length()) / 2) + outp.length(); i < outpL; i++) {
					System.out.print(" ");
				}
				System.out.println("*");
				System.out.print("\t");
				for (int i = 0; i < outpL + 2; i++) {
					if (i == 0 || i == outpL + 2 - 1) {
						System.out.print("*");
					} else {
						if (i % 2 != 0) {
							System.out.print(" ");
						} else {
							System.out.print("-");
						}
					}
				}
				System.out.println();
				formatowanie = outpL;
			} else {
				outp = "Wykonujesz rzut: " + formula;
				int outpL = outp.length() + 6;
				if (outpL % 2 == 0) {
					outpL = outp.length() + 6 + 1;
				}
				System.out.print("\t");
				for (int i = 0; i < outpL + 2; i++) {
					if (i % 2 != 0) {
						System.out.print(" ");
					} else {
						System.out.print("*");
					}
				}
				System.out.println();
				System.out.print("\t");
				System.out.print("*");
				for (int i = 0; i < (outpL - outp.length()) / 2; i++) {
					System.out.print(" ");
				}
				System.out.print(outp);
				for (int i = ((outpL - outp.length()) / 2) + outp.length(); i < outpL; i++) {
					System.out.print(" ");
				}
				System.out.println("*");
				System.out.print("\t");
				for (int i = 0; i < outpL + 2; i++) {
					if (i == 0 || i == outpL + 2 - 1) {
						System.out.print("*");
					} else {
						if (i % 2 != 0) {
							System.out.print(" ");
						} else {
							System.out.print("-");
						}
					}
				}
				System.out.println();
				formatowanie = outpL;
			}
		}

		String wynik = "Twój wynik to: " + diceRollResult(formula, formatowanie);
		formatowanie = formatowanie + 2;
		int spacer = (formatowanie - wynik.length() - 2) / 2;
		System.out.print("\t");
		for (int i = 0; i < formatowanie; i++) {
			if (i == 0 || i == formatowanie - 1) {
				System.out.print("*");
			} else {
				if (i % 2 != 0) {
					System.out.print(" ");
				} else {
					System.out.print("-");
				}
			}
		}
		System.out.println();
		System.out.print("\t");
		System.out.print("*");
		int counter = 0;
		for (int i = 0; i < spacer; i++) {
			System.out.print(" ");
			counter++;
		}
		System.out.print(wynik);

		for (int i = wynik.length() + counter + 2; i < formatowanie; i++) {
			System.out.print(" ");
		}
		System.out.print("*");
		System.out.println();
		System.out.print("\t");
		for (int i = 0; i < formatowanie; i++) {
			if (i % 2 != 0) {
				System.out.print(" ");
			} else {
				System.out.print("*");
			}
		}
		System.out.println();
	}

	public static String rollFormulaBuilder() {
		System.out.println("Wprowadź rzut kością w formacie xDy+z, gdzie: ");
		StringBuilder sb = new StringBuilder();
		sb.append(howManyRolls());
		sb.append("D" + diceType());
		sb.append(resultModifier());
		return sb.toString();
	}

	public static int diceRollResult(String formula, int formatowanie) {
		Random r = new Random();

		int howManyRolls = Integer.parseInt(formula.substring(0, formula.indexOf('D')));
		int diceType = Integer.parseInt(formula.substring(formula.indexOf('D') + 1, diceTypeIndex(formula)));
		int modifier = Integer.parseInt(formula.substring(diceTypeIndex(formula), formula.length()));

		int min = 1;
		int max = diceType;
		int sum = 0;
		int rzut = 0;
		int result = 0;
		formatowanie = formatowanie + 2;

		for (int i = 0; i < howManyRolls; i++) {
			rzut = r.nextInt((max - min) + 1) + min;
			sum += rzut;
			String rzutNapis = "Rzut nr " + (i + 1) + " to: " + rzut;
			int spacerNapis = (formatowanie - (rzutNapis.length() + 2)) / 2;
			System.out.print("\t");
			System.out.print("*");
			int counter = 0;

			if (rzut < 10 && i < 9) {
				spacerNapis = spacerNapis - 1;
			}
			if (rzut == 100 || i == 99) {
				spacerNapis = spacerNapis + 1;
			}
			if (i == 99 && rzut < 10) {
				spacerNapis = spacerNapis - 1;
			}
			if (rzut == 100 && i < 9) {
				spacerNapis = spacerNapis - 1;
			}
			for (int j = 0; j < spacerNapis; j++) {
				System.out.print(" ");
				counter++;
			}
			System.out.print(rzutNapis);
			for (int j = rzutNapis.length() + counter + 2; j < formatowanie; j++) {
				System.out.print(" ");
			}
			System.out.println("*");
		}

		String sumaRzut = "Suma rzutów: " + sum;
		int spacerRzut = (formatowanie - (sumaRzut.length())) / 2;
		System.out.print("\t");
		System.out.print("*");
		int counter1 = 0;
		if (sum > 99) {
			spacerRzut = spacerRzut + 1;
		}
		for (int i = 0; i < spacerRzut - 2; i++) {
			System.out.print(" ");
			counter1++;
		}
		System.out.print(sumaRzut);
		for (int i = sumaRzut.length() + counter1 + 2; i < formatowanie; i++) {
			System.out.print(" ");
		}
		System.out.println("*");

		if (modifier > 0) {
			String modi = "Modifier to: +" + modifier;
			int spacerModi = (formatowanie - (modi.length())) / 2;
			if (modi.length() > 14 && modifier > 9) {
				spacerModi = spacerModi + 1;
			}
			System.out.print("\t");
			System.out.print("*");
			int counter2 = 0;
			for (int i = 0; i < spacerModi - 2; i++) {
				System.out.print(" ");
				counter2++;
			}
			System.out.print(modi);
			for (int i = modi.length() + counter2 + 2; i < formatowanie; i++) {
				System.out.print(" ");
			}
			System.out.println("*");
		} else {
			String modi = "Modifier to: " + modifier;
			int spacerModi = (formatowanie - (modi.length())) / 2;
			if (modi.length() > 14 && modifier < -9) {
				spacerModi = spacerModi + 1;
			}
			System.out.print("\t");
			System.out.print("*");
			int counter2 = 0;
			for (int i = 0; i < spacerModi - 2; i++) {
				System.out.print(" ");
				counter2++;
			}
			System.out.print(modi);
			for (int i = modi.length() + counter2 + 2; i < formatowanie; i++) {
				System.out.print(" ");
			}
			System.out.println("*");
		}
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
					System.out.println("Wprowadź poprawną ilość boków kości:");
					sc.nextLine();
				}
			} else {
				System.out.println("Wprowadź poprawną ilość boków kości:");
				sc.nextLine();
			}
		}
	}

	public static String resultModifier() {
		System.out.println("z - to jest modyfikator wyniku, np. -12, 8, 0, itp.");
		Scanner sc = new Scanner(System.in);
		while (!sc.hasNextInt()) {
			System.out.println("Podaj modyfikator wyniku: ");
			sc.nextLine();
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