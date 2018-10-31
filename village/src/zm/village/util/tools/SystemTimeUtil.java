package zm.village.util.tools;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
* @author 李子帆
* @version 1.0
* @date 2018年7月13日 下午4:23:54
* @Description 获取系统时间工具类
*/
public final class SystemTimeUtil {

	public static Timestamp getTime() {
		Date date = new Date();
		return new Timestamp(date.getTime());
	}
	
	public static Timestamp getAfterTime(Integer day) {
		Date date = new Date();       
		return new Timestamp(date.getTime() + day * 1000 * 60 * 60 * 24);
	}
	
	private static final SimpleDateFormat ymdFormat = new SimpleDateFormat("yyyy-mm-dd");
	
	/**
	 * 获取时间格式为YYYY-MM-DD的Timestamp
	 * @param time 满足格式的时间字符串
	 * @return 转换后的Timestamp对象
	 * @throws ParseException 时间格式有误
	 */
	public static Timestamp getYMDTime(String time) throws ParseException {
		Date date = ymdFormat.parse(time);
		return new Timestamp(date.getTime());
	}
	
	private SystemTimeUtil() {
		throw new UnsupportedOperationException();
	}
}
