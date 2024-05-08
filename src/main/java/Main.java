/*
Kod bazowy programu Commit4_0: 
• Program dodaje do prostej bazy danych (pliku db.txt) dane odnośnie Studentów.
• Studenci dodawani są w klasie Main.
• Wszyscy studenci są wypisywani na końcu klasy Main.
• Klasa Service obsługuje odczyt i zapis do pliku bazy danych.
• Klasa Student reprezentuje pojedynczego studenta (Imię, Wiek).
*/
import java.util.Scanner;
import java.io.IOException;

class Main {
  public static void main(String[] args) {
    try {
      Service s = new Service();
      Scanner scanner = new Scanner(System.in);
      
      while (true) {
        System.out.println("Wybierz sposób dodania studenta:");
        System.out.println("1. Z konsoli");
        
        int choice = scanner.nextInt();
        scanner.nextLine(); 
        switch (choice) {
          case 1:
            s.addStudent(new Student("Krzysztof", 20));
            s.addStudent(new Student("Janusz", 40));
            System.out.println("Podaj imię studenta:");
            String name = scanner.nextLine();
            System.out.println("Podaj wiek studenta:");
            int age = scanner.nextInt();
            scanner.nextLine(); 
            s.addStudent(new Student(name, age));
            break;
          default:
            System.out.println("Niepoprawny wybór.");
            continue;
        }
        System.out.println("Czy chcesz dodać kolejnego studenta? (y/n)");
        String answer = scanner.nextLine();
        if (!answer.equalsIgnoreCase("y")) {
          break;
        }
      }
      

      var students = s.getStudents();
      for(Student current : students) {
        System.out.println(current.ToString());
      }
    } catch (IOException e) {

    }
  }
}