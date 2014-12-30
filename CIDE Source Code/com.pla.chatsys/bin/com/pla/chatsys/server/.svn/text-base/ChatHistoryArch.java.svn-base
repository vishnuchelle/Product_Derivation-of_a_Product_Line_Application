package com.pla.chatsys.server;


import com.pla.chatsys.IFileWriter;

import edu.uci.isr.myx.fw.AbstractMyxSimpleBrick;
import edu.uci.isr.myx.fw.IMyxName;
import edu.uci.isr.myx.fw.MyxUtils;

public class ChatHistoryArch extends AbstractMyxSimpleBrick implements IFileWriter
{
    public static final IMyxName msg_IFileWriter = MyxUtils.createName("com.pla.chatsys.IFileWriter");


	private IChatHistoryImp _imp;

    public ChatHistoryArch (){
		_imp = getImplementation();
		if (_imp != null){
			_imp.setArch(this);
		} else {
			System.exit(1);
		}
	}
    
    protected IChatHistoryImp getImplementation(){
        try{
			return new ChatHistoryImp();    
        } catch (Exception e){
            System.err.println(e.getMessage());
            return null;
        }
    }

    public void init(){
        _imp.init();
    }
    
    public void begin(){
        _imp.begin();
    }
    
    public void end(){
        _imp.end();
    }
    
    public void destroy(){
        _imp.destroy();
    }
    
	public Object getServiceObject(IMyxName arg0) {
		if (arg0.equals(msg_IFileWriter)){
			return this;
		}        
		return null;
	}
  
    
    public boolean writeMsg (String sender,String message)   {
		return _imp.writeMsg(sender,message);
    }    
}