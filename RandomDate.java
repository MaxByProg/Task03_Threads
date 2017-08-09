package Task03_Threads;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Created by mbikov on 09.08.2017.
 */
public class RandomDate {
    Long max =1000000000000L;
    SimpleDateFormat spf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

    public void randomDate() {
        try {
            PrintWriter writer = new PrintWriter("C:\\Users\\mbikov\\Desktop\\Task03\\Task03.txt", "UTF-8");
            for (int i = 0; i < 200000; i++) {
                Random r = new Random();
                Long randomLong = (r.nextLong() % max);
                Date dt = new Date(randomLong);
                writer.println(spf.format(dt));
            }
            writer.close();
        } catch (IOException e) {
        }
    }
}
