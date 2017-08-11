package Task03_Threads;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by mbikov on 09.08.2017.
 */
public class Main implements FilePaths {
    //    public static List<ArrayList<String>> list12 = new ArrayList<>();
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        List<Date> list1;
        List<String> list2 = new ArrayList<>();
        int num = 10;
        File myFile = new File(dataFile);
        MultiThread[] threads = new MultiThread[10];
        RandomDate date = new RandomDate();
        date.randomDate();

//        MultiThread t1 = new MultiThread(myFile,1, 10);
//        list2 = t1.getEndList();

        for (int i = 0; i < num ; i++) {
            threads[i] = new MultiThread(myFile, num ,i );
            threads[i].start();
        }

        for (int i = 0; i < num; i++) {
            threads[i].join();
        }

        for (int i = 0; i < num; i++) {
            list2.addAll(threads[i].getEndList());
        }


//        try {
//            PrintWriter writer = new PrintWriter(outDataFile, "UTF-8");
//            for (int i = 0; i < list2.size(); i++) {
//                writer.println(list2.get(i));
//            }
//            writer.close();
//        }catch(IOException e) {
//            e.printStackTrace();
//        }

        SortDate compared = new SortDate();
        list1 = compared.sortDate(list2);
        SimpleDateFormat parser = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        try {
            PrintWriter writer = new PrintWriter(outDataFile, "UTF-8");
            for (int i = 0; i < list1.size(); i++) {
                writer.println(parser.format(list1.get(i)));
            }
            writer.close();
        }catch(IOException e) {
            e.printStackTrace();
        }
    }
}
