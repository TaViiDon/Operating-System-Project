package scitbeer.simulation;

public class Bartender extends Thread {
	private Barrel barrel;
    private int wakeCount;

    public Bartender(Barrel barrel) {
        this.barrel = barrel;
        this.wakeCount = 0;
    }
    public void run() {
        while (true) {
            synchronized (barrel) {
                if (barrel.getServings() == 0) {
                    barrel.refillBarrel();
                    System.out.println("Bartender refilled the barrel.");
                    wakeCount++;
                }
                try {
                    Thread.sleep(1000); // Bartender checks the barrel every second
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
	
	

}
