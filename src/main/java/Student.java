public class Student {

  private String Name;
  private int Age;
  private String Nazwisko;
  private String Dataur;
  

  public Student(String name, String nazwisko, int age,String dataur) {
    Name = name;
    Age = age;
    Nazwisko = nazwisko;
    Dataur= dataur;
  }

  public String GetName() {return Name;}
  public int GetAge() {return Age;}
  public String GetNazwisko() {return Nazwisko;}
  public String GetDataur() {return Dataur;}

  public String ToString() {
    return Name + " " + Nazwisko + " " + Integer.toString(Age) + " " + Dataur;
  }

  public static Student Parse(String str) {
      String[] data = str.split(" ");
      if(data.length != 4) 
        return new Student("Parse Error","Parse Error", -1,"Parse Error");
      return new Student(data[0],data[1], Integer.parseInt(data[2]),data[3]);
    }
  }