import de.ur.mi.bouncer.apps.BouncerApp;
import de.ur.mi.bouncer.apps.BouncerLauncher;

public class DasErsteHindernis extends BouncerApp {

	@Override
	public void bounce() {
		loadMap("Obstacles");
	}

	public static void main(String[] args) {
		BouncerLauncher.launch("DasErsteHindernis");
	}
}
