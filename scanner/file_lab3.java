package lab3;

import java.util.Scanner;

public class lab3 {
 public static class Figure {

  String kolor="";
  double surface_area=0;
  double circumference=0;
  void setSurface(){};
  void setCircumference() {};
  double getSurface() {
   return surface_area;
  }
  double getCircumference() {
   return circumference;
  }
  void viewData() {
   System.out.println("kolor: "+kolor);
   System.out.println("pole powierzchni: "+surface_area);
   System.out.println("srednica: "+circumference);
  }
  public Figure(){
   kolor="przezroczysty";
   surface_area=0;
   circumference=0;
  }
  public Figure(String kolor_) {
   kolor=kolor_;
   surface_area=0;
   circumference=0;
   }
  }
  public static class Circle extends Figure{
   public Circle(String kolor_) {
    super(kolor_);
    }
   void count_Circumference(double promien_) {
    circumference=2*3.14*promien_;
   }
   void count_surface() {
	   double promien=circumference/2*3.14;
    surface_area=3.14*promien*promien;
   }
   void viewData() {
    System.out.println("Figura kolo");
    super.viewData();
   }
  }
  public static class Rectangle extends Figure{
   public Rectangle() {
    super();
   }
   public Rectangle(String kolor_) {
    super(kolor_);
    }
   void count_Circumference(double a, double b) {
	    circumference=2*a+2*b;
   }
   void count_surface(double a, double b) {
	    surface_area=a*b;
   }
   void viewData() {
    System.out.println("Figura prostokat");
    super.viewData();
   }
  }
   public static class Triangle extends Figure{
    public Triangle() {
     super();
    }
    public Triangle(String kolor_) {
     super(kolor_);
     }
    void count_Circumference(double a, double b, double c) {
     circumference=a+b+c;
    }
    void count_surface(double a, double b, double c) {
     double p=(a+b+c)/2;
     double pole=Math.sqrt(p*(p-a)*(p-b)*(p-c));
     surface_area=pole;
    }
    void viewData() {
     System.out.println("Figura trojkata");
     super.viewData(); 
    }
   }
  public static void main(String[] args) {
    //kolo
    System.out.println("\n\nKOLO: ");
    System.out.println("podaj kolor: ");
    
    Scanner reader=new Scanner(System.in);
    String kolor=reader.next();
    Circle kolo=new Circle(kolor);
    
    System.out.println("promien: ");
    double promien=reader.nextDouble();
    kolo.count_Circumference(promien);
    
    
    kolo.setSurface();
    kolo.viewData();
    //reader.close();
    
    //prostokat
    System.out.println("\n\nPROSTOKAT: ");
    System.out.println("podaj kolor: ");
    
    //Scanner reader1=new Scanner(System.in);
    //String kolor1=reader1.next();
    kolor=reader.next();
    
    //Rectangle prostokat=new Rectangle(kolor1);
    Rectangle prostokat=new Rectangle(kolor);
   
    System.out.println("podaj bok a: ");
   // double a=reader1.nextDouble();
    double a=reader.nextDouble();
    System.out.println("podaj bok b: ");
    //double b=reader1.nextDouble();
    double b=reader.nextDouble();
    
    prostokat.count_Circumference(a,b);
    prostokat.count_surface(a,b);
    
    prostokat.viewData();
    //reader1.close();
    
   //trojkat
    System.out.println("\n\nTROJKAT: ");
    System.out.println("podaj kolor: ");
    
    //Scanner reader2= new Scanner(System.in);
    //String kolor2=reader2.next();
    kolor=reader.next();

    //Triangle trojkat=new Triangle(kolor2);
    Triangle trojkat=new Triangle(kolor);
    System.out.println("podaj bok a: ");
    //a=reader2.nextDouble();
    a=reader.nextDouble();
    //b=reader2.nextDouble();
    System.out.println("podaj bok b: ");
    b=reader.nextDouble();
    //double c=reader2.nextDouble();
    System.out.println("podaj bok c: ");
    double c=reader.nextDouble();
    
    trojkat.count_Circumference(a,b,c);
    trojkat.count_surface(a,b,c);
    
    trojkat.viewData();
    //reader2.close();
    reader.close();
 }
}