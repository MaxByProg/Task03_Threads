package Task03_Threads;

import java.io.*;
import java.util.*;

/**
 * Created by mbikov on 09.08.2017.
 */
class MultiThread extends Thread implements FilePaths{
    private BufferedReader br = null;
    private static File file;
    private int start;
    private int num;
    private List<String> endList;

    MultiThread(File file, int num, int start) {
        try {
            this.file = file;
            br = new BufferedReader(new FileReader(file));
            this.start = start;
            this.num = num;
            endList = new ArrayList<>();
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List<String> getEndList() {
        return endList;
    }

    public void run() {
        String line;
        long count = 0;
        try {
            if(start > 0 && start < num)
                br.skip(start * (file.length() / num));
            while ((line = br.readLine()) != null && count < file.length() / num) {
                endList.add(line);
                count += line.length();
            }
            System.out.println(count);
            System.out.println(file.length()/num);
            System.out.println(start * (file.length() / num));
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        }

    }
