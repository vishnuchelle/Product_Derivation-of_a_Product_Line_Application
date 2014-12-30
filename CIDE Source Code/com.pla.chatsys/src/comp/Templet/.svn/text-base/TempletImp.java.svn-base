package comp.Templet;



public class TempletImp implements ITempletImp
{
	private TempletArch _arch;

	
    public TempletImp (){
    }

	public void setArch(TempletArch arch){
		_arch = arch;
	}
	public TempletArch getArch(){
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

	/*
  	  Implementation primitives required by the architecture
	*/
  
    
    public String[] getTemplet (String code)   {
		String[] result = {"",""};
    	if(code.equals("Hi")){
    		
    		result[0] = "text";
    		result[1] = "Hi How are you?";
    	}else if(code.equals(":)")){
    		result[0] = "image";
    		result[1] = "smile.png";
    	}else if(code.equals("buzz")){
    		result[0] = "multimedia";
    		result[1] = "buzz";
    		
    	}else {
    		
    		result[0] = "text";
    		result[1] = code;
    	}
		return result;
    }
}