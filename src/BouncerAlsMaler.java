import de.ur.mi.bouncer.apps.BouncerApp;
import de.ur.mi.bouncer.apps.BouncerLauncher;

public class BouncerAlsMaler extends BouncerApp {

	@Override
	public void bounce() {
		loadMap("Painter");
	}

	public static void main(String[] args) {
        BouncerLauncher.launch("BouncerAlsMaler");
	}
}
