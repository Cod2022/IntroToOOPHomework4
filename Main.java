import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;

public class Main {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\P\\Desktop\\Geekbrains. Homework\\Introduction_to_OOP\\OOPHomework4\\dairy.csv";
        String searchTerm = "3";
        List<DairyData> dairyList = new ArrayList<>();

        DairyData firstTask = new DairyData(1, "Name1");
        DairyData secondTask = new DairyData(2, "Name2");
        DairyData thirdTask = new DairyData(3, "Name3");
        dairyList.add(firstTask);
        dairyList.add(secondTask);
        dairyList.add(thirdTask);

        FileReadWrite<DairyData> file = new FileReadWrite<>();
        file.fileCreate(filePath);
        file.fileWrite(dairyList, filePath);
        file.fileRead(searchTerm, filePath);
    }
}
