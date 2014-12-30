package com.pla.chatsys.client;


import com.pla.chatsys.IPrintEvent;

import edu.uci.isr.myx.fw.AbstractMyxSimpleBrick;
import edu.uci.isr.myx.fw.IMyxName;
import edu.uci.isr.myx.fw.MyxUtils;

public class PrinterArch extends AbstractMyxSimpleBrick implements IPrintEvent
{
    public static final IMyxName msg_IPrintEvent = MyxUtils.createName("com.pla.chatsys.IPrintEvent");


	private IPrintCompImp _imp;

    public PrinterArch (){
		_imp = getImplementation();
		if (_imp != null){
			_imp.setArch(this);
		} else {
			System.exit(1);
		}
	}
    
    protected IPrintCompImp getImplementation(){
        try{
			return new PrinterImp();    
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
		if (arg0.equals(msg_IPrintEvent)){
			return this;
		}        
		return null;
	}
  
    
    public void print (String msg)   {
		_imp.print(msg);
    }    
}