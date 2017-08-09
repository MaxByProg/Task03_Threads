package Task03_Threads;

import Task02_Structure.SortDate;

/**
 * Created by mbikov on 09.08.2017.
 */
public class Main {
    public static void main(String[] args) {
        RandomDate date = new RandomDate();
        date.randomDate();
        Thread t1=new Thread(new MultiThread(),"A");
        Thread t2=new Thread(new MultiThread(),"B");
        t1.start();
        t2.start();


//        SortDate.UntilMinuteComparator comparator = new SortDate.UntilMinuteComparator();
//        System.out.println(SortDate.isWarn(t1.list.get(0), dates.get(1), comparator));
//        System.out.println(SortDate.isWarn(dates.get(0), dates.get(2), comparator));
//        System.out.println(SortDate.isWarn(dates.get(0), dates.get(3), comparator));
    }
}
