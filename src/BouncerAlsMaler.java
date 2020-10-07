import de.ur.mi.bouncer.apps.BouncerApp;
import de.ur.mi.bouncer.world.fields.FieldColor;
import de.ur.mi.bouncer.apps.BouncerLauncher;

public class BouncerAlsMaler extends BouncerApp {

    /**
     * Bouncer bewegt sich in einen Raum und streicht die Wände rot.
     * Vorbedingung: Bouncer steht auf dem Boden, nach Osten ausgerichtet.
     * Nachbedingung: Bouncer steht auf der rechten Seite der Karte, nach Osten ausgerichtet.
     */
    @Override
    public void bounce() {
        loadMap("Painter");
        enterRoom();
        paintRoom();
    }

    /**
     * Bouncer bewegt sich von seiner Ausgangsposition zur Türöffnung.
     * Vorbedingung: Bouncer steht auf dem Boden, nach Osten ausgerichtet.
     * Nachbedingung: Bouncer steht auf dem Boden (in der Türöffnung), nach Osten ausgerichtet.
     */
    private void enterRoom() {
        while(bouncer.canMoveLeft()) {
            bouncer.move();
        }
    }

    /**
     * Bouncer streicht die Wände rot an.
     * Vorbedingung: Bouncer steht auf dem Boden (in der Türöffnung), nach Osten ausgerichtet.
     * Nachbedingung: Bouncer steht auf der rechten Seite der Karte, nach Osten ausgerichtet.
     */
    private void paintRoom() {
        while(bouncer.canMoveForward()) {
            moveToNextLane();
            paintLane();
        }
    }

    /**
     * Bouncer malt alle Felder in der aktuellen Spur (vom Boden bis zur Decke).
     * Vorbedingung: Bouncer steht auf dem Boden (im Raum), nach Osten gerichtet.
     * Nachbedingung: Bouncer steht auf dem Boden (im Raum), nach Osten gerichtet.
     */
    private void paintLane() {
        bouncer.turnLeft();
        while(bouncer.canMoveForward()) {
            bouncer.paintField(FieldColor.RED);
            bouncer.move();
        }
        bouncer.paintField(FieldColor.RED);
        turnAround();
        while(bouncer.canMoveForward()) {
            bouncer.move();
        }
        bouncer.turnLeft();
    }

    /**
     * Bouncer bewegt sich auf die nächste Spur.
     * Vorbedingung: Bouncer steht auf dem Boden (im Raum), nach Osten gerichtet.
     * Nachbedingung: Bouncer steht auf dem nächsten Feld, nach Osten ausgerichtet.
     */
    private void moveToNextLane() {
        bouncer.move();
    }

    /**
     * Bouncer dreht sich um
     * Vorbedingung: Bouncer steht auf einem beliebigen Feld und zeigt in eine beliebige Richtung.
     * Nachbedingung: Bouncer steht auf dem gleichen Feld und zeigt in die entgegengesetzte Richtung.
     */
    private void turnAround() {
        bouncer.turnLeft();
        bouncer.turnLeft();
    }

	public static void main(String[] args) {
        BouncerLauncher.launch("BouncerAlsMaler");
	}
}
