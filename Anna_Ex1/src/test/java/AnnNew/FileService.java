package AnnNew;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileService {
    public static BufferedWriter bw = null;
    public static BufferedReader br = null;
    public static String projectRootPath = "D:/IntellIJ-selenium/Anna_Ex1/src/test/java/AnnNew/";

    public static void writeToFile(List<String> elements) {
        try {
            bw = new BufferedWriter(new FileWriter(projectRootPath + "test.txt", true));
            for (String element : elements) {
                bw.append(element + "\n");
            }
            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<String> readFromFile() {
        ArrayList<String> result = new ArrayList<>();
        try {
            br = new BufferedReader(new FileReader(projectRootPath + "test.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                result.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

}
