/*
 * Student: Raul A. Mena
 * Professor: Dr. Roach
 * Course CS3331
 * Institution: University of Texas at El Paso
 * Due Date: 09/09/2019
 * Program_1
 * 
 * Modify Date:
 * 09/08/19 Create the class Car , Driver , and Student
 * 09/09/19 Create the method startDring in class Student
 * 09/09/19 Create the algorithm to print the location, speed, and time
 * 09/09/19 Create start method this will compute the speed, and location of the car
 * 09/09/19 Create method compVelocity() and compLocation()
 * 09/09/19 Create the method phaseOne, phaseTwo, and phaseFinal
 * 09/09/19 Include a boolean in phaseFinal to know when to stop the car
 * 09/10/19 Inlcuding a boolean did not work for the finish line
 * 09/10/19 Create a phase with an integer for the start of car 1, 2 , and 3.
 * 09/12/19 Create a printData() method to print the table with the information
 * 
 * Description: The program is going to print the three car's time, speed, and location 
 * every 30 seconds. Each car start accelerating one minute apart from every car.
 * 
 */

/*
 * 
 */

public class Car {

	public static void main(String args[]) {
		double acceleration = 10.23;//(f/s/s)

		Student A = new Student("A");
		Student B = new Student("B");
		Student C = new Student("C");
		
		Instructor calc = new Instructor();
		
		calc.start(A, B, C);
		
	}

}
