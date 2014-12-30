package com.pla.chatsys.client;


import com.pla.chatsys.client.PrinterArch;

public interface IPrintCompImp 
{

	/*
	  Getter and Setter of architecture reference
	*/
    public void setArch (PrinterArch arch);
	public PrinterArch getArch();
	
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
  
    
    public void print (String msg)  ;        
}