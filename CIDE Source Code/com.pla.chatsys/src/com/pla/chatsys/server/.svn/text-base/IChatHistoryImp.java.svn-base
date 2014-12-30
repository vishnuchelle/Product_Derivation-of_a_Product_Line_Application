package com.pla.chatsys.server;


import com.pla.chatsys.server.ChatHistoryArch;

public interface IChatHistoryImp 
{

	/*
	  Getter and Setter of architecture reference
	*/
    public void setArch (ChatHistoryArch arch);
	public ChatHistoryArch getArch();
	
	/*
  	  Myx Lifecycle Methods: these methods are called automatically by the framework
  	  as the bricks are created, attached, detached, and destroyed respectively.
	*/	
	public void init();	
	public void begin();
	public void end();
	public void destroy();

	/*
  	  Implementation primitives required by the architecture
	*/
  
    
    public boolean writeMsg (String sender,String message)  ;        
}