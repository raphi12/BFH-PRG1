/* Gruppenarbeit 02: Morrris Thalmann, Raphael Meyer */
package Gruppenarbeit;

public abstract class Figur {
	public abstract double umfang();

	public abstract double flaeche();

	public abstract double getSeite();

	public abstract void setSeite(double seite);

	public abstract String toString();

	public double gewicht() { // Gewicht=Fläche, wenn nichts ausgesägt
		return flaeche();
	}

	public double kante() {
		return umfang(); // Kantenlänge=Umfang, wenn nichts ausgesägt
	}

	public int vergleichGewicht(Figur andere) {
		if (this.gewicht() > andere.gewicht()) {
			return 1;
		} else if (this.gewicht() == andere.gewicht()) {
			return 0;
		} else {
			return -1;
		}
	}
}

class GlDreieck extends Figur { // Gleichseitiges Dreieck
	private double seite;

	public GlDreieck(double seite) {
		this.seite = seite;
	}

	public double umfang() {
		return 3 * this.seite;
	}

	public double flaeche() { // gemäss Formel
		return this.seite * this.seite * Math.sqrt(3) / 4.0;
	}

	public String toString() {
		return "Gl. Dreieck: Seitenlänge=" + this.seite + " Umfang=" + umfang() + " Fläche=" + flaeche();
	}

	public void setSeite(double NeueSeite) {
		this.seite = NeueSeite;
	}

	public double getSeite() {
		return this.seite;
	}
}

class Quadrat extends Figur {
	private double seite;

	public Quadrat(double seite) {
		this.seite = seite;
	}

	public double umfang() {
		return 4 * this.seite;
	}

	public double flaeche() {
		return this.seite * this.seite;
	}

	public String toString() {
		return "Quadrat: Seitenlänge=" + this.seite + " Umfang=" + umfang() + " Fläche=" + flaeche();
	}

	public void setSeite(double NeueSeite) {
		this.seite = NeueSeite;
	}

	public double getSeite() {
		return this.seite;
	}
}

class Kreis extends Figur {
	private double radius;

	public Kreis(double radius) {
		this.radius = radius;
	}

	public double umfang() {
		return 2 * radius * Math.PI;
	}

	public double flaeche() {
		return this.radius * this.radius * Math.PI;
	}

	public String toString() {
		return "Kreis: Radius=" + this.radius + " Umfang=" + umfang() + " Fläche=" + flaeche();
	}

	public void setSeite(double NeuerRadius) {
		this.radius = NeuerRadius;
	}

	public double getSeite() {
		return this.radius;
	}

}

class FertigeFigur extends Figur {
	private Figur grosseFigur;
	private Quadrat kleinesQuadrat;
	private GlDreieck kleinesDreieck;
	private Kreis kleinerKreis;

	public void setSeite(double seite) {
		grosseFigur.setSeite(seite);
	}

	public double getSeite() {
		return grosseFigur.getSeite();
	}

	public double umfang() {
		return grosseFigur.umfang();
	}

	public double flaeche() {
		return grosseFigur.flaeche();
	}

	public double gewicht() {
		return grosseFigur.flaeche() - kleinesQuadrat.flaeche() - kleinesDreieck.flaeche() - kleinerKreis.flaeche();
	}

	public double kante() {
		return grosseFigur.kante() - kleinesQuadrat.kante() - kleinesDreieck.kante() - kleinerKreis.kante();
	}

	public boolean pruefeGroesse(Figur grosseFigur, Quadrat kleinesQuadrat, GlDreieck kleinesDreieck,
			Kreis kleinerKreis) {
		boolean b;
		if (grosseFigur.getSeite() * 0.2 < kleinesQuadrat.getSeite()
				|| grosseFigur.getSeite() * 0.2 < kleinesDreieck.getSeite()
				|| grosseFigur.getSeite() * 0.2 < kleinerKreis.getSeite()) {
			b = false;
		} else {
			b = true;
		}
		return b;
	}

	public String toString() {
		return "Umfang grosse Figur: " + umfang() + " flaeche grosse Figur: " + flaeche()
				+ " Gewicht grosse Figur abzüglich 3 Ausschnitte: " + gewicht()
				+ " Umfang grosse Figur abzg. 3 Ausschnitte: " + kante();
	}

	public FertigeFigur(Figur grosseFigur, Quadrat kleinesQuadrat, GlDreieck kleinesDreieck, Kreis kleinerKreis) {
		boolean b = pruefeGroesse(grosseFigur, kleinesQuadrat, kleinesDreieck, kleinerKreis);
		if (b == true) {
			System.out.println("Kleine Figuren können ausgeschnitten werden");
			this.grosseFigur = grosseFigur;
			this.kleinesQuadrat = kleinesQuadrat;
			this.kleinesDreieck = kleinesDreieck;
			this.kleinerKreis = kleinerKreis;
		} else if (b == false) {
			System.out.println("Kleine Figuren können nicht ausgeschnitten werden");
		}

	}
}
