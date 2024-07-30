package isklyucheniya;

import java.io.FileWriter;
import java.io.IOException;

public class FileHandler {
    public void save(String nameFale,Person person){

            try (FileWriter fileWriter = new FileWriter(nameFale, true)) {

                fileWriter.write(person.toString()+"\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
