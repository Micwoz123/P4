public class Student {

  private String name;
  private int age;
  private String nazwisko;
  private String dataur;

  public Student(String name, String nazwisko, int age, String dataur) {
    this.name = name;
    this.age = age;
    this.nazwisko = nazwisko;
    this.dataur = dataur;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  public String getNazwisko() {
    return nazwisko;
  }

  public String getDataur() {
    return dataur;
  }

  public String ToString() {
    return name + " " + nazwisko + " " + Integer.toString(age) + " " + dataur;
  }

  public static Student Parse(String str) {
    String[] data = str.split(" ");
    if (data.length != 4) {
      return new Student("Parse Error", "Parse Error", -1, "Parse Error");
    }
    return new Student(data[0], data[1], Integer.parseInt(data[2]), data[3]);
  }
}