package org.silkroad.processing.logs;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.silkroad.utility.MongoConn;
import org.silkroad.utility.ReadFile;

import com.mongodb.client.MongoCollection;

import net.sf.json.JSONArray;

/**
* @author : wuke
* @date   : 2017��4��21������10:24:46
* Title   : ProcessLogs
* Description : 
*/
public class ProcessLogs {
	private static final String PATH = "E:\\data\\silkroad_logs.txt"; // the catalog where logs are stored

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		
		List<Document> logsDocs = ProcessLogs.readLogs(PATH);
		
		long end1 = System.currentTimeMillis();
		System.out.println("Cost " + (end1 - start)/1000 + " seconds"); // Cost 816 seconds
		
		ProcessLogs.storeLogs(logsDocs);
		
		long end2 = System.currentTimeMillis();
		System.out.println("Cost " + (end2 - end1)/1000 + " seconds"); // Cost 4 seconds
	}
	
	public static void initProcessLogs(String path) {
		List<Document> logsDocs = ProcessLogs.readLogs(path);
		ProcessLogs.storeLogs(logsDocs);
	}
	
	/**
	 * 
	 * @return logsDocs ArrayList<Document>
	 */
	private static List<Document> readLogs(String path) {
		String jsonContext = ReadFile.readFile(path);
		
		JSONArray jsonArr = JSONArray.fromObject(jsonContext);
		
		List<Document> logsDocs = new ArrayList<Document>();
		Document doc = new Document();
		for(int i = 0; i < jsonArr.size(); i++) {
			doc = Document.parse(jsonArr.getJSONObject(i).toString());
			logsDocs.add(doc);
		}
		
		return logsDocs;
	}
	
	/**
	 * Store logs Documents
	 * @param documents
	 */
	static void storeLogs(List<Document> documents) {
		MongoCollection<Document> logsCollection = MongoConn.getMongoCollection("silkRoad", "logs");
		
		logsCollection.drop(); // delete the old data
		logsCollection = MongoConn.getMongoCollection("silkRoad", "logs");
		
		logsCollection.insertMany(documents);
	}
}
