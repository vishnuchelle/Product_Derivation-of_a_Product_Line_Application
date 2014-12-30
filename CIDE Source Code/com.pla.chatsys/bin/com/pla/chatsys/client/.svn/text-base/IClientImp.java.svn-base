package com.pla.chatsys.client;


import com.pla.chatsys.client.ClientArch;

public interface IClientImp 
{

	/*
	  Getter and Setter of architecture reference
	*/
    public void setArch (ClientArch arch);
	public ClientArch getArch();
	
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
  
    
    public void messageSent (String sender,String message)  ;        
  
    
    public void fileSent (String sender,String fileName,byte[] fileData)  ;        
  
    
    public void imageSent (String sender,String imageName,byte[] imageData)  ;        
  
    
    public void myMove (int position)  ;        
    public void quit ()  ;        
  
    
    public void gameStarted ()  ;        
    public void gameEnded ()  ;        
    public void played (String sender,int position)  ;        
  
    
    public void sendTemplet (String sender,String code)  ;        
  
    
    public void onColorReceived (int color)  ;        
    public void onLocationReceived (double lat,double lon)  ;        
}