package com.unimedsci.ydata.jxc.commons.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Gurongjing on 2017/6/12.
 * Hfkj
 */
public class DateFormatUtil {

    public static final long OneDayMillis = 86400000;

    public static Date formatForDataTime(String date) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        simpleDateFormat.setLenient(false);
        Date date1 = simpleDateFormat.parse(date);
        return date1;
    }

    public static Date formatForData(String date) throws ParseException {
        if (date == null || date.equals(""))
            return null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        simpleDateFormat.setLenient(false);
        Date date1 = simpleDateFormat.parse(date);
        return date1;
    }

    public static Date formatForDate(String date) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM");
        simpleDateFormat.setLenient(false);
        Date date1 = simpleDateFormat.parse(date);
        return date1;
    }

    public static Date formatDate(Date date) throws ParseException {
        if (date == null)
            return null;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(date);
        Date currentTime_2 = formatter.parse(dateString);
        return currentTime_2;
    }

    public static Date formatDateYM(Date date) throws ParseException {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM");
        String dateString = formatter.format(date);
        Date currentTime_2 = formatter.parse(dateString);
        return currentTime_2;
    }

    public static Date getDate(int days) {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTimeInMillis(calendar.getTimeInMillis() + days * OneDayMillis);
        calendar = new GregorianCalendar(calendar.get(GregorianCalendar.YEAR), calendar.get(GregorianCalendar.MONTH), calendar.get
                (GregorianCalendar.DAY_OF_MONTH));
        return calendar.getTime();
    }

    /**
     * @param beginTime 启始时间
     * @param endTime   结束时间
     * @return 微妙差
     * @throws ParseException exception
     */
    public static long getTimeSlot(String beginTime, String endTime) throws ParseException {
        return (formatForDataTime(endTime).getTime() - formatForDataTime(beginTime).getTime()) / 1000;
    }

    /**
     * @param beginTime 启始时间
     * @param endTime   结束时间
     * @return 微妙差
     * @throws ParseException exception
     */
    public static long getTimeSlot(Date beginTime, Date endTime) throws ParseException {
        return (endTime.getTime() - beginTime.getTime()) / 1000;
    }

    public static Date getMonday(int year, int week) {
        GregorianCalendar calendar = new GregorianCalendar(year, 0, 1);
        // SUNDAY=1
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        int sub = (dayOfWeek + 5) % 7;
        calendar.setTimeInMillis(calendar.getTimeInMillis() + (7 * week - 7 - sub) * OneDayMillis);
        return calendar.getTime();
    }

    /**
     * 根据传入的日期，取得周一的日期（一周的第一天是周一）
     */
    public static Date getMonday(Date current) {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(current);
        int dayOfWeek = calendar.get(GregorianCalendar.DAY_OF_WEEK);
        int sub = (dayOfWeek + 5) % 7;
        if (sub != 0) {
            calendar.setTimeInMillis(calendar.getTimeInMillis() - OneDayMillis * sub);
        }
        calendar = new GregorianCalendar(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        return calendar.getTime();
    }

    /**
     * 根据传入的日期，取得周日的日期（一周的第一天是周一）
     */
    public static Date getSunday(Date current) {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(current);
        int dayOfWeek = calendar.get(GregorianCalendar.DAY_OF_WEEK);
        int sub = (dayOfWeek + 5) % 7;
        if (sub != 0) {
            calendar.setTimeInMillis(calendar.getTimeInMillis() - OneDayMillis * (sub - 6));
        } else {
            calendar.setTimeInMillis(calendar.getTimeInMillis() + OneDayMillis * 6);
        }
        calendar = new GregorianCalendar(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        return calendar.getTime();
    }

    public static Date getMonthFirstDay(Date current) {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(current);
        calendar = new GregorianCalendar(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), 1);
        return calendar.getTime();
    }

    public static Date getMonthLastDay(Date current) {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(current);
        int month = calendar.get(Calendar.MONTH);
        if (month == 11) {
            calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) + 1);
            calendar.set(Calendar.MONTH, 0);
        } else {
            calendar.set(Calendar.MONTH, month + 1);
        }
        calendar = new GregorianCalendar(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), 1, 23, 59, 59);
        calendar.setTimeInMillis(calendar.getTimeInMillis() - OneDayMillis);
        return calendar.getTime();
    }

    public static Integer getYearMonthDay(Date date) {
        if (date == null) {
            return null;
        }
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        return calendar.get(GregorianCalendar.YEAR) + 10000 + (calendar.get(Calendar.MONTH) + 1) + 10 + calendar.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 比较两个日期相差几天
     */
    public static int compareDays(Date current, Date other) {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(current);
        calendar = new GregorianCalendar(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        long timeInMillis = calendar.getTimeInMillis();

        calendar.setTime(other);
        calendar = new GregorianCalendar(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        long timeInMillis1 = calendar.getTimeInMillis();
        return (int) ((timeInMillis - timeInMillis1) / OneDayMillis);
    }

    public static Date addDays(Date current, int days) {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(current);
        calendar.setTimeInMillis(calendar.getTimeInMillis() + days * OneDayMillis);
        return calendar.getTime();
    }

    public static Integer getYearMonthByDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.YEAR) * 100 + calendar.get(Calendar.MONTH) + 1;
    }

    public static Integer getYearMonthDayByDate(Date date) {
        if (date == null) {
            return null;
        }
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        return calendar.get(Calendar.YEAR) * 10000 + (calendar.get(Calendar.MONTH) + 1) * 100 + calendar.get(Calendar.DAY_OF_MONTH);
    }

    public static Integer getYearByDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.YEAR);
    }

    public static Integer getMonthByDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MONTH) + 1;
    }

    public static Integer getDayByDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    public static Integer getHourByDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.HOUR_OF_DAY);
    }

    public static String getFormatValueYMD(Date date) {
        if (date == null) {
            return "";
        }
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        return calendar.get(Calendar.YEAR) + "." + (calendar.get(Calendar.MONTH) + 1) + "." + calendar.get(Calendar.DAY_OF_MONTH);
    }

    public static String getFormatValueYMDLine(Date date) {
        if (date == null) {
            return "";
        }
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        return calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH) + 1) + "-" + calendar.get(Calendar.DAY_OF_MONTH);
    }

    public static String getFormatValueYMDTemp(Date date) {
        if (date == null) {
            return "";
        }
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        Integer year = Calendar.YEAR;
        Integer month = calendar.get(Calendar.MONTH) + 1;
        Integer day = calendar.get(Calendar.DAY_OF_MONTH);
        String monthString = null;
        String dayString = null;
        if (month <= 9) {
            monthString = "0" + month;
        } else {
            monthString = month.toString();
        }
        if (day <= 9) {
            dayString = "0" + day;
        } else {
            dayString = day.toString();
        }
        return calendar.get(Calendar.YEAR) + "." + monthString + "." + dayString;
    }

    public static int differentDaysByMillisecond(Date date1, Date date2) {
        int days = (int) ((date2.getTime() - date1.getTime()) / (1000 * 3600 * 24));
        return days;
    }

    public static String getFormatValueYMDHMS(Date date) {
        if (date == null) {
            return "";
        }
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        String str = calendar.get(Calendar.YEAR) + "." + (calendar.get(Calendar.MONTH) + 1) + "." + calendar.get(Calendar.DAY_OF_MONTH);
        str += " ";
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        if (hour < 10) {
            str += "0";
        }
        str += hour + ":";
        int minute = calendar.get(Calendar.MINUTE);
        if (minute < 10) {
            str += "0";
        }
        str += minute + ":";
        int second = calendar.get(Calendar.SECOND);
        if (second < 10) {
            str += "0";
        }
        str += second;
        return str;
    }

    /**
     * 得到一周时间
     *
     * @param startDate 开始时间
     * @return
     */
    public static List<Date> getOneWeekByStartDate(Date startDate, Integer day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);
        List<Date> dates = new ArrayList<Date>();
        for (int i = 0; i <= day; i++) {
            dates.add(getAfterDay(calendar, i).getTime());
            calendar.setTime(startDate);
        }
        return dates;
    }

    /**
     * 得到一周时间
     *
     * @param startDate 开始时间
     * @return
     */
    public static List<Date> getOneMonthByStartDate(Date startDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);
        List<Date> dates = new ArrayList<Date>();
        for (int i = 1; i < 7; i++) {
            dates.add(getAfterMonth(calendar, i).getTime());
            calendar.setTime(startDate);
        }
        return dates;
    }


    private static Calendar getAfterMonth(Calendar cl, Integer i) {
        int month = cl.get(Calendar.MONTH);
        cl.set(Calendar.MONTH, month + i);
        return cl;
    }

    public static boolean sameDate(Date d1, Date d2) {
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        return fmt.format(d1).equals(fmt.format(d2));
    }

    public static boolean sameDate2(Date d1, Date d2) {
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM");
        return fmt.format(d1).equals(fmt.format(d2));
    }

    private static Calendar getAfterDay(Calendar cl, Integer i) {
        int day = cl.get(Calendar.DATE);
        cl.set(Calendar.DATE, day + i);
        return cl;
    }

    public static Date createDateYYYYMM(Integer year, Integer month) throws ParseException {
        if (month <= 9) {
            String date = year + "-" + "0" + month;
            return formatForDate(date);
        } else {
            String date = year + "-" + month;
            return formatForDate(date);
        }
    }

//    public static void main(String[] args) throws Exception {
//        Date date = formatForData("2017-02-06");
//        System.out.println(getFormatValueYMDTemp(date));
////        getMonday(2017, 1);
////        getMonday(2017, 2);
////        getMonday(2017, 3);
////        getMonday(2017, 4);
////        getMonday(2017, 5);
////        getMonday(2017, 6);
////        getMonday(2017, 7);
////        getMonday(2017, 49);
////        getMonday(2017, 50);
////        getMonday(2017, 51);
////        getMonday(2017, 52);
////        getMonday(2017, 53);
////        getMonday(2017, 54);
//    }

    /**
     * 统计时间变更(月开始时间)
     *
     * @param year  年
     * @param month 月
     * @return date
     * @throws ParseException exception
     */
    public static Date getStartDate(Integer year, Integer month) {
        if (month == 1) {
            month = 13;
            year = year - 1;
        }
        GregorianCalendar calendar = new GregorianCalendar(year, month - 2, 26);
        return calendar.getTime();
    }

    public static Date getStartDate(Date startDate) {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(startDate);
        int month = calendar.get(Calendar.MONTH) + 1;
        int year = calendar.get(Calendar.YEAR);
        return getStartDate(year, month);
    }

    /**
     * 统计时间变更(月结束时间)
     *
     * @param year  年
     * @param month 月
     * @return date
     * @throws ParseException exception
     */
    public static Date getEndDate(Integer year, Integer month) {
        GregorianCalendar calendar = new GregorianCalendar(year, month - 1, 25);
        return calendar.getTime();
    }

    public static Date getEndDate(Date endDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(endDate);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        return getEndDate(year, month);
    }

    /**
     * 根据时间得到表头
     *
     * @param start 开始时间
     * @param end   结束时间
     * @return 表头合计
     */
    public static List<String> getTableTitle(Date start, Date end) {
        Integer year1 = getYearByDate(start);
        Integer month1 = getMonthByDate(start);
        Integer day1 = getDayByDate(start);

        Integer year2 = getYearByDate(end);
        Integer month2 = getMonthByDate(end);
        Integer day2 = getDayByDate(end);

        List<String> titles = new ArrayList<String>();
        Integer num = (year2 - year1) * 12 + (month2 - month1);

        for (int i = 0; i <= num; i++) {
            titles.add(getString(year1, month1, i));
        }
        if (day1 >= 26) {
            titles.remove(year1 + "." + month1);
        }
        if (day2 >= 26) {
            if (month2 == 12) {
                titles.add((year2 + 1) + "." + "1");
            } else {
                titles.add(year2 + "." + (month2 + 1));
            }
        }
        return titles;
    }

    public static List<String> getTableTitle1(List<Date> title) {
        List<String> titles = new ArrayList<String>();
        if (title != null && title.size() > 0) {
            for (Date date : title) {
                Integer year = getYearByDate(date);
                Integer month = getMonthByDate(date);
                titles.add(year + "." + month);
            }
        }
        return titles;
    }

    /**
     * 根据时间得到表头
     *
     * @param start 开始时间
     * @param end   结束时间
     * @return 表头合计
     */
    public static List<Date> getTableTitleDate(Date start, Date end) throws ParseException {
        Integer year1 = getYearByDate(start);
        Integer month1 = getMonthByDate(start);
        Integer day1 = getDayByDate(start);

        Integer year2 = getYearByDate(end);
        Integer month2 = getMonthByDate(end);
        Integer day2 = getDayByDate(end);

        List<Date> titles = new ArrayList<Date>();
        Integer num = (year2 - year1) * 12 + (month2 - month1);

        for (int i = 0; i <= num; i++) {
            titles.add(getDateBy(year1, month1, i));
        }
        if (day1 >= 26) {
            titles.remove(createDateYYYYMM(year1, month1));
        }
        if (day2 >= 26) {
            if (month2 == 12) {
                titles.add(createDateYYYYMM(year2 + 1, 1));
            } else {
                titles.add(createDateYYYYMM(year2, month2 + 1));
            }
        }
        if (titles.size() > 0) {
            Date last = titles.get(titles.size() - 1);
            Integer year = getYearByDate(last);
            Integer month = getMonthByDate(last);
            Date next = createDateYYYYMM(month == 12 ? year + 1 : year, month == 12 ? 1 : month + 1);
            titles.add(next);
        }
        return titles;
    }

    private static String getString(Integer year1, Integer month1, Integer i) {
        if ((month1 + i) % 12 == 0) {
            return year1 + ((month1 + i) / 12 - 1) + "." + "12";
        } else {
            return year1 + ((month1 + i) / 12) + "." + (month1 + i) % 12;
        }
    }

    private static Date getDateBy(Integer year1, Integer month1, Integer i) throws ParseException {
        if ((month1 + i) % 12 == 0) {
            return createDateYYYYMM(year1 + ((month1 + i) / 12 - 1), 12);

        } else {
            return createDateYYYYMM(year1 + ((month1 + i) / 12), (month1 + i) % 12);
        }
    }

    public static Date getFirstDay(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cale = Calendar.getInstance();
        cale.setTime(date);
        cale.add(Calendar.MONTH, 0);
        cale.set(Calendar.DAY_OF_MONTH, 1);
        return cale.getTime();
        // 获取前月的最后一天

    }

    public static Date getFLastDay(Date date) {
        Calendar cale = Calendar.getInstance();
        cale.setTime(date);
        cale = Calendar.getInstance();
        cale.add(Calendar.MONTH, 1);
        cale.set(Calendar.DAY_OF_MONTH, 0);

        // 获取前月的最后一天
        return cale.getTime();
    }

    public static String getYMDHS(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return format.format(date).replaceAll("-",".");
    }

    public static void main(String[] args) {
        System.out.println(getYMDHS(new Date()));
    }

}
