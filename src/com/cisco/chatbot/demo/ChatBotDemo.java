package com.cisco.chatbot.demo;


import java.text.MessageFormat;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.http.HttpRequest;


@Path("/chatbotqa")
public class ChatBotDemo {

	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response chatbot(final ChatBotVO vo,@Context HttpServletRequest request){
		
		return botProcess(vo,request);
	}
	
	public Response botProcess(ChatBotVO vo,HttpServletRequest request){
		
		String question = vo.question;
		String response = "\"status\" : {0},\n \"message\" : {1}";
		String response1 = "\"status\" : {0},\n \"answer\" : {1}";
		String entity ="";
		if("".equals(question)){
			return Response.status(200).type(MediaType.APPLICATION_JSON)
					.entity("{" + MessageFormat.format(response, "\"error\"", "\""+"question shoul not be empty"+"\"") + "}").build(); 
		}else{
			ChatBotDaoImpl imp = new ChatBotDaoImpl();
			 entity = imp.getBot(question);
		}
		return Response.status(200).entity("{\n"+MessageFormat.format(response,"\"success\"",entity)+"\n}").build();
	}
}
