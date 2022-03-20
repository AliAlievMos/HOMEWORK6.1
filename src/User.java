import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class User {



    public static void CSV() throws IOException {
            Scanner sc = new Scanner(System.in);
            PrintWriter writer = new PrintWriter(new File("persons.csv"));
            StringBuilder sb = new StringBuilder();
            sb.append("name");
            sb.append(',');
            sb.append("soname");
            sb.append(',');
            sb.append("age");
            sb.append(',');
            sb.append("phone");
            sb.append('\n');

            while (true) {
                System.out.println("Введите имя:");
                String name = sc.next();
                sb.append(name);
                sb.append(",");
                System.out.println("Введите фамилию:");
                String soname = sc.next();
                sb.append(soname);
                sb.append(",");
                System.out.println("Введите ваш возраст:");
                int age = sc.nextInt();
                sb.append(age);
                sb.append(",");
                System.out.println("Введите ваш номер телефона:");
                int phone = sc.nextInt();
                sb.append(phone);
                sb.append('\n');
                System.out.println("Записать данные пользователя? Нажмите 1 для продолжения.");
                int answer = sc.nextInt();
                   if (answer == 1){
                       continue;
                   }
                   else {
                       sc.close();
                       break;
                   }

            }
            writer.write(sb.toString());
            writer.close();
            User testCSV = new User();
            testCSV.readCSVFile();
        }

    public void readCSVFile(){
        List<List<String>> records = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File("persons.csv"));) {
            while (scanner.hasNextLine()) {
                records.add(getRecordFromLine(scanner.nextLine()));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(records.toString());
    }
    private List<String> getRecordFromLine(String line) {
        List<String> values = new ArrayList<String>();
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(",");
            while (rowScanner.hasNext()) {
                values.add(rowScanner.next());

            }
        }
        return values;


        }



}