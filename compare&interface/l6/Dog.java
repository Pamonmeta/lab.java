package lab6_1;

public class Dog extends Animal
{
	private int factor = 0;

	public Dog(String name_, double weight_, int age_, int factor_) 
	{
		super(name_, weight_, age_);
		
		factor = factor_;
	}
	
	public int getAge()
	{
		return age;
	}
	
	public double getBMI()
	{
		switch(factor) 
		{
			
			case 1:
				bmi = Math.pow(weight, 3);
				break;
		
			case 2:
				bmi = Math.pow(weight, 2);
				break;
				
			case 3:
				bmi = weight + 10;
				break;
		
			default:
				bmi = -1;
				break;
		}
		
		return bmi;	
	}
	
	
	public String toString()
	{
		
		return super.toString() + " BMI=" + getBMI() + " pies" + " poziom " + factor;
		
	}
	
	
	public String viewAlarm()
	{
		if(getBMI() > ALARM)
			return "<<<ALARM! Oty³oœæ>>> ";
		else
			return "";
	}
	
	
}
