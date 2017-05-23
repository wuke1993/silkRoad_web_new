package org.silkroad.controller;

import org.silkroad.history.CalUserViewTimes;
import org.silkroad.history.CompleteUserViewedResInfo;
import org.silkroad.history.GenUserViewedRes;
import org.silkroad.hot.CalHotResources;
import org.silkroad.hot.CompleteHotResInfo;
import org.silkroad.processing.logs.ClassifyLogsByRole;
import org.silkroad.processing.logs.ProcessLogs;
import org.silkroad.utility.GetProperty;

/**
* @author : wuke
* @date   : 20170427 16:45:16
* Title   : InitializeSilkRoad
* Description : 
*/
public class InitializeSilkRoad {	
	public static void main(String[] args) {
		InitializeSilkRoad.initSilkRoad();
	}
	
    public static void initSilkRoad() {
    	String logs_path = GetProperty.getPropertyByName("logs_path");
    	
		long start = System.currentTimeMillis();
    	
		ProcessLogs.initProcessLogs(logs_path);
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
