package Task03_Threads;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/**
 * Created by mbikov on 09.08.2017.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<String> list1;
        RandomDate date = new RandomDate();
        date.randomDate();

        Thread t1=new Thread(new MultiThread(),"A");
        Thread t2=new Thread(new MultiThread(),"B");
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        SortDate compared = new SortDate();
        list1 = compared.sortDate(MultiThread.endList);

        try {
            PrintWriter writer = new PrintWriter("C:\\Users\\mbikov\\Desktop\\Task03\\Task03_Sorted.txt", "UTF-8");
            for (int i = 0; i < list1.size(); i++) {
                writer.println(list1.get(i));
            }
            writer.close();
        }catch(IOException e) {
            e.printStackTrace();
        }
    }
}
