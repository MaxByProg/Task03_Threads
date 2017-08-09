package Task02_Structure;

import java.text.*;
import java.util.*;
/**
 * Created by mbikov on 09.08.2017.
 */
public class SortDate {

//    public static void main(String[] args) {
//
//        ArrayList<String> dates = new ArrayList<String>() {
//            {
//                add("10.11.2012 21:12:23");
//                add("10.11.2012 21:12:23");
//                add("10.11.2012 21:15:23");
//                add("10.11.2012 21:15");
//            }
//        };
//
//        UntilMinuteComparator comparator = new UntilMinuteComparator();
//        System.out.println(isWarn(dates.get(0), dates.get(1), comparator));
//        System.out.println(isWarn(dates.get(0), dates.get(2), comparator));
//        System.out.println(isWarn(dates.get(0), dates.get(3), comparator));
//
//    }

    public static String isWarn(String s1, String s2, Comparator<String> cmp) {
        return cmp.compare(s1, s2) == 0 ? "Warning" : "OK";
    }

    public static class UntilMinuteComparator implements Comparator<String> {
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        Date d1, d2;
        String s1, s2;

        @Override
        public int compare(String o1, String o2) {
            try {
                d1 = sdf1.parse(o1);
                d2 = sdf1.parse(o2);
                s1 = sdf2.format(d1);
                s2 = sdf2.format(d2);
            } catch (ParseException e) {
                throw new RuntimeException("Date format unsupported");
            }

            return s1.compareTo(s2);
        }

    }

}
