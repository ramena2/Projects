
public class Student {

	private String carName;
	private double actualTime;
	private double acceleration;
	private double InitialVelocity;
	private double FinalVelocity;
	private int phase;
	
	
	
	public Student(String car) {
		
		carName = car;
		actualTime = 0;
		acceleration = 10.23;
		phase = 0;
		
	}

	public void startPhase(double initialVelocity, double finalVelocity) {
		this.InitialVelocity = initialVelocity;
		this.FinalVelocity = finalVelocity;
	}
	
	
	public String getName() {
		return carName;
	}
	
	public int getPhase() {
		return phase;
	}
	
	public void setTime(double time) {
		this.actualTime = time;
	}
	
	public double getTime() {
		return actualTime;
	}
	
	
	public double getFinalVelocity() {
		if(phase == 0)
			return 0;
		
		return FinalVelocity;
	}
	
	public double calculateDistance() {
		//Calculate the distance of the car
		
		if (phase == 0)//this means car has not start to roll
			return 0;
		
		double changeOfTime = ((FinalVelocity - InitialVelocity)/acceleration);
		//add change of distance
		double constantDistance = ((30 - changeOfTime) / 3600) * FinalVelocity;
		
		return constantDistance;
	}
	
	public void step() {
		this.actualTime = this.actualTime + 30;
		this.phase = this.phase + 1;
	}
	
}
