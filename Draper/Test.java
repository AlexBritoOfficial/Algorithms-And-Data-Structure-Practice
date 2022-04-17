package Draper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Test {
    public static void main(String[] args) throws ParseException {

        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date("12/05/2021"));
        calendar.getWeeksInWeekYear();

        String dateFormat = "Sun 12/05/2021";

        String[] parsedString = dateFormat.split("\\s+|/");
        System.out.println(parsedString);




//        switch (dayOfWeek) {
//            case 1:
//                day = Day.MONDAY;
//                break;
//
//            case 2:
//                this.day = Day.TUESDAY;
//                break;
//
//            case 3:
//                this.day = Day.WEDNESDAY;
//                break;
//
//            case 4:
//                this.day = Day.THURSDAY;
//                break;
//
//            case 5:
//                this.day = Day.FRIDAY;
//                break;
//
//            case 6:
//                this.day = Day.SATURDAY;
//                break;
//
//            case 7:
//                this.day = Day.SUNDAY;
//                break;
//        }
    }
}
