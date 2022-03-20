
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Person {

    public String name;
    public String soname;
    public String age;
    public String phone;



    public static List<Person> ParsePersonCsv(String filePath) throws IOException {

        List<Person> people = new ArrayList<Person>();
        List<String> fileLines = Files.readAllLines(Paths.get(filePath));
        for (String fileLine : fileLines) {
            String[] splitedText = fileLine.split(",");
            ArrayList<String> columnList = new ArrayList<>();
            for (int i = 0; i < splitedText.length; i++) {
                if (IsColumnPart(splitedText[i])) {
                    String lastText = columnList.get(columnList.size() - 1);
                    columnList.set(columnList.size() - 1, lastText + "," + splitedText[i]);
                } else {
                    columnList.add(splitedText[i]);
                }

            }
            Person person = new Person();
            person.name = columnList.get(0);
            person.soname = columnList.get(1);
            person.age = columnList.get(2);
            person.phone = columnList.get(3);

            people.add(person);
        }
        return people;

    }
    private static boolean IsColumnPart(String text) {
        String trimText = text.trim();
        return trimText.indexOf("\"") == trimText.lastIndexOf("\"") && trimText.endsWith("\"");
    }
}
