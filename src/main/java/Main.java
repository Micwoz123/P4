import java.util.Scanner;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

class Main {
  public static void main(String[] args) {
    try {
      Service s = new Service();
      Scanner scanner = new Scanner(System.in);

      while (true) {

        System.out.println("1. Dodaj studenta");
        System.out.println("2. Wypisz wszystkich studentów");
        System.out.println("3. Wyszukaj studenta po nazwisku");
        System.out.println("4. Wyjdz");

        int choice = scanner.nextInt();
        scanner.nextLine(); 
        switch (choice) {
          case 1:
            System.out.println("Podaj imię studenta:");
            String name = scanner.nextLine();
            System.out.println("Podaj nazwisko studenta:");
            String nazwisko = scanner.nextLine();
            System.out.println("Podaj wiek studenta:");
            int age = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Podaj datę urodzenia studenta (dd-mm-yyyy):");

            String dataur = scanner.nextLine();

            try {
              LocalDate.parse(dataur, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            } catch (DateTimeParseException e) {
              System.out.println("Niepoprawny format daty. Użyj formatu dd-mm-yyyy.");
              continue;
            }

            s.addStudent(new Student(name, nazwisko, age, dataur));
            break;
          case 2:
            var students = s.getStudents();
            for (Student current : students) {
              System.out.println(current.ToString());
            }
            break;
          case 3:
            System.out.println("Podaj nazwisko studenta:");
            String nazwiskos = scanner.nextLine();
            List<Student> foundStudents = s.findStudentByName(nazwiskos);

            if (foundStudents == null || foundStudents.isEmpty()) {
              System.out.println("Nie znaleziono studenta o nazwisku: " + nazwiskos);
            } else {
              System.out.println("Znaleziono następujących studentów:");
              for (Student student : foundStudents) {
                System.out.println(student.ToString());
              }
            }
            break;
          case 4:
            System.exit(0);
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