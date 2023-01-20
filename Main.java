/*
 * Спроектировать и реализовать планировщик дел для работы с задачами разных приоритетов.
 */

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        // String filePath = "C:\\Users\\P\\Desktop\\Geekbrains. Homework\\Introduction_to_OOP\\OOPHomework4\\dairy.csv";
        String filePath = "dairy.csv";
        List<DairyData> dairyList = new ArrayList<>();

        DairyData task1 = new DairyData(1, "Ivan Petrov", Priority.important);
        DairyData task2 = new DairyData(2, "Anna Ivanova", Priority.important);
        DairyData task3 = new DairyData(3, "Petr Ivanov", Priority.urgent);
        DairyData task4 = new DairyData(4, "Olga Petrova", Priority.notImportant);
        DairyData task5 = new DairyData(5, "Anastasia Vasilieva", Priority.notImportant);
        DairyData task6 = new DairyData(6, "Anastasia Vasilieva", Priority.urgent);

        dairyList.add(task1);
        dairyList.add(task2);
        dairyList.add(task3);
        dairyList.add(task4);
        dairyList.add(task5);
        dairyList.add(task6);

        FileReadWrite<DairyData> file = new FileReadWrite<>();
        file.fileWrite(dairyList, filePath);
        System.out.println("Исходный список дел: ");
        file.fileRead(filePath);
        System.out.println();
        System.out.println("Отсортированный по важности список дел: ");
        file.fileSort(filePath);

        String searchName = "Anna Ivanova";
        // file.fileSearchByName(searchName, filePath);
    }
}
