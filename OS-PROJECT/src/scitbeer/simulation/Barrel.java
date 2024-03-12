package scitbeer.simulation;

public class Barrel {
	private int servings;

    public Barrel(int initialServings) {
        this.servings = initialServings;
    }

    public synchronized int getServings() {
        return servings;
    }

    public synchronized void refillBarrel() {
        servings = 50;
    }

    public synchronized void takeServing() {
        servings--;
    }

}
