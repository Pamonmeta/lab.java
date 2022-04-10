package lab6_1;

import java.util.Arrays;
import java.util.Comparator;

public class main 
{

	public static void main(String[] args) 
	{
		
		Dietician[] tab = new Dietician[]
		        {
		            new Person("Jakub Nowak", 20, 169, 68),
		            new Dog("Fafik", 2, 3, 1),
		            new Person("Test testowy", 39, 140, 95),
		            new Dog("Ares", 12, 5, 3),
		            new Person("Jan Kowalski", 27, 180, 52),
		            new Dog("Koala", 9, 6, 2),
		            new Person("Adrian Pietrzak", 40, 176, 65),
		            new Dog("Taiga", 8, 3, 2)
		        };
		
		/*
		Dietician[] tab=new Dietician[]
                { 
	                new Person("Kowalski Jan", 45, 178, 83),
	                new Dog("Yeti", 6.0, 4, 2),
	                new Dog("Sonia", 5.1, 7, 2),
	                new Person("Mucha Joanna", 24, 169, 61),
	                new Dog("Azor", 11.3, 5, 3),
	                new Person("Gala Piotr", 34, 184, 91),
	                new Person("Piech Anna", 56, 163, 88),
	                new Dog("Meps", 16.9, 8, 3),
	                new Person("Adamus Jacek", 21, 176, 94),
	                new Dog("Reks", 2.8, 3, 1)
                };
		*/
		

		System.out.println("Lista w pierwotnej kolejnoœci\n");
		
		for(int i = 0; i < tab.length; i++)
			System.out.print(tab[i].toString() + "\n");
		
		Arrays.sort(tab, new Comparator<Dietician>()
							{
								public int compare(Dietician a, Dietician b)
									{
										
										if(a.getBMI() - b.getBMI() > 0)
											return 1;
										
										else if(a.getBMI() - b.getBMI() == 0)
											return 0;
										
										else
											return -1;
									}
							}
					);
			
		System.out.println("\nLista uporz¹dkowana kolejno wg wartoœci BMI\n");
		
		for(int i = 0; i < tab.length; i++)
			System.out.print(tab[i].viewAlarm() + tab[i].toString() + "\n");
		
		
		System.out.println("\nLista uporz¹dkowana kolejno wg gatunku i wieku\n");
		
		
		
		Arrays.sort(tab, new Comparator<Dietician>()
						{
							public int compare(Dietician a, Dietician b)
								{
								
									Boolean check_a = a instanceof Dog;
									Boolean check_b = b instanceof Dog;
									
									int Comp = check_b.compareTo(check_a);
								
									if(Comp != 0)
										return Comp;
									
									return (int)(a.getAge() - b.getAge());
									
								}
						}
				   );
		
		for(int i = 0; i < tab.length; i++)
			System.out.print(tab[i].viewAlarm() + tab[i].toString() + "\n");
		
	}
}
