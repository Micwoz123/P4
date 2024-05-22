import java.util.Collection;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Service {

  public void addStudent(Student student) throws IOException {
    var f = new FileWriter("db.txt", true);
    var b = new BufferedWriter(f);
    b.append(student.ToString());
    b.newLine();
    b.close();
  }

  public Collection<Student> getStudents() throws IOException {
    var ret = new ArrayList<Student>();
    var f = new FileReader("db.txt");
    var reader = new BufferedReader(f);
    String line = "";
    while (true) {
      line = reader.readLine();
      if (line == null)
        break;
      ret.add(Student.Parse(line));
    }
    reader.close();
    return ret;
  }

  public List<Student> findStudentByName(String nazwiskos) throws IOException {
    List<Student> foundStudents = new ArrayList<Student>();
    try {
      for (Student student : getStudents()) {
        if (student != null && student.getNazwisko().equalsIgnoreCase(nazwiskos)) {
          foundStudents.add(student);
        }
      }
    } catch (IOException e) {
      System.err.println("Error reading student data: " + e.getMessage());
    }
    return foundStudents;
  }
}