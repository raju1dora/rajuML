package com.cisco.chatbot.demo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ChatBotVO {

	@XmlElement
	public String question;
}
