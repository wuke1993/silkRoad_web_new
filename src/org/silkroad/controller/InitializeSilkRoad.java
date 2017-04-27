package org.silkroad.controller;

import org.silkroad.history.CalUserViewTimes;
import org.silkroad.history.CompleteUserViewedResInfo;
import org.silkroad.history.GenUserViewedRes;
import org.silkroad.hot.CalHotResources;
import org.silkroad.hot.CompleteHotResInfo;
import org.silkroad.processing.logs.ClassifyLogsByRole;
import org.silkroad.processing.logs.ProcessLogs;

/**
* @author : wuke
* @date   : 2017��4��27������4:45:16
* Title   : InitializeSilkRoad
* Description : 
*/
public class InitializeSilkRoad {
	private static final String PATH = "E:\\data\\silkroad_logs.txt"; // the catalog where logs are stored
	
	public static void main(String[] args) {
		InitializeSilkRoad.initSilkRoad();
	}
	
    public static void initSilkRoad() {
		long start = System.currentTimeMillis();
    	
		ProcessLogs.initProcessLogs(PATH);
		ClassifyLogsByRole.classifyLogsByRole();
		System.out.println("******************** ��־����ɹ���********************");
		long tag1 = System.currentTimeMillis();
		System.out.println("���� " + (tag1 - start)/1000 + " ��");
		
		GenUserViewedRes.readLogs();
		System.out.println("******************** �û������ʷ���ɳɹ���********************");
		long tag2 = System.currentTimeMillis();
		System.out.println("���� " + (tag2 - tag1)/1000 + " ��");
		
		CalUserViewTimes.calAllUsersViewedTimes();
		CalHotResources.calAllRolesHotRes();
		System.out.println("******************** �û�����������ȶ���Դ����ɹ���********************");
		long tag3 = System.currentTimeMillis();
		System.out.println("���� " + (tag3 - tag2)/1000 + " ��");
		
		CompleteUserViewedResInfo.completeAllKindsResInfo();
		CompleteHotResInfo.completeAllHotResInfo();
		System.out.println("******************** �����ʷ��Դ���ȶ���Դ��Ϣ��ȫ�ɹ���********************");
		long tag4 = System.currentTimeMillis();
		System.out.println("���� " + (tag4 - tag3)/1000 + " ��");
		
		System.out.println("�ܹ����� " + (tag4 - start)/1000 + " ��");
	}
}
