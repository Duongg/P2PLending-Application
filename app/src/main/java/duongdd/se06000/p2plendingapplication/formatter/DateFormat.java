package duongdd.se06000.p2plendingapplication.formatter;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class DateFormat {

    public static String formatDate(Date date){
//        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//        Date parsedDate = sdf.parse(date);
        SimpleDateFormat print = new SimpleDateFormat("dd/MM/yyyy");
        return print.format(date);
    }
}
