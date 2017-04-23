package org.silkroad.abandon;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class GetYesterdayDate {

	public static void main(String[] args) {
		System.out.println(getYesterDayDate()); 
	}

	public static String getYesterDayDate() {
		String yesterdayStr = "";
		
		Date dateNow = new Date();
		Date dateYester = new Date();
		
		Calendar calendar = Calendar.getInstance(); // �õ�����
		calendar.setTime(dateNow);                  // �ѵ�ǰʱ�丳������
		calendar.add(Calendar.DAY_OF_MONTH, -1);    // ����Ϊǰһ��
		dateYester = calendar.getTime();            //�õ�ǰһ���ʱ��
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd"); //����ʱ���ʽ
		yesterdayStr = sdf.format(dateYester);    //��ʽ��ǰһ��
		
		return yesterdayStr;
	}
}
