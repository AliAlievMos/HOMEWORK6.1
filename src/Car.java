import java.io.*;

public class Car implements Serializable {
    int speed;
    String color;
    String company;
    String model;
    int mileage;

    public Car (int speed, String color, String company,
                     String model, int mileage, File fileToSave) throws IOException, ClassNotFoundException {
        this.speed = speed;
        this.color = color;
        this.company = company;
        this.model = model;
        this.mileage = mileage;
        SaveCar(fileToSave);
        DownloadCar(fileToSave);
    }

    public void SaveCar(File fileToSave) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileToSave));
        oos.writeObject(this);
        oos.close();
    }
    public void DownloadCar(File fileToSave) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileToSave));
        Car car = (Car) ois.readObject();
        System.out.println(car.company);
        ois.close();
    }


}
