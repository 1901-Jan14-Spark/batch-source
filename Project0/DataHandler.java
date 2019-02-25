import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;

public class DataHandler {
    public void newAndUpdateUser(User user) {
        try {
            FileWriter fileWriter = new FileWriter("user.txt");
            fileWriter.write(user.toString());
            fileWriter.close();
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public String getUser() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("user.txt"));
            String string = bufferedReader.readLine();
            bufferedReader.close();
            return string;
        }
        catch (Exception exception) {
            return "";
        }
    }
}