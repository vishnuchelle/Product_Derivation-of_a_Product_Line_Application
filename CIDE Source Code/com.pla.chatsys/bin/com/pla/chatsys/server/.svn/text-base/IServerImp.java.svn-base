package com.pla.chatsys.server;


import com.pla.chatsys.server.ServerArch;

public interface IServerImp 
{

	/*
	  Getter and Setter of architecture reference
	*/
    public void setArch (ServerArch arch);
	public ServerArch getArch();
	
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
  
    
    public void sendMessage (String sender,String message)  ;        
  
    
    public String retriveChatHistory (String sender)  ;        
  
    
    public void sendFile (String sender,String path,byte[] fileData)  ;        
  
    
    public void sendImage (String sender,String path,byte[] data)  ;        
  
    
    public void startGame ()  ;        
    public void endGame ()  ;        
    public void play (String sender,int position)  ;        
  
    
    public void sendTemplet (String sender,String msgCode)  ;        
  
    
    public void sendIncognitoMessage (String sender,String msg)  ;        
    public void sendColor (String sender,int color)  ;        
    public void sendLocation (double lat,double lon)  ;        
}