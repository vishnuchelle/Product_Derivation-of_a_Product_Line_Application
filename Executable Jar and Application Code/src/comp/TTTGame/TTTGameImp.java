package comp.TTTGame;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;



public class TTTGameImp implements ITTTGameImp
{
	private TTTGameArch _arch;
	private TicTacToe ttt;

    public TTTGameImp (){
    }

	public void setArch(TTTGameArch arch){
		_arch = arch;
	}
	public TTTGameArch getArch(){
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

	public void startTTT (int x, int y)   {
		//TODO Auto-generated method stub
    	
		ttt = new TicTacToe(x, y);
		ttt.addCallBackListner(new ICallBackListner(){

			@Override
			public void buttonClicked(int position) {
				// TODO Auto-generated method stub
				_arch.OUT_ITTTListener.myMove(position);
			}
		});
		ttt.addWindowHandler(new WindowAdapter(){
			  public void windowClosing(WindowEvent evt) {
				    _arch.OUT_ITTTListener.quit();
				  }
		});
		ttt.startGame();
    }
    
    public void endTTT(){
    	ttt.endGame();
    }
    
    public void opponentMove (int position)   {
		//TODO Auto-generated method stub
		if (ttt !=null){
			ttt.isMyTurn = false;
			ttt.buttonClick(position);
		}
    }
	/*
  	  Implementation primitives required by the architecture
	*/
	
	
}