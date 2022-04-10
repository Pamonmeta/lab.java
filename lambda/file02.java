package lab7;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Employee implements Accountant {
String name;
double fte;
double salaryFTE;
double netSalary;
int age;
String position;
public Employee(String name_,double fte_,double salaryFTE_,int age_,String position_) {
	name=name_;
	fte=fte_;
	salaryFTE=salaryFTE_;
	age=age_;
	netSalary=countSalary();
	position=position_;
}
public String toString() {
	return "Personalia: "+name+
			" wymiar etatu: "+fte+
			" pensja_pod: "+salaryFTE+
			" pensja netto: "+netSalary+
			" wiek: "+age+
			" stanowisko pracy: "+position;
}
public double countSalary () {
	Accountant acc = () -> {
		if(age<=ageLimit)
		return salaryFTE*fte*(1-hcc);//bez pit
	else
		return salaryFTE*fte*(1-ratePit-hcc);//z pit
	};
	return acc.countSalary();
};
public static void main(String[] args) throws IOException {
	ArrayList<Employee> pracownicy=new ArrayList<Employee>();
	pracownicy.add(new Employee("Nowak Jan",1.0,5200.0,24,"Kierowca"));
	pracownicy.add(new Employee("Piech Anna",0.7,4800.0,29,"Księgowa"));
	pracownicy.add(new Employee("Jach Ewa",1.2,6000.0,27,"Księgowa"));
	pracownicy.add(new Employee("Rak Piotr",1.25,4000.0,21,"Kierowca"));
	pracownicy.add(new Employee("Maj Jan",0.5,7000.0,52,"Kierownik"));
	pracownicy.add(new Employee("Bąk Olga",1.0,6000.0,29,"Księgowa"));

	System.out.println("\n pracownicy");
	for(int i=0;i< pracownicy.size();i++){
		System.out.println(pracownicy.get(i).toString());
	}
	Comparator<Employee> salaryAsc=(Employee e0, Employee e1) -> (int) (e0.countSalary()- e1.countSalary());
	pracownicy.sort(salaryAsc);

	System.out.println("\n pracownicy po wyplacie (asc)");
	for(int i=0;i< pracownicy.size();i++){
		System.out.println(pracownicy.get(i).toString());
	}

	Comparator<Employee> positionAsc=(Employee e0, Employee e1) -> (int) (e0.position.compareTo(e1.position));
	pracownicy.sort(positionAsc);

	System.out.println("\n pracownicy po pozycji (asc)");
	for(int i=0;i< pracownicy.size();i++){
		System.out.println(pracownicy.get(i).toString());
	}

	Comparator<Employee> ageDesc=(Employee e0, Employee e1) -> (int) (e1.age - e0.age);
	pracownicy.sort(ageDesc);

	System.out.println("\n pracownicy po pozycji (asc) i wieku (desc)");
	for(int i=0;i< pracownicy.size();i++){
		System.out.println(pracownicy.get(i).toString());
	}

	Comparator<Employee> salaryDesc=(Employee e0, Employee e1) -> (int) (e1.countSalary()- e0.countSalary());
	pracownicy.sort(salaryDesc);

	System.out.println("\n pracownicy po pozycji (asc), wieku (desc) i wyplacie (asc)");
	for(int i=0;i< pracownicy.size();i++){
		System.out.println(pracownicy.get(i).toString());
	}

	File plik=new File("plik.txt");
	File p=new File(plik.getAbsolutePath());
	System.out.println(p.getAbsolutePath());
	p.createNewFile();

	BufferedWriter in=new BufferedWriter(new FileWriter(p));
	for(int i=0;i< pracownicy.size();i++){
		in.write(" **** zapis lambda ****");
		in.newLine();
		in.write(pracownicy.get(i).name+" lat: "+pracownicy.get(i).age);
		in.newLine();
		in.write("    "+pracownicy.get(i).position+" etat: "+pracownicy.get(i).fte);
		in.newLine();
		in.write("    placa_pod="+pracownicy.get(i).salaryFTE+" -> pensja="+pracownicy.get(i).netSalary);
		in.newLine();
		in.write(" -----------------------");
		in.newLine();
	}
	in.close();
	}
}


