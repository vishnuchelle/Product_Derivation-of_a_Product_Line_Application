package comp.TTTGame;


import comp.TTTGame.TTTGameArch;

public interface ITTTGameImp 
{

	/*
	  Getter and Setter of architecture reference
	*/
    public void setArch (TTTGameArch arch);
	public TTTGameArch getArch();
	
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
  
    
    public void startTTT (int x,int y)  ;        
    public void endTTT ()  ;        
    public void opponentMove (int position)  ;        
}