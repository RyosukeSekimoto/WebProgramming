package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateExecute {

	/**
	 * detetime型で現在時刻を返す
	 * @return	datetime型の現在時刻
	 */
	public static String dateTime() {

		Date d = new Date();

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
		String dateTime = df.format(d);

		return dateTime;
	}

	/**
	 * date型の日付を"yyyy年MM月dd日"形式に変換して返す
	 * @param time	変換する日付
	 * @return		"yyyy年MM月dd日"表示の日付
	 */
	public static String DateFormat (String time) {

		try {
            SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = sdFormat.parse(time);

            SimpleDateFormat sdFormat2 = new SimpleDateFormat("yyyy年MM月dd日");
    		String displayDate = sdFormat2.format(date);
    		return displayDate;

        } catch (ParseException e) {
            e.printStackTrace();
        }

		return null;
	}

	/**
	 * datetime型の日付を"yyyy年MM月dd日 kk:mm"形式に変換して返す
	 * @param 	time
	 * @return	"yyyy年MM月dd日 hh:mm"表示の日時
	 */
	public static String DateTimeFormat (String time) {

		try {
            SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
            Date date = sdFormat.parse(time);

            SimpleDateFormat sdFormat2 = new SimpleDateFormat("yyyy年MM月dd日 kk:mm");
    		String displayDateTime = sdFormat2.format(date);
    		return displayDateTime;

        } catch (ParseException e) {
            e.printStackTrace();
        }

		return null;
	}
}
