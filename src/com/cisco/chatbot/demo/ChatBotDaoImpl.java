package com.cisco.chatbot.demo;

import java.util.LinkedHashMap;
import java.util.Map;

public class ChatBotDaoImpl {

public static final String q1 ="Is there a limit on the number of times I can set a Review date before I am required to set an Event date";
public static final String q2 ="Can I set a Review date in the past";
public static final String q3 ="Can I set an Event date in the past";
public static final String q4 ="Who can set Review or Event dates";
public static final String q5 ="What if the owner has left Cisco";
public static final String q6 ="Where can I ask more questions about Event-based retention and my documents in Cisco Docs";
public static final String a1 ="Yes. A user can enter a Review date 5 times before an event date is required.";
public static final String a2 ="No. The system will not allow the Review date to be set in the past.";
public static final String a3 ="Yes. The system will allow the Event date to be set in the past.";
public static final String a4 ="Anyone that has write access to a document can set Review or Event Dates.";
public static final String a5 ="If the owner has left Cisco, the system will send reminder emails to set the Event date to the coordinator of the parent folder.";
public static final String a6 ="You can ask questions in the Cisco Docs Discussion Forum for Record Retention Management";
public static Map<String,String> qaMap = new LinkedHashMap<String,String>();
static {
		
		
		 qaMap.put(q1,a1);
		 qaMap.put(q2,a2);
		 qaMap.put(q3,a3);
		 qaMap.put(q4,a4);
		 qaMap.put(q5,a5);
		 qaMap.put(q6,a6);
	}


public String getBot(String question){
	
	return qaMap.get(question.replaceAll("\\?", "").trim());
}

}
