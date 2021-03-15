package Kiste;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) throws IOException
    {
        List<Flasche> flaschen = new ArrayList<Flasche>();

        for(int i = 0; i < 2; i++){
            flaschen.add(new Flasche(500, 200));
            flaschen.add(new VerschlussFlasche(600, 250));
        }

        FlaschenKiste kiste = new FlaschenKiste(flaschen);

        
        Mensch m1 = new Mensch("M1", 3, kiste);
        Mensch m2 = new Mensch("M2", 9, kiste);
        Mensch m3 = new Mensch("M3", 20, kiste);

        BufferedReader reader = new BufferedReader( 
            new InputStreamReader(System.in)); 
        reader.readLine();
        System.exit(0);
    }
}
