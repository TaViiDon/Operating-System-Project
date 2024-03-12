package scitbeer.simulation;

public class Main {

	public static void main(String[] args) {
		  Barrel barrel = new Barrel(50);
	        Bartender bartender = new Bartender(barrel);
	        bartender.start();

	        // Create and start student threads
	        Student student1 = new Student(barrel, "Student 1");
	        Student student2 = new Student(barrel, "Student 2");
	        Student student3 = new Student(barrel, "Student 3");
	        Student student4 = new Student(barrel, "Student 4");
	        student1.start();
	        student2.start();
	        student3.start();
	        student4.start();
		

	}

}
