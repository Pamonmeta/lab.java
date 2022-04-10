package lab5;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;

public class lab5 {

public static class Purchase {
	int id;
	String name;
	int number;
	double amount;
	public Purchase(){
		id=0;
		name="";
		number=0;
		amount=0.0;
	}
	public Purchase(int id_,String name_, int number_, double amount_){
		id=id_;
		name=name_;
		number=number_;
		amount=amount_;
	}
	public void wypiszInfo(){
		System.out.println(id+" "+name+" "+number+" "+amount);
	}
}
public static class Customer {
	int id;
	String first_name;
	String last_name;
	String adres;
	public Customer() {
		id=0;
		first_name="";
		last_name="";
		adres="";
	}
	public Customer(int id_,String imie,String nazwisko,String adres_) {
		id=id_;
		first_name=imie;
		last_name=nazwisko;
		adres=adres_;
	}
	public void wypiszInfo(){
		System.out.println(id+" "+first_name+" "+last_name+" "+adres);
	}
}
	public static void main(String[] args) throws IOException {

		//Customers.txt
		JOptionPane.showMessageDialog(null,"podaj sciezke pliku customers.txt");
		//katalog domyslny
		JFileChooser jfc1=new JFileChooser("c:/");
		//wybierz plik do odczytu
		jfc1.showOpenDialog(null);
		//gdyby nie istanial
		while(!(jfc1.getSelectedFile().exists())) {
			JOptionPane.showMessageDialog(null, "Plik nie istnieje, podaj sciezke pliku Customers.txt");
			jfc1.showOpenDialog(null);
		}
		File customers=jfc1.getSelectedFile();
		//lista klientow
		ArrayList<Customer> klienci = new ArrayList<Customer>();

		Scanner c = new Scanner(customers);
		while (c.hasNext()) {
			//id
			int id = c.nextInt();
			//imie
			String first_name = c.next();
			//nazwisko
			String last_name = c.next();
			//adres
			String adres = c.nextLine();
			klienci.add(new Customer(id, first_name, last_name, adres));
		}
		c.close();//koniec wczytywania

		//Purchases.txt
		//lista zakupow

		JOptionPane.showMessageDialog(null,"podaj sciezke pliku purchases.txt");
		//wybierz plik do odczytu
		JFileChooser jfc2=new JFileChooser("c:/");
		jfc2.showOpenDialog(null);
		//gdyby nie istanial
		while(!(jfc2.getSelectedFile().exists())){
			JOptionPane.showMessageDialog(null,"Plik nie istnieje, podaj sciezke pliku Purchases.txt");
			jfc2.showOpenDialog(null);
		}
		File purchases=jfc2.getSelectedFile();

		ArrayList<Purchase> zakupy = new ArrayList<Purchase>();

		Scanner p = new Scanner(purchases);
		while (p.hasNext()) {
			//id
			int id = p.nextInt();
			//nazwa
			String name = p.next();
			//numer
			int number = p.nextInt();
			//suma
			double amount = Double.parseDouble(p.next().replace(",", "."));
			//czy klient istnieje
			boolean is = false;
			for (int i = 0; i < klienci.size(); i++) {
				if (klienci.get(i).id == id) {
					is = true;
					i = klienci.size();
				}
			}
			if (is) {
				zakupy.add(new Purchase(id, name, number, amount));
			} else {
				//System.out.println("klient o id: " + id + " nie istnieje, nie zostanie wczytany zakup");
				JOptionPane.showMessageDialog(null,"klient o id: "+id+" nie istnieje, nie zostanie wczytany zakup");
			}
		}
		p.close();

		System.out.println("Customers");
		for (int i = 0; i < klienci.size(); i++)
			klienci.get(i).wypiszInfo();

		System.out.println("Purchases");
		for (int i = 0; i < zakupy.size(); i++)
			zakupy.get(i).wypiszInfo();

		//wypisz faktury i zapisz do pliku

		//liczenie sum zakupow klientow
		//indeksowanie od 1, po id
		double[] sumy = new double[klienci.size()+1];

		//porownanie id klienta z id klienta zakupu
			for(int i=0;i<zakupy.size();i++){
				sumy[zakupy.get(i).id]+=zakupy.get(i).amount*zakupy.get(i).number;
			}
			//przepisanie sum do indeksowania od 0
		for(int i=0;i< sumy.length-1;i++){
			sumy[i]=sumy[i+1];
			System.out.println("suma klienta o id "+(i+1)+": "+sumy[i]);
		}

		//tworzenie faktur
		JOptionPane.showMessageDialog(null,"podaj plik do zapisu faktur");
		//wybierz plik do zapisu
		JFileChooser jfc3=new JFileChooser("c:/");
		jfc3.showOpenDialog(null);

		File faktury=jfc3.getSelectedFile();

		BufferedWriter z = new BufferedWriter(new FileWriter(faktury));
		for(int i=0;i<klienci.size();i++){
			if(sumy[i]!=0) {
				z.write("Invoice. id_customer " + klienci.get(i).id);
				z.newLine();
				z.write(klienci.get(i).first_name + " " + klienci.get(i).last_name + " " + klienci.get(i).adres);
				z.newLine();
				z.write("number trans. " + i + ", sum amount " + sumy[i] + " PLN");
				z.newLine();
				z.write("----------------------------------------");
				z.newLine();
				//zapis do pliku z bufora
				z.flush();
			}
		}
		z.close();
	}
}