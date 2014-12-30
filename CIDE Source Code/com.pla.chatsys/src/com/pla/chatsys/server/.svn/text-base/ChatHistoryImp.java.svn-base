package com.pla.chatsys.server;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;



public class ChatHistoryImp implements IChatHistoryImp
{
	private ChatHistoryArch _arch;

    public ChatHistoryImp (){
    }

	public void setArch(ChatHistoryArch arch){
		_arch = arch;
	}
	public ChatHistoryArch getArch(){
		return _arch;
	}

	/*
  	  Myx Lifecycle Methods: these methods are called automatically by the framework
  	  as the bricks are created, attached, detached, and destroyed respectively.
	*/	
	public void init(){
	    //TODO Auto-generated method stub
	}
	public void begin(){
		//TODO Auto-generated method stub
	}
	public void end(){
		//TODO Auto-generated method stub
	}
	public void destroy(){
		//TODO Auto-generated method stub
	}

	/*
  	  Implementation primitives required by the architecture
	*/
  
    
    public boolean writeMsg (String sender,String message)   {
		
    	DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Calendar cal = Calendar.getInstance();
    	String date = " Sent on-" + dateFormat.format(cal.getTime());
		String text = message;
		String Msg = sender + ": " + text + date;	
		
		

		BufferedWriter writer = null;
		boolean status = false;
	    try {
	    	FileWriter fr = new FileWriter("./ChatHistory.txt",true);
	    	writer = new BufferedWriter(fr);
	    	//writer.newLine();
	    	//Msg = Msg + "<br>";
	    	
	    	//byte[] byt =Encryptor.encrypt(Msg.getBytes());
	    	//byte[] byt = base.encode(Msg.getBytes());
	    	//writer.append(new String(byt));
	    	writer.append(Msg);
	    	writer.append("<br>");
	    	writer.newLine();
	    	status = true;
	    } 
		catch (IOException e) {
	        System.err.println(e);
	        status = false;
	    } finally 
		{
	        if (writer != null) {
	            try {
	                writer.close();
	            } catch (IOException e) {
	                System.err.println(e);
	            }
	        }
		}
		return status;
	
		
    }
}