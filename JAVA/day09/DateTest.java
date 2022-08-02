package chap10;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTest {

	public static void main(String[] args) {
		long mill = System.currentTimeMillis(); //현재시각 1/1000초
		
		Date now = new Date(); // 현재시각 년......
		Date now2 = new Date(mill);
		System.out.println(mill);
		System.out.println(now);
		System.out.println(now2);
		
		Calendar cal = Calendar.getInstance();
		System.out.println(cal);
		now.getYear();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH)+1;
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		
		System.out.print("현재시각은 : "+year+"년도 "+month+ " 월 "+day+" 일 ");
		System.out.println(hour + " 시 "+minute+" 분 "+second+ " 초 "+"입니다. ");
		
		if(cal.get(Calendar.DAY_OF_WEEK) ==2) {
			System.out.println("월요일 - MONDAY");
		}
		//System.out.println(cal.get(Calendar.DAY_OF_WEEK));
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String result = sdf.format(now2); // now2 = cal.getTime()
		System.out.println(result);
	}

}
