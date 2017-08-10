package Task03_Threads;

import java.text.*;
import java.util.*;
/**
 * Created by mbikov on 09.08.2017.
 */
public class SortDate {

    // метод для сортировки дат
    public List<String> sortDate(List<String> list) {
        List<Date> comparedList = new ArrayList<>(); // лист с датами
        List<String> stringList = new ArrayList<>();// итоговый отформатированный лист
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

        //форматируем отсортированный comparedList и добавляем данные в stringList
        for (int i = 0; i < comparedList.size() ; i++) {
            stringList.add(parser.format(comparedList.get(i)));
        }

        return stringList;
    }

}
