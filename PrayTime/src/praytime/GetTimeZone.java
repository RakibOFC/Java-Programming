package praytime;

import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.TimeZone;

public class GetTimeZone {

    public static void main(String[] args) {

        TimeZone timeZoneValue = TimeZone.getTimeZone(TimeZone.getDefault().getID());
        double timeZoneDiff = timeZoneValue.getOffset(Calendar.ZONE_OFFSET);
        System.out.println(timeZoneDiff/(1000*60*60));
    }
}
