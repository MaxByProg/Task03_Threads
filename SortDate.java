package Task03_Threads;

import java.text.*;
import java.util.*;
/**
 * Created by mbikov on 09.08.2017.
 */
public class SortDate {

    // метод для сортировки дат
    public List<Date> sortDate(List<String> list) {
        List<Date> comparedList = new ArrayList<>(); // лист с датами
        SimpleDateFormat parser = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date date;
        // парсим даты и добавляем в comparedList
        try {
            for (int i = 0; i < list.size(); i++) {
                date = parser.parse(list.get(i));
                comparedList.add(date);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Collections.sort(comparedList); // сортируем comparedList

        return comparedList;
    }

}
