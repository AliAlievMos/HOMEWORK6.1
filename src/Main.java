import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {
public static void main(String[] args) throws IOException, ClassNotFoundException {
    // Задание 1-2
//    User.CSV();
//    String filePath = "persons.csv";
//    List<Person> people = Person.ParsePersonCsv(filePath);
//    System.out.println((people.get(1)).name);
    // Задание 3
    File cars = new File("cars.txt");
    Car vaz = new Car(50,"blue","VAZ","2106", 1000, cars);

        }
}
