/* Gruppenarbeit 01: Morrris Thalmann, Raphael Meyer, Yan Müller*/
import java.util.Scanner;
import java.util.ArrayList;

public class Würfel_Münzenwurf {
	public static Scanner user_input = new Scanner(System.in);

	public static void main(String[] args) {
		boolean wiederholen = true;
		ArrayList muenze = new ArrayList() {
			{
				add("K");
				add("Z");
			}
		};
		//Solange wiederholen true ist, wird der Block durchgeführt.
		while (wiederholen == true) {
			ArrayList resultate = new ArrayList();
			System.out.println("Wüfel und Münzenspiel");
			System.out.println("Wählen sie das Spiel aus: w für Würfel, m für Münze und q zum beenden");
			String spiel = get_input();
			int anzahl;
			int summe = 0;
			/*
			 * Für das Würfelspiel wird die Methote get int() aufgerufen, und die Anzahl,
			 * wie oft gespielt werden soll der variable anzahl zugewiesen. Anschliessend
			 * wird die Summe und der Durchschnitt der Würfe berechnet und ausgegeben
			 */
			if (spiel.equals("w")) {
				anzahl = get_int();
				System.out.println("Sie haben sich für das Würfelspiel entschieden.");
				for (int i = 0; anzahl > i; i++) {
					int rand = (int) (Math.random() * 6 + 1);
					summe = summe + rand;
					System.out.println("Ergebnis: " + rand);
				}
				double durchschnitt = (double) summe / (double) anzahl;
				System.out.printf("\nZusammenfassung: Anzahl der Würfe = %d Summe = %d Durchschnitt = %.2f\n", anzahl,
						summe, durchschnitt);
				/*
				 * Für das Münzenspiel wird die Methote get int() aufgerufen, und die Anzahl,
				 * wie oft gespielt werden soll der variable anzahl zugewiesen. Anschliessend
				 * wird die Summe und der Durchschnitt der Würfe berechnet und ausgegeben
				 */
			} else if (spiel.equals("m")) {
				System.out.println("Sie haben sich für das Münzenspiel entschieden.");
				anzahl = get_int();
				//Wenn random = 1 dann Kopf, wenn =2 dann Zahl, wird ins Resultat geschrieben
				for (int i = 0; anzahl > i; i++) {
					int rand = (int) (Math.random() * 2);
					resultate.add(muenze.get(rand));
					System.out.println("Ergebnis: " + muenze.get(rand));
				}
				//Methodenaufruf und die Anzahl Kopf und Zahl Würfe wird ausgegeben
				int countz = get_count(resultate, "Z", anzahl);
				int countk = get_count(resultate, "K", anzahl);
				System.out.printf("\nZusammenfassung: Anzahl der Würfe = %d Kopf:Zahl = %d:%d\n", anzahl, countk,

						countz);
				//Wenn eingabe = q, dann ist das Spiel beendet
			} else if (spiel.equals("q")) {
				break;
			}
			wiederholen = get_bool();
		}
		System.out.println("Das Spiel ist beendet");
	}

//Userinput auslesen und methode check_input aufrufen
	public static String get_input() {
		String user_input_value = user_input.nextLine();
		String checked_user_input_value = check_input(user_input_value);
		return checked_user_input_value;
	}

//überprüft, ob w, m oder q eingegeben wurde
	public static String check_input(String s) {
		if (!(s.length() == 1 && (s.equals("w") || s.equals("m") || s.equals("q")))) {
			System.out.println("Eingabe falsch, bitte w, m oder q eingben");
			s = get_input();
		}
		return s;
	}

// Int lesen und überprüfen nach Int
	public static int get_int() {
		String str;
		System.out.println("Wie oft soll gespielt werden?");
		while (true) {
			str = user_input.nextLine();
			if(str.isEmpty()) {
				return 1;
			}
			if ( isInt(str) == false) {
				System.out.println(str + " ist kein int");
				System.out.println("Bitte geben sie eine ganze Zahl ein: ");				
			}
			else {
				break;
			}
			
		}
		return Integer.parseInt(str);
	}

//Abfrage, ob man nochmals spielen will. Solange z true ist wird wiederholt. 
	// Wenn Eingabe j oder n ist, gibt ein true oder false zurück
	public static boolean get_bool() {
		boolean b = false;
		boolean z = true;
		System.out.println("Wollen sie nochmal Spielen? j für ja und n für nein");
		while (z == true) {
			String str = user_input.nextLine();
			if (str.equals("j")) {
				b = true;
				z = false;
			} else if (str.equals("n")) {
				b = false;
				z = false;
			} else {
				System.out.println(str + " ist keine gültige Eingabe");
				System.out.println("Bitte geben sie j oder n ein: ");
			}
		}
		return b;
	}

	// Zählt, wie oft Kopf und wie oft Zahl im Resultat vorkommen
	public static int get_count(ArrayList resultate, String str, int anzahl) {
		int c = 0;
		for (int i = 0; i < anzahl; i++) {
			if (str.equals(resultate.get(i))) {
				c++;
			}
		}
		return c;
	}
	//Prüfen ob Input int ist
	public static boolean isInt(String strNum) {
		try {
			int i = Integer.parseInt(strNum);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}
}