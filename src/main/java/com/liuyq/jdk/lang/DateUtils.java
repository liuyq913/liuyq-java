package com.liuyq.jdk.lang;

import org.apache.commons.lang3.time.DateFormatUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间工具类
 *
 * @author zf
 * @since p2p_cloud_v1.0
 */
public final class DateUtils
{
    private DateUtils()
    {
    }

    public enum EDateFormatPattern
    {
        yyyy("yyyy"), yyyy_MM("yyyy-MM"), yyyyMMdd("yyyyMMdd"), yyyy_MM_dd("yyyy-MM-dd"), dd("dd"), HH_mm_ss("HH_mm_ss"), yyyy_MM_dd_HH("yyyy-MM-dd HH"), yyyy_MM_dd_HH_mm(
                "yyyy-MM-dd HH-mm"), yyyy_MM_dd_HH_mm_ss("yyyy-MM-dd HH:mm:ss"), MMdd("MMdd"), MM_dd_HH_mm_ss(
                "MM-dd HH:mm:ss"), yyyyMMddhhmmss("yyyyMMddhhmmss"), yyyyMMddHHmmss("yyyyMMddHHmmss");

        private final String pattern;

        public String getPattern()
        {
            return this.pattern;
        }

        private EDateFormatPattern(String pattern)
        {
            this.pattern = pattern;
        }

        public static EDateFormatPattern getPattern(String pattern)
        {
            if (yyyy.getPattern().equals(pattern))
            {
                return yyyy;
            }
            else if (yyyy_MM.getPattern().equals(pattern))
            {
                return yyyy_MM;
            }
            else if (yyyyMMdd.getPattern().equals(pattern))
            {
                return yyyyMMdd;
            }
            else if (HH_mm_ss.getPattern().equals(pattern))
            {
                return HH_mm_ss;
            }
            else if (yyyy_MM_dd_HH.getPattern().equals(pattern))
            {
                return yyyy_MM_dd_HH;
            }
            else if (yyyy_MM_dd_HH.getPattern().equals(pattern))
            {
                return yyyy_MM_dd_HH;
            }
            else if (yyyy_MM_dd_HH_mm.getPattern().equals(pattern))
            {
                return yyyy_MM_dd_HH_mm;
            }
            else if (yyyy_MM_dd_HH_mm_ss.getPattern().equals(pattern))
            {
                return yyyy_MM_dd_HH_mm_ss;
            }
            else if (MMdd.getPattern().equals(pattern))
            {
                return MMdd;
            }
            else if (MM_dd_HH_mm_ss.getPattern().equals(pattern))
            {
                return MM_dd_HH_mm_ss;
            }
            else
            {
                throw new RuntimeException("日期格式不支持");
            }
        }
    }

    /**
     * 格式化当前时间字符串
     * 
     * @param pattern
     * @return
     */
    public static String fomateCurrDate(EDateFormatPattern pattern)
    {
        return DateFormatUtils.format(new Date(), pattern.getPattern());
    }

    /**
     * 获取当前时间yyyyMMdd格式字符串
     * 
     * @return
     */
    public static String getCurrDate()
    {
        return fomateCurrDate(EDateFormatPattern.yyyyMMdd);
    }
    
    /**
     * 获取当前时间
     * @return Date
     * @since p2p_cloud_v1.6
     */
    public static Date getNow() {
        Calendar cal = Calendar.getInstance();
        Date currDate = cal.getTime();
        return currDate;
    }

    /**
     * 获取当前时间yyyy-MM-dd格式字符串
     * 
     * @return
     */
    public static String getCurrDateUseLine()
    {
        return fomateCurrDate(EDateFormatPattern.yyyy_MM_dd);
    }

    /**
     * 根据指定格式化规则日期获取特定时间字符串
     * 
     * @param pattern
     * @return
     */
    public static String formatGeneralDate(Date date, EDateFormatPattern pattern)
    {
        if (date != null)
        {
            return DateFormatUtils.format(date, pattern.getPattern());
        }
        return "";
    }
    
    /**
     * 根据指定格式化规则日期获取特定时间字符串
     * 
     * @param pattern
     * @return
     */
    public static String formatSpecificDate(Date date, EDateFormatPattern pattern)
    {
        return DateFormatUtils.format(date == null ? new Date() : date, pattern.getPattern());
    }

    /**
     * 获取给定时间(日)
     * 
     * @param date
     * @param pattern
     * @return
     */
    public static String getGiveDay(Date date, EDateFormatPattern pattern, int amount)
    {
        return DateFormatUtils.format(
                org.apache.commons.lang3.time.DateUtils.addDays(date == null ? new Date() : date, amount),
                pattern.getPattern());
    }

    /**
     * 获取给定时间(年)
     * 
     * @param date
     * @param pattern
     * @return
     */
    public static String getGiveYear(Date date, EDateFormatPattern pattern, int amount)
    {

        return DateFormatUtils.format(
                org.apache.commons.lang3.time.DateUtils.addYears(date == null ? new Date() : date, amount),
                pattern.getPattern());
    }

    /**
     * 获取给定时间(月)
     * 
     * @param date
     * @param pattern
     * @return
     */
    public static String getGiveDateOMonth(Date date, EDateFormatPattern pattern, int amount)
    {

        return DateFormatUtils.format(
                org.apache.commons.lang3.time.DateUtils.addMonths(date == null ? new Date() : date, amount),
                pattern.getPattern());
    }

    /**
     * 获取给定时间(小时)
     * 
     * @param date
     * @param pattern
     * @param amount
     * @return
     */
    public static String getGiveHour(Date date, EDateFormatPattern pattern, int amount)
    {
        return DateFormatUtils.format(
                org.apache.commons.lang3.time.DateUtils.addHours(date == null ? new Date() : date, amount),
                pattern.getPattern());
    }

    /**
     * 获取给定时间(分钟)
     * 
     * @param date
     * @param pattern
     * @param amount
     * @return
     */
    public static String getGiveMinute(Date date, EDateFormatPattern pattern, int amount)
    {
        return DateFormatUtils.format(
                org.apache.commons.lang3.time.DateUtils.addMinutes(date == null ? new Date() : date, amount),
                pattern.getPattern());
    }

    /**
     * 
     * @param targetData
     *            目标时期
     * @param currDate
     *            当前时间
     * @param stamp
     *            时间戳 (单位小时)
     * @return
     */
    public static boolean isGreaterThanOrEqual(Date targetData, Date currDate, Integer stamp)
    {

        // long second= currDate.getTime() - targetData.getTime()/1000 ;//秒

        // 1000 * 60 * 60 * stamp 小时转成秒
        // 1000 * 60 * 60 * 24 一天的秒

        return (currDate.getTime() - targetData.getTime()) / 1000 < 1000 * 60 * 60 * stamp;

    }

    /**
     * 日期转毫秒数
     * 
     * @param dateString
     *            yyyy-MM-dd HH:mm:ss.SSS
     * @param formatString
     *            yyyy-MM-dd HH:mm:ss.SSS 任意组合
     * @return
     */
    public static long getStringByDate(String dateString, String formatString)
    {
        DateFormat sdf = new SimpleDateFormat(formatString);
        long time = 0l;
        try
        {
            time = sdf.parse(dateString).getTime();
        }
        catch(ParseException e)
        {
            e.printStackTrace();
        }
        return time;
    }

    /**
     * 
     * 获得第二天0点的时间
     * 
     * @return long
     * @since p2p_cloud_v1.0
     */
    public static long getTimeOf12()
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        cal.add(Calendar.DAY_OF_MONTH, 1);
        return cal.getTimeInMillis();
    }

    /**
     * 
     * 获得当天0点的时间
     * 
     * @param d
     * @param date
     * @return
     */
    public static Date getZeroTime(Date d)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    /**
     * 前/后?分钟
     * 
     * @param d
     * @param minute
     * @return
     */
    public static Date rollMinute(Date d, int minute)
    {
        return new Date(d.getTime() + minute * 60 * 1000);
    }

    /**
     * 前/后?天
     * 
     * @param d
     * @param day
     * @return
     */
    public static Date rollDay(Date d, int day)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        cal.add(Calendar.DAY_OF_MONTH, day);
        return cal.getTime();
    }

    /**
     * 前/后?月
     * 
     * @param d
     * @param mon
     * @return
     */
    public static Date rollMon(Date d, int mon)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        cal.add(Calendar.MONTH, mon);
        return cal.getTime();
    }

    /**
     * 前/后?年
     * 
     * @param d
     * @param year
     * @return
     */
    public static Date rollYear(Date d, int year)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        cal.add(Calendar.YEAR, year);
        return cal.getTime();
    }

    /**
     * 计算两个日期之间相差的天数
     * 
     * @param date1
     * @param date2
     * @return
     */
    public static int daysBetween(Date date1, Date date2)
    {
        return (int) Math.ceil((double) Math.abs(date1.getTime() - date2.getTime()) / (1000 * 3600 * 24));
    }

    public static Date getStrToDate(String date,EDateFormatPattern pattern) {
        DateFormat df = new SimpleDateFormat(pattern.getPattern());
        try {
            return df.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 天数相差，不包括当天
     * @param date1
     * @param date2
     * @return
     */
    public static int BetweenDayNoTime(Date date1, Date date2)
    {
        date1 = getStrToDate(formatSpecificDate(date1, EDateFormatPattern.yyyy_MM_dd), EDateFormatPattern.yyyy_MM_dd);
        date2 = getStrToDate(formatSpecificDate(date2, EDateFormatPattern.yyyy_MM_dd), EDateFormatPattern.yyyy_MM_dd);
        if (date1 != null && date2 != null) {
            return (int) Math.ceil((double) Math.abs(date1.getTime() - date2.getTime()) / (1000 * 3600 * 24));
        } else {
            return 0;
        }
    }

    /**
     * 天数相差，包括当天
     * @param date1
     * @param date2
     * @return
     */
    public static int BetweenDayNoTimeHaveToday(Date date1, Date date2)
    {
        date1 = getStrToDate(formatSpecificDate(date1, EDateFormatPattern.yyyy_MM_dd), EDateFormatPattern.yyyy_MM_dd);
        date2 = getStrToDate(formatSpecificDate(date2, EDateFormatPattern.yyyy_MM_dd), EDateFormatPattern.yyyy_MM_dd);
        if (date1 != null && date2 != null) {
            return (int) Math.ceil((double) Math.abs(date1.getTime() - date2.getTime()) / (1000 * 3600 * 24));
        } else {
            return 0;
        }
    }

    /**
     * 天数相差，包括当天(计算两个日期之间相差的天数 date2 > date1)
     * @param date1
     * @param date2
     * @return
     */
    public static int BetweenDayNoTimeHaveTodayNoabs(Date date1, Date date2)
    {
        date1 = getStrToDate(formatSpecificDate(date1, EDateFormatPattern.yyyy_MM_dd), EDateFormatPattern.yyyy_MM_dd);
        date2 = getStrToDate(formatSpecificDate(date2, EDateFormatPattern.yyyy_MM_dd), EDateFormatPattern.yyyy_MM_dd);
        if (date1 != null && date2 != null) {
            return (int) Math.ceil((double)(date1.getTime() - date2.getTime()) / (1000 * 3600 * 24));
        } else {
            return 0;
        }
    }

    /**
     * 计算两个日期之间相差的天数 date2 > date1
     * 
     * @param date1
     * @param date2
     * @return
     */
    public static int betweenDay(Date date1, Date date2)
    {
        return (int) Math.ceil((double) (date2.getTime() - date1.getTime()) / (1000 * 3600 * 24));
    }

    public static void main(String[] args)
    {
        Date date = new Date();
        System.out.println(formatGeneralDate(date, EDateFormatPattern.yyyyMMddHHmmss));
        Date date1 = rollDay(date, 1);
        System.out.println(formatGeneralDate(date1, EDateFormatPattern.yyyyMMddHHmmss));
        int num = compareWithNoTime(date1, date);
        System.out.println(num);
        System.out.println(Math.ceil(10.00));
    }
    /**
     * 计算两个日期之间相差的分
     * 
     * @param date1
     * @param date2
     * @return
     */
    public static long minutesBetween(Date date1, Date date2)
    {
        long timeGap = Math.abs(date1.getTime() - date2.getTime());
        return timeGap / 60000L;
    }
    
    
    /**
     * 日期加减操作
     * @param source 源日期
     * @param num 推迟月数 + 为往后 - 为往前
     * @return
     */
    public static String getDateByMonth(Date source, int num, int startIndex, int endIndex) {
        try {
            Calendar c = Calendar.getInstance();
            c.setTime(source);
            c.add(c.MONTH, num);
            if(startIndex ==-1 && endIndex == -1)
            {
            	 return DateUtils.formatGeneralDate(c.getTime(), EDateFormatPattern.yyyy_MM);
            }
            else
            {
            	 return DateUtils.formatGeneralDate(c.getTime(), EDateFormatPattern.yyyy_MM).substring(startIndex, endIndex);
            }
        } catch (Exception e) {
            return null;
        }
    }
    
	  /**
     * 日期加减操作
     * @param source 源日期
     * @param num 推迟天数 + 为往后 - 为往前
     * @return
     */
    public static String getDateRoler(Date source, int num) {
        try {
            Calendar c = Calendar.getInstance();
            c.setTime(source);
            c.add(Calendar.DAY_OF_MONTH, num);
            return DateUtils.formatGeneralDate(c.getTime(), EDateFormatPattern.yyyy_MM_dd);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * date1跟date2比较大小，不带时分秒进行比较
     * 
     * @param date1
     * @param date2
     * @return
     */
    public static int compareWithNoTime(Date date1, Date date2)
    {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);
        cal1.set(Calendar.HOUR_OF_DAY, 0);
        cal1.set(Calendar.MINUTE, 0);
        cal1.set(Calendar.SECOND, 0);
        cal1.set(Calendar.MILLISECOND, 0);
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        cal2.set(Calendar.HOUR_OF_DAY, 0);
        cal2.set(Calendar.MINUTE, 0);
        cal2.set(Calendar.SECOND, 0);
        cal2.set(Calendar.MILLISECOND, 0);
        return cal1.compareTo(cal2);
    }

    /**
     * 根据用户生日计算年龄
     */
    public static int getAgeByBirthday(Date birthday)
    {
        if (birthday == null)
        {
            return 0;
        }
        Calendar cal = Calendar.getInstance();

        if (cal.before(birthday))
        {
            throw new IllegalArgumentException("The birthDay is before Now.It's unbelievable!");
        }

        int yearNow = cal.get(Calendar.YEAR);
        int monthNow = cal.get(Calendar.MONTH) + 1;
        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);

        cal.setTime(birthday);
        int yearBirth = cal.get(Calendar.YEAR);
        int monthBirth = cal.get(Calendar.MONTH) + 1;
        int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);

        int age = yearNow - yearBirth;

        if (monthNow <= monthBirth)
        {
            if (monthNow == monthBirth)
            {
                if (dayOfMonthNow < dayOfMonthBirth)
                {
                    age--;
                }
            }
            else
            {
                age--;
            }
        }
        return age;
    }
    
    public static String secToTime(long second)
    {
        if(second <= 0) return "";
        long h = 0;
        long d = 0;
        long s = 0;
        long temp = second % 3600;
        if (second > 3600)
        {
            h = second / 3600;
            if (temp != 0)
            {
                if (temp > 60)
                {
                    d = temp / 60;
                    if (temp % 60 != 0)
                    {
                        s = temp % 60;
                    }
                }
                else
                {
                    s = temp;
                }
            }
        }
        else
        {
            d = second / 60;
            if (second % 60 != 0)
            {
                s = second % 60;
            }
        }
        return h + "小时" + d + "分" + s + "秒";
    }
    
    /**
     * 得到某年某周的第一天
     *
     * @param year
     * @param week
     * @return
     */
    public static Date getFirstDayOfWeek(int year, int week) {
        week = week - 1;
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, Calendar.JANUARY);
        calendar.set(Calendar.DATE, 1);

        Calendar cal = (Calendar) calendar.clone();
        cal.add(Calendar.DATE, week * 7);

        return getFirstDayOfWeek(cal.getTime());
    }

    /**
     * 得到某年某周的最后一天
     *
     * @param year
     * @param week
     * @return
     */
    public static Date getLastDayOfWeek(int year, int week) {
        week = week - 1;
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, Calendar.JANUARY);
        calendar.set(Calendar.DATE, 1);
        Calendar cal = (Calendar) calendar.clone();
        cal.add(Calendar.DATE, week * 7);

        return getLastDayOfWeek(cal.getTime());
    }
    
    /**
     * 取得当前日期所在周的第一天
     *
     * @param date
     * @return
     */
    public static Date getFirstDayOfWeek(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_WEEK,
                      calendar.getFirstDayOfWeek()); // Sunday
        return calendar.getTime();
    }

    /**
     * 取得当前日期所在周的最后一天
     *
     * @param date
     * @return
     */
    public static Date getLastDayOfWeek(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_WEEK,
                     calendar.getFirstDayOfWeek() + 6); // Saturday
        return calendar.getTime();
    }

    /**
     * 取得当前日期所在周的前一周最后一天
     *
     * @param date
     * @return
     */
    public static Date getLastDayOfLastWeek(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return getLastDayOfWeek(calendar.get(Calendar.YEAR),
                                calendar.get(Calendar.WEEK_OF_YEAR) - 1);
    }

    /**
     * 返回指定日期的月的第一天
     *
     * @param year
     * @param month
     * @return
     */
    public static Date getFirstDayOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(calendar.get(Calendar.YEAR),
                     calendar.get(Calendar.MONTH), 1);
        return calendar.getTime();
    }

    /**
     * 返回指定年月的月的第一天
     *
     * @param year
     * @param month
     * @return
     */
    public static Date getFirstDayOfMonth(Integer year, Integer month) {
        Calendar calendar = Calendar.getInstance();
        if (year == null) {
            year = calendar.get(Calendar.YEAR);
        }
        if (month == null) {
            month = calendar.get(Calendar.MONTH);
        }
        calendar.set(year, month, 1);
        return calendar.getTime();
    }

    /**
     * 返回指定日期的月的最后一天
     *
     * @param year
     * @param month
     * @return
     */
    public static Date getLastDayOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(calendar.get(Calendar.YEAR),
                     calendar.get(Calendar.MONTH), 1);
        calendar.roll(Calendar.DATE, -1);
        return calendar.getTime();
    }

    /**
     * 返回指定年月的月的最后一天
     *
     * @param year
     * @param month
     * @return
     */
    public static Date getLastDayOfMonth(Integer year, Integer month) {
        Calendar calendar = Calendar.getInstance();
        if (year == null) {
            year = calendar.get(Calendar.YEAR);
        }
        if (month == null) {
            month = calendar.get(Calendar.MONTH);
        }
        calendar.set(year, month, 1);
        calendar.roll(Calendar.DATE, -1);
        return calendar.getTime();
    }

    /**
     * 返回指定日期的上个月的最后一天
     *
     * @param year
     * @param month
     * @return
     */
    public static Date getLastDayOfLastMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(calendar.get(Calendar.YEAR),
                     calendar.get(Calendar.MONTH) - 1, 1);
        calendar.roll(Calendar.DATE, -1);
        return calendar.getTime();
    }

    /**
     * 返回指定日期的季的第一天
     *
     * @param year
     * @param quarter
     * @return
     */
    public static Date getFirstDayOfQuarter(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return getFirstDayOfQuarter(calendar.get(Calendar.YEAR),
                                    getQuarterOfYear(date));
    }

    /**
     * 返回指定年季的季的第一天
     *
     * @param year
     * @param quarter
     * @return
     */
    public static Date getFirstDayOfQuarter(Integer year, Integer quarter) {
        Calendar calendar = Calendar.getInstance();
        Integer month = new Integer(0);
        if (quarter == 1) {
            month = 1 - 1;
        } else if (quarter == 2) {
            month = 4 - 1;
        } else if (quarter == 3) {
            month = 7 - 1;
        } else if (quarter == 4) {
            month = 10 - 1;
        } else {
            month = calendar.get(Calendar.MONTH);
        }
        return getFirstDayOfMonth(year, month);
    }

    /**
     * 返回指定日期的季的最后一天
     *
     * @param year
     * @param quarter
     * @return
     */
    public static Date getLastDayOfQuarter(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return getLastDayOfQuarter(calendar.get(Calendar.YEAR),
                                   getQuarterOfYear(date));
    }

    /**
     * 返回指定年季的季的最后一天
     *
     * @param year
     * @param quarter
     * @return
     */
    public static Date getLastDayOfQuarter(Integer year, Integer quarter) {
        Calendar calendar = Calendar.getInstance();
        Integer month = new Integer(0);
        if (quarter == 1) {
            month = 3 - 1;
        } else if (quarter == 2) {
            month = 6 - 1;
        } else if (quarter == 3) {
            month = 9 - 1;
        } else if (quarter == 4) {
            month = 12 - 1;
        } else {
            month = calendar.get(Calendar.MONTH);
        }
        return getLastDayOfMonth(year, month);
    }

    /**
     * 返回指定日期的上一季的最后一天
     *
     * @param year
     * @param quarter
     * @return
     */
    public static Date getLastDayOfLastQuarter(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return getLastDayOfLastQuarter(calendar.get(Calendar.YEAR),
                                       getQuarterOfYear(date));
    }

    /**
     * 返回指定年季的上一季的最后一天
     *
     * @param year
     * @param quarter
     * @return
     */
    public static Date getLastDayOfLastQuarter(Integer year, Integer quarter) {
        Calendar calendar = Calendar.getInstance();
        Integer month = new Integer(0);
        if (quarter == 1) {
            month = 12 - 1;
        } else if (quarter == 2) {
            month = 3 - 1;
        } else if (quarter == 3) {
            month = 6 - 1;
        } else if (quarter == 4) {
            month = 9 - 1;
        } else {
            month = calendar.get(Calendar.MONTH);
        }
        return getLastDayOfMonth(year, month);
    }

    /**
     * 返回指定日期的季度
     *
     * @param date
     * @return
     */
    public static int getQuarterOfYear(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MONTH) / 3 + 1;
    }
    
    /**
     * 返回周几
     * @param dt
     * @return String
     * @since p2p_cloud_v1.6
     */
    public static String getWeekOfDate(Date dt) {
        String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0)
            w = 0;
        return weekDays[w];
    }
    
    public static int getWeekOfDay(Date dt) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);
        return cal.get(Calendar.DAY_OF_WEEK) - 1;
    }

    public static Date getDate(long time) {
        Date d = new Date();
        d.setTime(time);
        return d;
    }
}
