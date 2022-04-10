package lab6_1;

public class Person implements Dietician
{

	private String personalData = "nieznane";
	private int age = 0;
	private double height = 0.0;
	private double weight = 0.0;
	private double bmi = 0;
	
	public Person(String personalData_, int age_, double height_, double weight_) 
	{
		personalData = personalData_;
		age = age_;
		height = height_;
		weight = weight_;
		bmi = weight/Math.pow((height*0.01), 2);
	}
	
	public int getAge()
	{
		return age;
	}
	
	public String toString()
	{
		return "Osoba: " + personalData + " lat: " + age + " waga: " + weight + " wzrost: " + height + " BMI=" + getBMI();
	}
	
	public double getBMI()
	{
		
		return bmi;
	}
	
	public String viewAlarm()
	{
		if(bmi < ALARM)
			return "";
		else
			return "<<<ALARM! Oty³oœæ>>> ";
	}
	
}
