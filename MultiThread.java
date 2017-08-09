package Task03_Threads;

import java.io.*;
import java.util.*;

/**
 * Created by mbikov on 09.08.2017.
 */
class MultiThread implements Runnable{
    private static BufferedReader br = null;
    private List<String> list;
    public static List<String> endList = new ArrayList<>();


    static{
        try {
            br = new BufferedReader(new FileReader("C:\\Users\\mbikov\\Desktop\\Task03\\Task03.txt"), 10);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void run() {
        long timeout = System.currentTimeMillis();
        String line = null;
        int count = 0;
        while(true) {
            this.list = new ArrayList<>();
            synchronized(br) {
                try {
                    while((line = br.readLine()) != null) {
                        if(count<50) {
                            list.add(line);
                            endList.add(line);
                            count++;
                        }else {
                            list.add(line);
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
                //display(this.endList);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(line == null)
                break;
        }
        timeout = System.currentTimeMillis() - timeout;
        System.out.println(timeout);

    }

    public void display(List<String> list) {
//        for(String str:list) {
//            System.out.println(str);
//        }
        System.out.println(list.size());
    }

}
