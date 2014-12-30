package comp.Bot;


import com.pla.chatsys.IChat;
import com.pla.chatsys.IChatListener;

import edu.uci.isr.myx.fw.AbstractMyxSimpleBrick;
import edu.uci.isr.myx.fw.IMyxName;
import edu.uci.isr.myx.fw.MyxUtils;

public class BotArch extends AbstractMyxSimpleBrick implements IChatListener
{
    public static final IMyxName msg_IChatListener = MyxUtils.createName("com.pla.chatsys.IChatListener");
    public static final IMyxName msg_IChat = MyxUtils.createName("com.pla.chatsys.IChat");

    public IChat OUT_IChat;

	private IBotImp _imp;

    public BotArch (){
		_imp = getImplementation();
		if (_imp != null){
			_imp.setArch(this);
		} else {
			System.exit(1);
		}
	}
    
    protected IBotImp getImplementation(){
        try{
			return new BotImp();    
        } catch (Exception e){
            System.err.println(e.getMessage());
            return null;
        }
    }

    public void init(){
        _imp.init();
    }
    
    public void begin(){
        OUT_IChat = (IChat) MyxUtils.getFirstRequiredServiceObject(this,msg_IChat);
        if (OUT_IChat == null){
 			System.err.println("Error: Interface com.pla.chatsys.IChat returned null");
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
		if (arg0.equals(msg_IChatListener)){
			return this;
		}        
		return null;
	}
  
    
    public void messageSent (String sender,String message)   {
		_imp.messageSent(sender,message);
    }    
}