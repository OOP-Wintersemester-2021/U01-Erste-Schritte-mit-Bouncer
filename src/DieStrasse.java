import de.ur.mi.bouncer.apps.BouncerApp;
import de.ur.mi.bouncer.world.fields.FieldColor;
import de.ur.mi.bouncer.apps.BouncerLauncher;

public class DieStrasse extends BouncerApp {

	/**
	 * Bouncer bewegt sich von links nach rechts auf der Karte und repariert beschädigte Felder auf der Straße.
	 * Vorbedingung: Bouncer steht auf der linken Seite der Karte, nach Osten ausgerichtet.
	 * Nachbedingung: Bouncer steht auf der rechten Seite der Karte, nach Osten ausgerichtet.
	 */
	@Override
	public void bounce() {
		loadMap("Strasse");
		checkStreet();
	}

	/**
	 * Bouncer bewegt sich von links nach rechts auf der Karte und repariert beschädigte Felder auf der Straße.
	 * Vorbedingung: Bouncer steht auf der linken Seite der Karte, nach Osten ausgerichtet.
	 * Nachbedingung: Bouncer steht auf der rechten Seite der Karte, nach Osten ausgerichtet.
	 */
	private void checkStreet() {
		while(bouncer.canMoveForward()) {
			checkField();
			bouncer.move();
		}
		 // Zusätzlicher Aufruf von checkField() zur Überprüfung des letzten Feldes, wenn Bouncer vor der Wand stehen bleibt.
		checkField();
	}

	/**
	 * Bouncer überprüft die Farbe des Feldes, auf dem er sich gerade befindet und repariert es bei Bedarf.
	 * Vorbedingung: Bouncer steht auf einem Feld.
	 * Nachbedingung: Bouncer steht auf einem grünen Feld.
	 */
	private void checkField() {
		if(bouncer.isOnFieldWithColor(FieldColor.RED)) {
			repairField();
		}
	}

	/**
	 * Bouncer repariert das Feld, auf dem er gerade steht.
	 * Vorbedingung: Bouncer steht auf einem roten Feld.
	 * Nachbedingung: Bouncer steht auf einem grünen Feld.
	 */
	private void repairField() {
		bouncer.paintField(FieldColor.GREEN);
	}

	public static void main(String[] args) {
		BouncerLauncher.launch("DieStrasse");
	}
}
