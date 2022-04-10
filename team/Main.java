package Marcelina_Zietal_Lab4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		ArrayList <String> teams = new ArrayList<String>();
		teams.add("Warta Czêstochowa");
		teams.add("Gryf Poznan");
		teams.add("Wisla Katowice");
		teams.add("Pilica Piotrkow Trybunalski");
		teams.add("San Krakow");
		
		System.out.println("Druzyny");
		System.out.println(teams);
		
		Collections.sort(teams);
		System.out.println("Po sortowaniu:");
		System.out.println(teams);
		*/
		
		ArrayList <Player> players = new ArrayList<Player>();
		
		boolean tmp = true;
		Scanner scanner = new Scanner(System.in);
		int age=16, n_goals=0, ave_n_minutes=0;
		
		while(tmp) {
			System.out.println(" Podaj personalia:");
			String name = scanner.nextLine();
			
			System.out.println(" Podaj nazwe druzyny:");
			String team_name = scanner.next();
			
			System.out.println(" Podaj wiek zawodnika:");
			String tmp_age = scanner.next();
			try {
				age = Integer.parseInt(tmp_age);
			}catch (NumberFormatException ex){
				System.out.println(" Uwaga! Zastosowano niepoprawny format danych!");
				System.out.println(" Jeszcze raz podaj wiek zawodnika (inaczej zostanie przypisana wartosc 16):");
				tmp_age = scanner.next();
				try {
					age = Integer.parseInt(tmp_age);
				}catch(NumberFormatException ex2) {
					System.out.println(" Uwaga! Po drugiej b³êdnej wartosci wiek ustalono na poziomie domyslnym 16 lat.");
				}
	        }
			
			System.out.println(" Podaj liczbe zdobytych bramek przez zawodnika:");
			String tmp_n_goals = scanner.next();
			try {
				n_goals = Integer.parseInt(tmp_n_goals);
			}catch (NumberFormatException ex){
				System.out.println(" Uwaga! Zastosowano niepoprawny format danych!");
				System.out.println(" Jeszcze raz podaj liczbe zdobytych bramek przez zawodnika (inaczej zostanie przypisana wartosc 0):");
				tmp_n_goals = scanner.next();
				try {
					n_goals = Integer.parseInt(tmp_n_goals);
				}catch(NumberFormatException ex2) {
					System.out.println(" Uwaga! Po drugiej b³êdnej wartosci liczbe zdobytych bramek ustalono na poziomie domyslnym 0.");
				}
	        }

			System.out.println(" Podaj srednia liczbe minut spedzonych przez zawodnika na boisku:");
			String tmp_ave_n_minutes = scanner.next();
			try {
				ave_n_minutes = Integer.parseInt(tmp_ave_n_minutes);
			}catch (NumberFormatException ex){
				System.out.println(" Uwaga! Zastosowano niepoprawny format danych!");
				System.out.println(" Jeszcze raz podaj srednia liczbie minut spedzonych przez zawodnika na boisku (inaczej zostanie przypisana wartosc 0):");
				tmp_ave_n_minutes = scanner.next();
				try {
					ave_n_minutes = Integer.parseInt(tmp_ave_n_minutes);
				}catch(NumberFormatException ex2) {
					System.out.println(" Uwaga! Po drugiej b³êdnej wartosci sredniej liczbe minut spedzonych na boisku ustalono na poziomie domyslnym 0.");
				}
	        }
			try {
				players.add(new Player (name, team_name, age, n_goals, ave_n_minutes));
			} catch(Exception ex) {
				
			}
			
			System.out.println("\n Chcesz wprowadziæ dane kolejnego zawodnika (t/n)?");
			String dec = scanner.next();
			if (dec.equals("n") || dec.equals("N"))
				tmp = false;	
		}
		scanner.close();
		
		players.forEach(System.out::println);
	}
	
}
