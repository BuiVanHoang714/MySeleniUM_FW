package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeUtil {
    public static String getTimeNow() {
        return getDateTimeNow("hh_mm_ss");
    }

    public static String getDateNow() {
        return getDateTimeNow("dd_MM_yyyy");
    }

    public static String getDateTimeNow() {
        return getDateTimeNow("dd_MM_yy - hh_mm_ss");
    }

    public static String getDateTimeNow(String format) {
        Date date = new Date();
        SimpleDateFormat ft = new SimpleDateFormat(format);
        return ft.format(date);
    }
}
