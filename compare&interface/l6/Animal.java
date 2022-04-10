package lab6_1;

public class Animal implements Dietician
{

	protected String name = "nieznane";
	protected double weight = 0.0;
	protected int age = 0;
	protected double bmi = 0.0;
	
	public Animal(String name_, double weight_, int age_) 
	{
		name = name_;
		weight = weight_;
		age = age_;
	}
	
	public int getAge()
	{
		return age;
	}
	
	public String toString()
	{
		return "Zwierze: " + name + " lat: " + age + " waga: " + weight;
	}
	
	public double getBMI()
	{
		return bmi;
	}
	
	
	public String viewAlarm()
	{
		if(bmi > ALARM)
			return "<<<ALARM! Oty³oœæ>>> ";
		
		return "";
	}
	
}
