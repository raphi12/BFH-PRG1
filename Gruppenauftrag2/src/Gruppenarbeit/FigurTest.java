/* Gruppenarbeit 02: Morrris Thalmann, Raphael Meyer */
package Gruppenarbeit;

public class FigurTest {

	public static void main(String[] args) {
		// Initialisierung Figuren
		Quadrat Quadrat = new Quadrat(50);
		GlDreieck Dreieck = new GlDreieck(50);
		Kreis Kreis = new Kreis(50);

		// 50 erwartet
		System.out.println(Quadrat.getSeite());
		System.out.println(Dreieck.getSeite());
		System.out.println(Kreis.getSeite());

		// 20 erwartet
		Quadrat.setSeite(20);
		Dreieck.setSeite(20);
		Kreis.setSeite(20);
		System.out.println(Quadrat.getSeite());
		System.out.println(Dreieck.getSeite());
		System.out.println(Kreis.getSeite());

		// Test toString()
		System.out.println(Quadrat);
		System.out.println(Dreieck);
		System.out.println(Kreis);

		// Test vergleich Gewicht, erwartet grösser als
		if (Quadrat.vergleichGewicht(Dreieck) == 1) {
			System.out.println("Quadrat grösser als Dreieck");
		} else if (Quadrat.vergleichGewicht(Dreieck) == 0) {
			System.out.println("Quadrat ist gleich gross wie Dreieck");
		} else if (Quadrat.vergleichGewicht(Dreieck) == -1) {
			System.out.println("Quadrat ist kleiner als Dreieck");
		}

		// Test vergleich Gewicht, erwartet kleiner als
		if (Quadrat.vergleichGewicht(Kreis) == 1) {
			System.out.println("Quadrat grösser als Kreis");
		} else if (Quadrat.vergleichGewicht(Kreis) == 0) {
			System.out.println("Quadrat ist gleich gross wie Kreis");
		} else if (Quadrat.vergleichGewicht(Kreis) == -1) {
			System.out.println("Quadrat ist kleiner als Kreis");
		}

		// Test vergleich Gewicht, erwartet gleich gross
		if (Quadrat.vergleichGewicht(Quadrat) == 1) {
			System.out.println("Quadrat1 grösser als Quadrat2");
		} else if (Quadrat.vergleichGewicht(Quadrat) == 0) {
			System.out.println("Quadrat1 ist gleich gross wie Quadrat2");
		} else if (Quadrat.vergleichGewicht(Quadrat) == -1) {
			System.out.println("Quadrat1 ist kleiner als Quadrat2");
		}

		// Initialisieren grosse Figuren
		Quadrat grosseFigur = new Quadrat(99);
		GlDreieck grosseFigur2 = new GlDreieck(99);
		Kreis grosseFigur3 = new Kreis(99);

		// Ausschneiden erwartet nicht möglich
		FertigeFigur FertigeFigur = new FertigeFigur(grosseFigur, Quadrat, Dreieck, Kreis);

		// Ausgabe grössen Grosse Figur nach Ausschnitt
		try {
			System.out.println(FertigeFigur);
		} catch (Exception e) {
			System.out.println("Keine Ausgabe möglich da kein Ausschnitt");
		}

		// Ausschneiden erwartet nicht möglich
		FertigeFigur FertigeFigur2 = new FertigeFigur(grosseFigur, Quadrat, Dreieck, Kreis);

		// Ausgabe grössen Grosse Figur nach Ausschnitt
		try {
			System.out.println(FertigeFigur2);
		} catch (Exception e) {
			System.out.println("Keine Ausgabe möglich da kein Ausschnitt");
		}

		// Ausschneiden erwartet nicht möglich
		FertigeFigur FertigeFigur3 = new FertigeFigur(grosseFigur, Quadrat, Dreieck, Kreis);

		// Ausgabe grössen Grosse Figur nach Ausschnitt
		try {
			System.out.println(FertigeFigur3);
		} catch (Exception e) {
			System.out.println("Keine Ausgabe möglich da kein Ausschnitt");
		}

		// 99 erwartet
		System.out.println(grosseFigur.getSeite());
		System.out.println(grosseFigur2.getSeite());
		System.out.println(grosseFigur3.getSeite());

		// 100 erwartet
		grosseFigur.setSeite(100);
		grosseFigur2.setSeite(100);
		grosseFigur3.setSeite(100);
		System.out.println(grosseFigur.getSeite());
		System.out.println(grosseFigur2.getSeite());
		System.out.println(grosseFigur3.getSeite());

		// Ausschneiden erwartet ok
		FertigeFigur FertigeFigur4 = new FertigeFigur(grosseFigur, Quadrat, Dreieck, Kreis);

		// Ausgabe grössen Grosse Figur nach Ausschnitt erwartet gewicht neu 8170 umfang
		// neu 134
		try {
			System.out.println(FertigeFigur4);
		} catch (Exception e) {
			System.out.println("Keine Ausgabe möglich da kein Ausschnitt");
		}
		
		FertigeFigur FertigeFigur5 = new FertigeFigur(grosseFigur2, Quadrat, Dreieck, Kreis);

		// Ausgabe grössen Grosse Figur nach Ausschnitt erwartet gewicht neu 2500 umfang
		// neu 34
		try {
			System.out.println(FertigeFigur5);
		} catch (Exception e) {
			System.out.println("Keine Ausgabe möglich da kein Ausschnitt");
		}
		
		FertigeFigur FertigeFigur6 = new FertigeFigur(grosseFigur3, Quadrat, Dreieck, Kreis);

		// Ausgabe grössen Grosse Figur nach Ausschnitt erwartet gewicht neu 29586 umfang
		// neu 362
		try {
			System.out.println(FertigeFigur6);
		} catch (Exception e) {
			System.out.println("Keine Ausgabe möglich da kein Ausschnitt");
		}

	}
}
