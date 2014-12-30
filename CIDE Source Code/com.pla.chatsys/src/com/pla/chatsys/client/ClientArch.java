package com.pla.chatsys.client;


import com.pla.chatsys.IChat;
import com.pla.chatsys.IChatListener;
import com.pla.chatsys.IFileSentListener;
import com.pla.chatsys.IGame;
import com.pla.chatsys.IGameListener;
import com.pla.chatsys.IHistoryRetrive;
import com.pla.chatsys.IImageSent;
import com.pla.chatsys.IPrintEvent;
import com.pla.chatsys.ISendFileListener;
import com.pla.chatsys.ISendImage;
import com.pla.chatsys.ISendTemplet;
import com.pla.chatsys.ITTT;
import com.pla.chatsys.ITTTListener;
import com.pla.chatsys.ITempletRetriver;
import com.pla.chatsys.ITempletSend;
import com.pla.chatsys.IToolBar;
import com.pla.chatsys.IToolBarEvent;

import edu.uci.isr.myx.fw.AbstractMyxSimpleBrick;
import edu.uci.isr.myx.fw.IMyxName;
import edu.uci.isr.myx.fw.MyxUtils;

public class ClientArch extends AbstractMyxSimpleBrick implements IChatListener,IFileSentListener,IImageSent,ITTTListener,IGameListener,ITempletSend,IToolBarEvent
{
    public static final IMyxName msg_IChat = MyxUtils.createName("com.pla.chatsys.IChat");
    public static final IMyxName msg_IChatListener = MyxUtils.createName("com.pla.chatsys.IChatListener");
    public static final IMyxName msg_IPrintEvent = MyxUtils.createName("com.pla.chatsys.IPrintEvent");
    public static final IMyxName msg_IHistoryRetrive = MyxUtils.createName("com.pla.chatsys.IHistoryRetrive");
    public static final IMyxName msg_ISendFileListener = MyxUtils.createName("com.pla.chatsys.ISendFileListener");
    public static final IMyxName msg_IFileSentListener = MyxUtils.createName("com.pla.chatsys.IFileSentListener");
    public static final IMyxName msg_ISendImage = MyxUtils.createName("com.pla.chatsys.ISendImage");
    public static final IMyxName msg_IImageSent = MyxUtils.createName("com.pla.chatsys.IImageSent");
    public static final IMyxName msg_ITTT = MyxUtils.createName("com.pla.chatsys.ITTT");
    public static final IMyxName msg_ITTTListener = MyxUtils.createName("com.pla.chatsys.ITTTListener");
    public static final IMyxName msg_IGameListener = MyxUtils.createName("com.pla.chatsys.IGameListener");
    public static final IMyxName msg_IGame = MyxUtils.createName("com.pla.chatsys.IGame");
    public static final IMyxName msg_ISendTemplet = MyxUtils.createName("com.pla.chatsys.ISendTemplet");
    public static final IMyxName msg_ITempletSend = MyxUtils.createName("com.pla.chatsys.ITempletSend");
    public static final IMyxName msg_IToolBar = MyxUtils.createName("com.pla.chatsys.IToolBar");
    public static final IMyxName msg_IToolBarEvent = MyxUtils.createName("com.pla.chatsys.IToolBarEvent");
    public static final IMyxName msg_ITempletRetriver = MyxUtils.createName("com.pla.chatsys.ITempletRetriver");

    public IChat OUT_IChat;
    public IPrintEvent OUT_IPrintEvent;
    public IHistoryRetrive OUT_IHistoryRetrive;
    public ISendFileListener OUT_ISendFileListener;
    public ISendImage OUT_ISendImage;
    public ITTT OUT_ITTT;
    public IGame OUT_IGame;
    public ISendTemplet OUT_ISendTemplet;
    public IToolBar OUT_IToolBar;
    public ITempletRetriver OUT_ITempletRetriver;

	private IClientImp _imp;

    public ClientArch (){
		_imp = getImplementation();
		if (_imp != null){
			_imp.setArch(this);
		} else {
			System.exit(1);
		}
	}
    
    protected IClientImp getImplementation(){
        try{
			return new ClientImp();    
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
        OUT_IPrintEvent = (IPrintEvent) MyxUtils.getFirstRequiredServiceObject(this,msg_IPrintEvent);
        if (OUT_IPrintEvent == null){
 			System.err.println("Error: Interface com.pla.chatsys.IPrintEvent returned null");
			return;       
        }
        OUT_IHistoryRetrive = (IHistoryRetrive) MyxUtils.getFirstRequiredServiceObject(this,msg_IHistoryRetrive);
        if (OUT_IHistoryRetrive == null){
 			System.err.println("Error: Interface com.pla.chatsys.IHistoryRetrive returned null");
			return;       
        }
        OUT_ISendFileListener = (ISendFileListener) MyxUtils.getFirstRequiredServiceObject(this,msg_ISendFileListener);
        if (OUT_ISendFileListener == null){
 			System.err.println("Error: Interface com.pla.chatsys.ISendFileListener returned null");
			return;       
        }
        OUT_ISendImage = (ISendImage) MyxUtils.getFirstRequiredServiceObject(this,msg_ISendImage);
        if (OUT_ISendImage == null){
 			System.err.println("Error: Interface com.pla.chatsys.ISendImage returned null");
			return;       
        }
        OUT_ITTT = (ITTT) MyxUtils.getFirstRequiredServiceObject(this,msg_ITTT);
        if (OUT_ITTT == null){
 			System.err.println("Error: Interface com.pla.chatsys.ITTT returned null");
			return;       
        }
        OUT_IGame = (IGame) MyxUtils.getFirstRequiredServiceObject(this,msg_IGame);
        if (OUT_IGame == null){
 			System.err.println("Error: Interface com.pla.chatsys.IGame returned null");
			return;       
        }
        OUT_ISendTemplet = (ISendTemplet) MyxUtils.getFirstRequiredServiceObject(this,msg_ISendTemplet);
        if (OUT_ISendTemplet == null){
 			System.err.println("Error: Interface com.pla.chatsys.ISendTemplet returned null");
			return;       
        }
        OUT_IToolBar = (IToolBar) MyxUtils.getFirstRequiredServiceObject(this,msg_IToolBar);
        if (OUT_IToolBar == null){
 			System.err.println("Error: Interface com.pla.chatsys.IToolBar returned null");
			return;       
        }
        OUT_ITempletRetriver = (ITempletRetriver) MyxUtils.getFirstRequiredServiceObject(this,msg_ITempletRetriver);
        if (OUT_ITempletRetriver == null){
 			System.err.println("Error: Interface com.pla.chatsys.ITempletRetriver returned null");
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
		if (arg0.equals(msg_IFileSentListener)){
			return this;
		}        
		if (arg0.equals(msg_IImageSent)){
			return this;
		}        
		if (arg0.equals(msg_ITTTListener)){
			return this;
		}        
		if (arg0.equals(msg_IGameListener)){
			return this;
		}        
		if (arg0.equals(msg_ITempletSend)){
			return this;
		}        
		if (arg0.equals(msg_IToolBarEvent)){
			return this;
		}        
		return null;
	}
  
    
    public void messageSent (String sender,String message)   {
		_imp.messageSent(sender,message);
    }    
  
    
    public void fileSent (String sender,String fileName,byte[] fileData)   {
		_imp.fileSent(sender,fileName,fileData);
    }    
  
    
    public void imageSent (String sender,String imageName,byte[] imageData)   {
		_imp.imageSent(sender,imageName,imageData);
    }    
  
    
    public void myMove (int position)   {
		_imp.myMove(position);
    }    
    public void quit ()   {
		_imp.quit();
    }    
  
    
    public void gameStarted ()   {
		_imp.gameStarted();
    }    
    public void gameEnded ()   {
		_imp.gameEnded();
    }    
    public void played (String sender,int position)   {
		_imp.played(sender,position);
    }    
  
    
    public void sendTemplet (String sender,String code)   {
		_imp.sendTemplet(sender,code);
    }    
  
    
    public void onColorReceived (int color)   {
		_imp.onColorReceived(color);
    }    
    public void onLocationReceived (double lat,double lon)   {
		_imp.onLocationReceived(lat,lon);
    }    
}