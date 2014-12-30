package com.pla.chatsys.server;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;



public class ServerImp implements IServerImp
{
	private ServerArch _arch;

    public ServerImp (){
    }

	public void setArch(ServerArch arch){
		_arch = arch;
	}
	public ServerArch getArch(){
		return _arch;
	}

	/*
  	  Myx Lifecycle Methods: these methods are called automatically by the framework
  	  as the bricks are created, attached, detached, and destroyed respectively.
	*/	
	public void init(){
	    
	}
	public void begin(){
		
	}
	public void end(){
		
	}
	public void destroy(){
		
	}

	/*
  	  Implementation primitives required by the architecture
	*/
  

	public void sendMessage (String sender,String message) {
		
		if (_arch.OUT_IChatListener != null){
			_arch.OUT_IChatListener.messageSent(sender, message);
			_arch.OUT_IFileWriter.writeMsg(sender,message);
		}
	}

	@Override
	public String retriveChatHistory(String sender) {
    	String sCurrentLine = null;
    	String Allfile = null;
    	BufferedReader br = null;
		try {
			File file = new File("./ChatHistory.txt");
			if(!file.exists()){
				file.createNewFile();
			}
			 
			br = new BufferedReader(new FileReader("./ChatHistory.txt"));
					while((sCurrentLine = br.readLine()) != null)
					{
						if (Allfile == null)
						{
							
							//byte[] byt =Encryptor.decrypt(sCurrentLine.getBytes());
							//sCurrentLine = new String(Encryptor.decrypt(sCurrentLine.getBytes()));
							Allfile = sCurrentLine;
						}
						else
						{
						//	sCurrentLine = new String(Encryptor.decrypt(sCurrentLine.getBytes()));
						Allfile = Allfile +"\n" +sCurrentLine;
						}
						
					}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return Allfile;
    }

	@Override
	public void sendFile(String sender, String path, byte[] fileData) {
		if(_arch.OUT_IFileSentListener!=null){
		_arch.OUT_IFileSentListener.fileSent(sender, path, fileData);
		}
	}

	@Override
	public void sendImage(String sender, String name, byte[] data) {
		
		if(_arch.OUT_IImageSent !=null){
			_arch.OUT_IImageSent.imageSent(sender, name, data);
		}
		
	}

	@Override
	public void startGame() {
		if (_arch.OUT_IGameListener != null){
			_arch.OUT_IGameListener.gameStarted();
		}
		
	}

	@Override
	public void endGame() {
		if (_arch.OUT_IGameListener != null){
			_arch.OUT_IGameListener.gameEnded();
		}
		
	}

	@Override
	public void play(String sender, int position) {
		if (_arch.OUT_IGameListener != null){
			_arch.OUT_IGameListener.played(sender, position);
		}
		
	}

	@Override
	public void sendTemplet(String sender, String msgCode) {
		
		
		_arch.OUT_ITempletSend.sendTemplet(sender, msgCode);
		/*String[] result = _arch.OUT_ITempletRetriver.getTemplet(msgCode);
		if(result!=null){
			
			if(result[0].equals("text")){
				
				_arch.OUT_ITempletSend.sendTextTemplet(sender, result[1]);
			}else if(result[0].equals("image")){
				_arch.OUT_ITempletSend.sendImageTemplet(sender, result[1]);
			}else if(result[0].equals("multimedia")){
				_arch.OUT_ITempletSend.sendMultimediaTemplet(sender, result[1]);
			}
		}*/
	}

	@Override
	public void sendIncognitoMessage(String sender, String msg) {
		if (_arch.OUT_IChatListener != null){
			_arch.OUT_IChatListener.messageSent(sender, msg);
			
		}
		
	}

	@Override
	public void sendColor(String sender, int color) {
		if (_arch.OUT_IToolBarEvent != null){
			_arch.OUT_IToolBarEvent.onColorReceived(color);
			
		}
		
	}

	@Override
	public void sendLocation(double lat, double lon) {
		if (_arch.OUT_IToolBarEvent != null){
			_arch.OUT_IToolBarEvent.onLocationReceived(lat, lon);
			
		}
		
	}
}