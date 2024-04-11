package work_with_files;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Matrix {
    public static void main(String[] args) throws IOException {
        File file = new File("./src/matrix.txt");
        Scanner scanner = new Scanner(file);
        int rowCounter = 0;//номер строки
        String row;
        String mas[] = null;
        String output = "";
        while (scanner.hasNextLine()){
            rowCounter++;
            row = scanner.nextLine();
            mas = row.split(",");
            for (int i = 0; i < mas.length; i++) {
                output += (int)Math.pow(Double.parseDouble(mas[i]),rowCounter);
                if(i < mas.length - 1){
                    output += ",";
                }
            }
            output += "\n";
        }
        scanner.close();

//        System.out.println(output);

        FileWriter writer = null;
        try{
            writer = new FileWriter(file,true);
            writer.write("\n"+output);
        }catch (Exception e){
            System.out.println("Ошибка при записи в файл");
        }finally {
            writer.flush();
            writer.close();
        }


    }
}
