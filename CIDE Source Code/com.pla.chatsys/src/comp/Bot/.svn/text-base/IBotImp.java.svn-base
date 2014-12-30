package comp.Bot;


import comp.Bot.BotArch;

public interface IBotImp 
{

	/*
	  Getter and Setter of architecture reference
	*/
    public void setArch (BotArch arch);
	public BotArch getArch();
	
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
}