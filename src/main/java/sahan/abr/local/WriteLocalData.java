package sahan.abr.local;

import java.io.FileWriter;
import java.io.IOException;

public class WriteLocalData {

    FileWriter fileWriter;

    public void writeData(){
        try {
            fileWriter = new FileWriter("C:/Users/User/Desktop/SRM_javaFX/src/main/java/sahan/abr/file/test.txt");
            fileWriter.write ("Something");
            fileWriter.write ("Something else");
            System.out.println("Document completed.");
            fileWriter.close();
        } catch (IOException exception){
            System.out.println("ERROR : " + exception.getMessage());
        }
    }

}
