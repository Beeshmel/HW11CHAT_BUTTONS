package work_with_files;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile {
    public static void main(String[] args) throws FileNotFoundException {
//        File file = new File("./src/тест.txt");
//        File file = new File(".\\src\\тест.txt");'
        File file = new File(System.getProperty("user.dir")+File.separator+"src"+File.separator+"тест.txt");
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()){
            System.out.println(sc.nextLine());
        }
        sc.close();
    }
}
