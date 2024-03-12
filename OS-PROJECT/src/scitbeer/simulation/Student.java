package scitbeer.simulation;

public class Student extends Thread{
	private Barrel barrel;
    private String name;

    public Student(Barrel barrel, String name) {
        this.setBarrel(barrel);
        this.name = name;
    }
	/**
	 * @return the barrel
	 */
	public Barrel getBarrel() {
		return barrel;
	}

	/**
	 * @param barrel the barrel to set
	 */
	public void setBarrel(Barrel barrel) {
		this.barrel = barrel;
	}
	
	public void run() {
        while (true) {
            synchronized (barrel) {
                while (barrel.getServings() == 0) {
                    try {
                        System.out.println(name + " is waiting for beer...");
                        barrel.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                barrel.takeServing();
                System.out.println(name + " got a serving and is now drinking and thinking...");

                try {
                    Thread.sleep(2000); // Time taken for students to think between drinks
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                barrel.notify(); // Notify bartender if barrel is no longer empty
            }
        }
    }
}
	 
    
    
    
    
    
    
    
    
    
    
    
    
    
    

	

