
public class Two {

    final static double PHI = Math.PI;

    final static double TWO_PHI = 2 * PHI;

    final static double SUN_DIAMETER = 0.53;

    final static double AIR_REF = (34.0 / 60.0);

    private static int sunRise_hour;

    private static int sunRise_minute;

    private static int sunSet_hour;

    private static int sunSet_minute;

    private static double tmp_longitude;

    private static int tmp_hour;

    private static int tmp_minute;

    // Get the days to J2000
    // h is UT in decimal hours
    // getJulianDay only works between 1901 to 2099
    // 이 함수는 J2000 1월 1일 12시 DT를 기준으로 날수(Day Number)를 구합니다.
    // 입력값은 년,월,일,시간(실수값)입니다.
    private static double getJulianDay(int year, int month, int day) {

        double temp = -7.0f * ((double) year + ((double) month + 9.0f) / 12.0f)
                / 4.0f + 275.0f * (double) month / 9.0f + (double) day;

        // type casting necessary on PC DOS and TClite to avoid overflow
        temp += (double) (year * 367);

        return (temp - 730531.5f + 12.0f / 24.0f);

    }

    // the function below returns an angle in the range
    // 0 to 2*pi
    // 들어온 값을 항상 0~2pi 값안으로 normalize시킵니다.
    private static double getRangeRadian(double x) {

        double b = x / TWO_PHI;

        double a = TWO_PHI * (b - (long) (b));

        if (a < 0) {
            a = TWO_PHI + a;
        }

        return a;

    }

    // Calculating the hourangle
    // 시간각을 계산합니다.
    // lat:위도 declin:적위
    private static double getHourAngle(double lat, double declin) {

        double fo, dfo;

        // Correction: different sign at S HS
        dfo = PHI / 180.0 * (0.5 * SUN_DIAMETER + AIR_REF);

        if (lat < 0.0) {
            dfo = -dfo;
        }

        fo = Math.tan(declin + dfo) * Math.tan(lat * PHI / 180.0);

        if (fo > 0.99999) {
            fo = 1.0; // to avoid overflow //
        }
        fo = Math.asin(fo) + PHI / 2.0;

        return fo;

    }

    // Find the ecliptic longitude of the Sun
    // 태양의 황경을 구합니다.
    private static double getSunLongitude(double days) {

        double g;

        // mean longitude of the Sun (태양의 평균 황경)
        tmp_longitude = getRangeRadian(280.461 * PHI / 180.0 + .9856474 * PHI
                / 180.0 * days);

        // mean anomaly of the Sun (태양의 평균근점이각)
        g = getRangeRadian(357.528 * PHI / 180.0 + .9856003 * PHI / 180.0
                * days);

        // Ecliptic longitude of the Sun (태양의 황경계산)
        return getRangeRadian(tmp_longitude + 1.915 * PHI / 180.0 * Math.sin(g)
                + .02 * PHI / 180.0 * Math.sin(2 * g));

    }

    private static void convertDtime2Rtime(double dHour) {

        tmp_hour = (int) dHour;

        tmp_minute = (int) ((dHour - (double) tmp_hour) * 60);

    }

    private static boolean detectCurrentInDayTime(int year, int month, int day,
            int hour, int minute, double latitude, double longitude) {

        double tzone;

        double lambda, obliq;

        double alpha, delta;

        double LL, days;

        double equation, ha, sunRiseTime, sunSetTime;

        int dSunRiseT, dSunSetT, dNowT;

        // 관측장소의 경도(단위 degree),위도(단위 degree),타임존(단위시간) 값을 입력받습니다.

        /*

		 * year = 2011; month = 1; day = 1; latitude = 37.279198; //한국내 임의 위치의

		 * 위도 입력 longitude = 127.044032; //한국내 임의 위치의 경도 입력

         */
        tzone = 9.0f; // 한국은 Time Zone이 +9 임

        days = getJulianDay(year, month, day);

        // 태양의 황경
        lambda = getSunLongitude(days);

        // Obliquity of the ecliptic (s황도기울기 계산)
        obliq = 23.439 * PHI / 180.0 - .0000004 * PHI / 180.0 * days;

        // Find the RA and DEC of the Sun (태양의 적경,적위 계산)
        alpha = Math.atan2(Math.cos(obliq) * Math.sin(lambda),
                Math.cos(lambda)); // 태양의 적경

        delta = Math.asin(Math.sin(obliq) * Math.sin(lambda)); // 태양의 적위

        // Find the Equation of Time in minutes
        // Correction suggested by David Smith
        // 균시차 계산
        LL = tmp_longitude - alpha;

        if (tmp_longitude < PHI) {
            LL += TWO_PHI;
        }

        equation = 1440.0 * (1.0 - LL / TWO_PHI);

        ha = getHourAngle(latitude, delta);

        sunRiseTime = 12.0 - 12.0 * ha / PHI + tzone - longitude / 15.0
                + equation / 60.0;

        sunSetTime = 12.0 + 12.0 * ha / PHI + tzone - longitude / 15.0
                + equation / 60.0;

        if (sunRiseTime > 24.0) {
            sunRiseTime -= 24.0;
        }

        if (sunSetTime > 24.0) {
            sunSetTime -= 24.0;
        }

        convertDtime2Rtime(sunRiseTime);

        sunRise_hour = tmp_hour;

        sunRise_minute = tmp_minute;

        convertDtime2Rtime(sunSetTime);

        sunSet_hour = tmp_hour;

        sunSet_minute = tmp_minute;

        // hour = 16; minute = 12; //임의의 Local Time을 설정하여 테스트

        /*

		 * System.out.printf("Now Time: %d:%d\n",hour,minute);

		 * System.out.printf("Sunrise: %d:%d\n",sunRise_hour,sunRise_minute);

		 * System.out.printf("Sunrise: %d:%d\n",sunSet_hour,sunSet_minute);

         */
        dNowT = hour * 60 + minute;

        dSunRiseT = sunRise_hour * 60 + sunRise_minute;

        dSunSetT = sunSet_hour * 60 + sunSet_minute;

        if (dNowT <= dSunRiseT || dNowT >= dSunSetT) {

            // System.out.printf("Night\n");
            return false;

        } else {

            // System.out.printf("Day\n");
            return true;

        }

    }

    public static boolean detectSunshine(int year, int month, int day,
            int hour, int minute, double latitude, double longitude,
            double accuracy) {

        if (accuracy > 50.0) {
            return false; // Indoor
        }

        // Outdoor, Check State of Sun in Input Time and Location
        boolean isCIDT = true;

        return isCIDT;

    }

    public static void main(String[] args) {

        int year = 2018;

        int month = 7;

        int day = 25;

        int hour = 17;

        int minute = 13;

        double latitude = 37.279198;

        double longitude = 127.044032;

        double accuracy = 20.4718;

        boolean isSun = true;

        System.out.println(isSun);

    }

}
