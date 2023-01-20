import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class FileReadWrite <T extends DairyData>{
    
    public void fileCreate(String filePath) {
        try {
            File file = new File(filePath);
            file.createNewFile();
        } catch (IOException e) {
            System.out.println("Error" + e);
        }
    }

    public void fileWrite(List<T> dairyList, String filePath) {
        try {
            FileWriter fileWriter = new FileWriter(filePath);
            fileWriter.append("ID;FullName;Date;Time\n");
            for (T d : dairyList) {
                fileWriter.append(String.valueOf(d.getId()));
                fileWriter.append(";");
                fileWriter.append(d.getFullName());
                fileWriter.append(";");
                fileWriter.append(d.getDate().toString());
                fileWriter.append(";");
                fileWriter.append(d.getTime().toString());
                fileWriter.append("\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Error" + e);
        }
    }

    public void fileSearch(String searchTerm, String filePath) {
        Scanner x;
        boolean found = false;
        String id = ""; String name = "";
        try {
            x = new Scanner(new File(filePath));
            x.useDelimiter("[,\n]");

            while (x.hasNext() && !found) {
                id = x.next();
                name = x.next();

                if (name.equalsIgnoreCase(searchTerm)){
                    found = true;
                }
            }

            if (found) {
                JOptionPane.showMessageDialog(null, "Объект найден\n" + "ID: "+ id + "," + " Имя: " + name, "Message", 1, null);
            } else {
                JOptionPane.showMessageDialog(null, "Объект не найден", "Message", 0, null);
            }

        } catch (IOException e) {
            System.out.println("Error:" + e);
        }
    }
       

        
}
