package comp.TTTGame;


import com.pla.chatsys.ITTT;
import com.pla.chatsys.ITTTListener;

import edu.uci.isr.myx.fw.AbstractMyxSimpleBrick;
import edu.uci.isr.myx.fw.IMyxName;
import edu.uci.isr.myx.fw.MyxUtils;

public class TTTGameArch extends AbstractMyxSimpleBrick implements ITTT
{
    public static final IMyxName msg_ITTT = MyxUtils.createName("com.pla.chatsys.ITTT");
    public static final IMyxName msg_ITTTListener = MyxUtils.createName("com.pla.chatsys.ITTTListener");

    public ITTTListener OUT_ITTTListener;

	private ITTTGameImp _imp;

    public TTTGameArch (){
		_imp = getImplementation();
		if (_imp != null){
			_imp.setArch(this);
		} else {
			System.exit(1);
		}
	}
    
    protected ITTTGameImp getImplementation(){
        try{
			return new TTTGameImp();    
        } catch (Exception e){
            System.err.println(e.getMessage());
            return null;
        }
    }

    public void init(){
        _imp.init();
    }
    
    public void begin(){
        OUT_ITTTListener = (ITTTListener) MyxUtils.getFirstRequiredServiceObject(this,msg_ITTTListener);
        if (OUT_ITTTListener == null){
 			System.err.println("Error: Interface com.pla.chatsys.ITTTListener returned null");
			return;       
        }
        _imp.begin();
    }
    
    public void end(){
        _imp.end();
    }
    
    public void destroy(){
        _imp.destroy();
    }
    
	public Object getServiceObject(IMyxName arg0) {
		if (arg0.equals(msg_ITTT)){
			return this;
		}        
		return null;
	}
  
    
    public void startTTT (int x,int y)   {
		_imp.startTTT(x,y);
    }    
    public void endTTT ()   {
		_imp.endTTT();
    }    
    public void opponentMove (int position)   {
		_imp.opponentMove(position);
    }    
}