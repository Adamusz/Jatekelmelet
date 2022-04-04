import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class Fajl {

    static ArrayList<String> beolvaso() {
        ArrayList<String> sorok = new ArrayList<>();
        RandomAccessFile beolvas;
        try {
            beolvas = new RandomAccessFile("src/main/resources/adatok.txt", "r");
            while (beolvas.getFilePointer() < beolvas.length()) {
                sorok.add(beolvas.readLine());
            }
            beolvas.close();
        } catch (FileNotFoundException f) {
            System.out.println("Hiba: " + f.getMessage());
        } catch (IOException e) {
            System.out.println("Hiba: " + e.getMessage());
        }
        return sorok;
    }
}
