import java.lang.Math;
import java.text.DecimalFormat;

public class Instructor {



	public double getInitialVelocity(int phase) {
		//Changing Initial Velocity by checking the phase
		if (phase == 1) {
			return 0;
		}
		else if (phase == 2) {
			return 20;
		}
		else if (phase == 3) {
			return 60;
		}
		return 30;
	}
	
	
	public double getFinalVelocity(int phase) {
		//Changing the final velocity by checking the which phase it is
		if(phase == 1) {
			return 20;
			
		} else if (phase == 2) {
			return 60;
		}
		else if(phase == 3){
			return 30;
		}
		return 30;
	}
	
	public void printData(Student A, Student B, Student C) {
		
		final DecimalFormat df = new DecimalFormat("0.00");


		
		 System.out.println(String.format("%s", "-----------------------------------------"
				 + "-----------------------------------------------"));
		 System.out.println(String.format("%10s %10s %5s %5s %9s %5s %5s %9s %5s %5s %9s", 
				 A.getTime(), "|", A.getFinalVelocity(),df.format(A.calculateDistance()), "|", B.getFinalVelocity(),df.format(B.calculateDistance()),"|",C.getFinalVelocity(),df.format(C.calculateDistance()),"|"));

		
	}
	
	
	public void start(Student A,Student B, Student C) {
		double totalTimeInSeconds = 0.0;
		double increase = 0.01;
		double countsec = 0.0;
		
		final DecimalFormat df = new DecimalFormat("0.00");

		
		//Prints the header of the table
	    System.out.println(String.format("%10s %10s %10s %10s %10s %10s %10s %10s", "Time", "|", "Car " 
	    		+ A.getName(), "|", "Car " + B.getName(),"|","Car " + C.getName(),"|"));
	    
	    System.out.println(String.format("%10s %10s %5s %5s %6s %5s %5s %6s %5s %5s %6s","", "|", "Speed",
	    		"Location", "|", "Speed","Location","|","Speed","Location","|"));
		
	    System.out.println(String.format("%s", "-----------------------------------------"
				 + "-----------------------------------------------"));
		 System.out.println(String.format("%10s %10s %5s %5s %9s %5s %5s %9s %5s %5s %9s", 
				 A.getTime(), "|", A.getFinalVelocity(),df.format(A.calculateDistance()), "|", B.getFinalVelocity(),df.format(B.calculateDistance()),"|",C.getFinalVelocity(),df.format(C.calculateDistance()),"|"));

	    while(true) {
			//Count time
	    	totalTimeInSeconds = countsec * increase;
	    	
	    	


	    	if(totalTimeInSeconds >= 0.60 && totalTimeInSeconds % 0.30 == 0) {
	    		B.step();
	    		int phase = B.getPhase();
	    		B.startPhase(getInitialVelocity(phase), getFinalVelocity(phase));

	    	}
	    	if(totalTimeInSeconds >= 1.20 && totalTimeInSeconds % 0.30 == 0) {
	    		C.step();
	    		int phase = C.getPhase();
	    		C.startPhase(getInitialVelocity(phase), getFinalVelocity(phase));

	    	}
	    	if(totalTimeInSeconds % 0.30 == 0) {
	    		
	    		//Prints every 30 seconds
	    		A.step();//calls method to change actualTime and change phase
	    		int phase = A.getPhase();//set phase
	    		A.startPhase(getInitialVelocity(phase), getFinalVelocity(phase));//change segment
		    	printData(A,B,C);//prints data

	    		
	    	}
	    	
	    	if (C.getPhase() == 3) {
	    		break;
	    	}
	    	
	    	countsec++;
			
		}
		
	}
	    
}	
	
	
	
	
	
	