import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;

public class Main {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\P\\Desktop\\Geekbrains. Homework\\Introduction_to_OOP\\OOPHomework4\\dairy.csv";
        String searchName = "Anna Ivanova";
        List<DairyData> dairyList = new ArrayList<>();

        DairyData task1 = new DairyData(1, "Ivan Petrov", Priority.important);
        DairyData task2 = new DairyData(2, "Anna Ivanova", Priority.important);
        DairyData task3 = new DairyData(3, "Petr Ivanov", Priority.urgent);
        DairyData task4 = new DairyData(4, "Olga Petrova", Priority.notImportant);
        DairyData task5 = new DairyData(5, "Anastasia Vasilieva", Priority.notImportant);
        dairyList.add(task1);
        dairyList.add(task2);
        dairyList.add(task3);
        dairyList.add((task4));
        dairyList.add(task5);

        FileReadWrite<DairyData> file = new FileReadWrite<>();
        file.fileCreate(filePath);
        file.fileWrite(dairyList, filePath);
        file.fileRead(filePath);
        file.fileSearchByName(searchName, filePath);
    }
}
