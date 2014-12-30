package comp.Templet;


import com.pla.chatsys.ITempletRetriver;

import edu.uci.isr.myx.fw.AbstractMyxSimpleBrick;
import edu.uci.isr.myx.fw.IMyxName;
import edu.uci.isr.myx.fw.MyxUtils;

public class TempletArch extends AbstractMyxSimpleBrick implements ITempletRetriver
{
    public static final IMyxName msg_ITempletRetriver = MyxUtils.createName("com.pla.chatsys.ITempletRetriver");


	private ITempletImp _imp;

    public TempletArch (){
		_imp = getImplementation();
		if (_imp != null){
			_imp.setArch(this);
		} else {
			System.exit(1);
		}
	}
    
    protected ITempletImp getImplementation(){
        try{
			return new TempletImp();    
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
		if (arg0.equals(msg_ITempletRetriver)){
			return this;
		}        
		return null;
	}
  
    
    public String[] getTemplet (String code)   {
		return _imp.getTemplet(code);
    }    
}