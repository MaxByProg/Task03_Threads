package Task03_Threads;

import java.io.*;
import java.util.*;

/**
 * Created by mbikov on 09.08.2017.
 */
class MultiThread implements Runnable{
    private static BufferedReader br = null;
    public static List<String> endList = new ArrayList<>(); // итоговый массив со считанными датами из файла


    static{
        try {
            br = new BufferedReader(new FileReader("C:\\Users\\mbikov\\Desktop\\Task03\\Task03.txt"));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    // переопределили метод для считывания данных из файла построчно
    public void run() {
        long timeout = System.currentTimeMillis(); //засекаем время работы метода
        String line = null;
        int count = 0;
        while(true) {
            synchronized(br) {
                try {
                    while((line = br.readLine()) != null) {
                        if(count<50) {
                            endList.add(line);
                            count++;
                        }else {
                            endList.add(line);
                            count = 0;
                            break;
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(line == null)
                break;
        }
        timeout = System.currentTimeMillis() - timeout;
        System.out.println(timeout);

    }

}
