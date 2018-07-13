package zm.village.util.tools;

import java.sql.Timestamp;
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
		Timestamp dateStamp = new Timestamp(date.getTime());
		return dateStamp;
	}
	
	public static Timestamp getAfterTime(Integer day)
	{
		Date date = new Date();       
		Timestamp dateStamp = new Timestamp(date.getTime() + day * 1000 * 60 * 60 * 24);
		return dateStamp;
	}
	
	private SystemTimeUtil() {
	}
}
