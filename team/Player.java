package Marcelina_Zietal_Lab4;

public class Player {
	String name;
	String team_name;
	int age;
	int n_goals;
	int ave_n_minutes;
	
	
	public Player(String name_, String team_name_, int age_, int n_goals_, int ave_n_minutes_) throws Exception
	{
		if (name_.isBlank())
			throw new Exception("Anulowanie wpisu! Nieprawidlowe dane zawodnika: Imie jest puste.");
		else
			name = name_;
		
		team_name = team_name_;
		
		if(age_>=16 && age_<=60)
			age = age_;
		else 
			throw new Exception("Anulowanie wpisu! Nieprawidlowe dane zawodnika: Dopuszczalny wiek zawodnika to od 16 do 60 lat.");
		
		if(n_goals_<0)
			throw new Exception("Anulowanie wpisu! Nieprawidlowe dane zawodnika: Ilosc bramek nie moze byc ujemna.");
		else
			n_goals = n_goals_;
		
		if(ave_n_minutes_>=0 && ave_n_minutes_<=90)
			ave_n_minutes = ave_n_minutes_;
		else
			throw new Exception("Anulowanie wpisu! Nieprawidlowe dane zawodnika: Czas na boisku to od 0 do 90");
	}
	
	public String toString() {
		//System.out.println("Player: name="+this.name+", team="+this.team_name+", age="+this.age+", goals="+this.n_goals+", avg. minutes="+this.ave_n_minutes);
		return ("Player: name="+this.name+", team="+this.team_name+", age="+this.age+", goals="+this.n_goals+", avg. minutes="+this.ave_n_minutes);
	}
	
}
