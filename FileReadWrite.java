import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class FileReadWrite <T extends DairyData>{
    
    
    public void fileWrite(List<T> dairyList, String filePath) {
        try {
            File file = new File(filePath);
            file.createNewFile();
            FileWriter fileWriter = new FileWriter(filePath);
            fileWriter.append("ID;FullName;Date;Time;Priority\n");
            for (T d : dairyList) {
                fileWriter.append(String.valueOf(d.getId()));
                fileWriter.append(";");
                fileWriter.append(d.getFullName());
                fileWriter.append(";");
                fileWriter.append(d.getDate().toString());
                fileWriter.append(";");
                fileWriter.append(d.getTime().toString());
                fileWriter.append(";");
                fileWriter.append(d.getPriority().toString());
                fileWriter.append("\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Error" + e);
        }
    }

    public void fileRead(String filePath) {
        BufferedReader reader = null;

        try {
            List<DairyData> dairyList = new ArrayList<>();
            String line = "";
            reader = new BufferedReader(new FileReader(filePath));
            reader.readLine();

            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(";");

                if (fields.length > 0) {
                    DairyData task = new DairyData();
                    task.setId(Integer.parseInt(fields[0]));
                    task.setFullName(fields[1]);
                    task.setDate(LocalDate.parse(fields[2]));
                    task.setTime(LocalTime.parse(fields[3]));
                    task.setPriorityString(fields[4]);
                    dairyList.add(task);
                }
            }

            for (DairyData d : dairyList) {
                System.out.println(d);
            }
        } catch(IOException e) {

        }
    }

    public void fileSearchByName(String searchTerm, String filePath) {
        Scanner x;
        boolean found = false;
        String id = ""; String name = "";
        try {
            x = new Scanner(new File(filePath));
            x.useDelimiter("[;\n]");

            while (x.hasNext() && !found) {
                id = x.next();
                name = x.next();

                if (name.equalsIgnoreCase(searchTerm)){
                    found = true;
                }
            }

            if (found) {
                JOptionPane.showMessageDialog(null, "???????????? ????????????\n" + "ID: "+ id + " ??????: " + name, "Message", 1, null);
            } else {
                JOptionPane.showMessageDialog(null, "???????????? ???? ????????????", "Message", 0, null);
            }

        } catch (IOException e) {
            System.out.println("Error:" + e);
        }
    }
       
    public void fileSort(String filePath) {
        BufferedReader reader = null;

        try {
            List<DairyData> dairyList = new ArrayList<>();
            String line = "";
            reader = new BufferedReader(new FileReader(filePath));
            reader.readLine();

            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(";");

                if (fields.length > 0) {
                    DairyData task = new DairyData();
                    task.setId(Integer.parseInt(fields[0]));
                    task.setFullName(fields[1]);
                    task.setDate(LocalDate.parse(fields[2]));
                    task.setTime(LocalTime.parse(fields[3]));
                    task.setPriorityString(fields[4]);
                    dairyList.add(task);
                }
            }
            List<DairyData> urgentList = new ArrayList<>();
            List<DairyData> importantList = new ArrayList<>();
            List<DairyData> notImportanttList = new ArrayList<>();
            String urgent = "urgent";
            String important = "important";
            String notImportant = "notImportant";

            for (DairyData d : dairyList) {
                // String priority = d.getPriorityString();
                // System.out.println(priority);
                if (urgent.equals(d.getPriorityString())) {
                    urgentList.add(d);
                }
                if (important.equals(d.getPriorityString())) {
                    importantList.add(d);
                }
                if (notImportant.endsWith(d.getPriorityString())) {
                    notImportanttList.add(d);
                }
            }
            for (DairyData d : urgentList) {
                System.out.println(d);
            }
            for (DairyData d : importantList) {
                System.out.println(d);
            }
            for (DairyData d : notImportanttList) {
                System.out.println(d);
            }

        } catch(IOException e) {
            System.out.println("Error" + e);
        }
    }
        
}
