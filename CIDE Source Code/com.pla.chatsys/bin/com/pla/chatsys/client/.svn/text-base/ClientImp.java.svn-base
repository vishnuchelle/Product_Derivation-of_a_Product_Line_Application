package com.pla.chatsys.client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.CharacterData;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import comp.Templet.TemplateGUI;
import comp.Templet.TemplateGUI.SelectInterfce;
import comp.Templet.TempletSelector;



public class ClientImp extends JFrame implements ActionListener,IClientImp
{
	private ClientArch _arch;
	public static String IconPath = "icons\\";
	private static String filePath = "C:\\temp\\";
	
	JFrame f = new JFrame();
	JTextField entryField;
	JButton template;
	JButton sendButton;
	JButton loadButton;
	JButton trackButton;
	JButton TTTButton;
	JButton ImageButton;
	JEditorPane transcript = new JEditorPane("text/html", "");
	JButton printButton;
	JButton privateButton;
	JButton fileButton;
	
	JButton colorButton;
	JButton settingsButton;
	public int flag = 0;
	StringBuffer transcriptBuf;
	DefaultComboBoxModel model = new DefaultComboBoxModel();
	JComboBox comboBox = new JComboBox(model);
	String File = "./ChatHistory.txt";

    public ClientImp (){
    }

	public void setArch(ClientArch arch){
		_arch = arch;
	}
	public ClientArch getArch(){
		return _arch;
	}

	/*
  	  Myx Lifecycle Methods: these methods are called automatically by the framework
  	  as the bricks are created, attached, detached, and destroyed respectively.
	*/	
	public void init(){
	    
	}
	public void begin(){
		transcriptBuf = new StringBuffer();
		
		//textarea.setText("Here is some <b>bold text</b>");
		//transcript = new JTextArea();
		entryField = new JTextField(20);
		sendButton = new JButton("Send");
		template = new JButton("Templates");
		TTTButton = new JButton(new ImageIcon(IconPath+"TTT.png"));
		TTTButton.setBackground(Color.WHITE);
		//TTTButton.setPreferredSize(new Dimension(30, 30));
		ImageButton = new JButton("Send Image");
		printButton = new JButton(new ImageIcon(IconPath+"Print.png"));
		printButton.setBackground(Color.WHITE);
		//printButton.setPreferredSize(new Dimension(30, 30));
		privateButton = new JButton(new ImageIcon(IconPath+"Private.png"));
		privateButton.setBackground(Color.WHITE);
		//privateButton.setPreferredSize(new Dimension(30,30));
		trackButton = new JButton(new ImageIcon(IconPath+"Track.png"));
		trackButton.setBackground(Color.WHITE);
		//trackButton.setPreferredSize(new Dimension(30,30));
		colorButton = new JButton(new ImageIcon(IconPath+"Color.png"));
		colorButton.setBackground(Color.WHITE);
		//colorButton.setPreferredSize(new Dimension(30,30));
		
		fileButton = new JButton("Send File");
		fileButton = new JButton(new ImageIcon(IconPath+"SendFile.png"));
		fileButton.setBackground(Color.WHITE);
		settingsButton = new JButton(new ImageIcon(IconPath+"Settings.png"));
		settingsButton.setBackground(Color.WHITE);
		final JPopupMenu menu = new JPopupMenu();
		JMenuItem defaultLoc = new JMenuItem("Default Location");
		menu.add(defaultLoc);
		defaultLoc.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {

            	
            	JFileChooser fileChooser = new JFileChooser();
            	fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            	int fileStatus = fileChooser.showDialog(ClientImp.this, "Select file");
            	if(fileStatus == JFileChooser.APPROVE_OPTION ){
            		filePath  = fileChooser.getSelectedFile().getAbsolutePath()+"\\";
            	
            	//_arch.OUT_IChat.sendFile(getTitle(), fileChooser.getSelectedFile());
            	
            	//System.out.println("path-->"+fileChooser.getSelectedFile().getAbsolutePath());
            	///System.out.println("image tag --->"+imgtag);
            	
            	}
            	
            	
            
				
			}
		});
		
		
		//colorButton.setPreferredSize(new Dimension(30,30));
		loadButton = new JButton("Chat History");
		transcript.setEditable(false);
		sendButton.addActionListener(this);
		
		settingsButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
			menu.show(settingsButton, 0,settingsButton.getBounds().height /*settingsButton.getBounds().y+settingsButton.getBounds().height*/);
			}
		});
		colorButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				

				JColorChooser colorChooser = new JColorChooser();
				Color color = colorChooser.showDialog(ClientImp.this, "Pick Color", Color.GRAY);
				
				ArrayList<Object> parameters = new ArrayList<Object>();
				parameters.add(getTitle());
				parameters.add(color);
				_arch.OUT_IToolBar.sendColor(getTitle(), color.hashCode());
				//_arch.OUT_IChatSettings.setColor(getTitle(), color);
				//_arch.optionalProvider("settings", "setColor", parameters);
				
				
			}
		});
		
		
		
		String title = "Chat Client " + _arch.getMyxBrickItems().getBrickName().toString().substring(42);
		f.setTitle(title);
		this.setTitle(title);
		//this.setLocation(100, 200);
		//String title = "Chat Client " + _arch.getMyxBrickItems().getBrickName().toString().substring(42);
		//this.setTitle(title);
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new BorderLayout());
		JScrollPane scrollingArea = new JScrollPane(transcript);
		centerPanel.add(scrollingArea, BorderLayout.CENTER);
		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		bottomPanel.add(entryField);
		bottomPanel.add(sendButton);
		bottomPanel.add(loadButton);
		bottomPanel.add(template);
		
		
		bottomPanel.add(ImageButton);
		
		
		
		model.addElement("Available");
		model.addElement("Do not Disturb");

		topPanel.add(settingsButton);
		topPanel.add(trackButton);
		topPanel.add(fileButton);
		topPanel.add(colorButton);
		topPanel.add(TTTButton);
		topPanel.add(printButton);
		topPanel.add(privateButton);
		topPanel.add(comboBox);
		
		
		 
		loadButton.addActionListener(new ActionListener() {
			 
            public void actionPerformed(ActionEvent e)
            {
            	
                String ChatHistory = _arch.OUT_IHistoryRetrive.retriveChatHistory(getTitle());//reading();   //Execute when button is pressed
                transcript.setText(ChatHistory);
            	
            	
            }
        });  
		TTTButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
			
				_arch.OUT_IGame.startGame();
				
			}
		});
		template.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
			
				
				//_arch.OUT_ISendTemplet.sendTemplet(getTitle(), entryField.getText());
				
				TemplateGUI temp = new TemplateGUI();
				temp.setSelectInterface(new SelectInterfce() {
					
					@Override
					public void onItemSelect(String msg1) {
					
					
					if(!msg1.equals("")){
						_arch.OUT_ISendTemplet.sendTemplet(getTitle(), msg1);
					
					}
					}
				});
				
			}
		});
		ImageButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
			
			
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.addChoosableFileFilter(new javax.swing.filechooser.FileFilter() {

			        @Override
			        public boolean accept(File f) {
			        	String filename = f.getName();
			            if(filename.endsWith(".jpg") || filename.endsWith(".jpeg") 
			               || filename.endsWith(".png") || filename.endsWith(".bmp")
			               || filename.endsWith(".gif") || filename.endsWith(".jpe")){
			            	
			            	return true;
			            }
			            return false;
			        }

			        @Override
			        public String getDescription() {
			            return "JPEG files";
			        }

			    });
            	int fileStatus = fileChooser.showDialog(ClientImp.this, "Select file");
            	if(fileStatus == JFileChooser.APPROVE_OPTION ){
            		File f = fileChooser.getSelectedFile();
            		_arch.OUT_ISendImage.sendImage(getTitle(), f.getName(),getBytes(f));
            		
				
//				ArrayList<Object> params = new ArrayList<Object>();
//            	params.add(getTitle());
//            	params.add("<img src =\"file:"+fileChooser.getSelectedFile().getAbsolutePath()+"\"/>");
//            	params.add(flag);
//            	_arch.optionalProvider("chat", "sendMessage", params);
            	}
			}
		});
		
		fileButton.addActionListener(new ActionListener() {
			 
            public void actionPerformed(ActionEvent e)
            {
            	
            	JFileChooser fileChooser = new JFileChooser();
            	
            	int fileStatus = fileChooser.showDialog(ClientImp.this, "Select file");
            	if(fileStatus == JFileChooser.APPROVE_OPTION ){
            		
            		File file = fileChooser.getSelectedFile();
            		byte[] fileData = getBytes(file);
            	_arch.OUT_ISendFileListener.sendFile(getTitle(), file.getName(), fileData);
            	
            	}
            	
            	
            }

			
        });  
		printButton.addActionListener(new ActionListener() {
			 
            public void actionPerformed(ActionEvent e)
            {
            	       
            	_arch.OUT_IPrintEvent.print(transcript.getText());
            	
            		
            	
            	/*try {
					boolean complete = transcript.print();
					if (complete)
					{
						JOptionPane.showMessageDialog(null,"Done Printing!","Information",JOptionPane.INFORMATION_MESSAGE);
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Printing Aborted !!","Printer",JOptionPane.ERROR_MESSAGE);
					}
				} catch (PrinterException e1) {
					
					JOptionPane.showMessageDialog(null, e1);
				}*/
            }
        });  
		
		privateButton.addActionListener(new ActionListener() {
			 
            public void actionPerformed(ActionEvent e)
            {
            	  if (flag == 0){
            		  flag = 1;
            		
            		  privateButton.setBackground(new Color(150,150,150));
            		  
            	  	}
            	  else if (flag == 1)
            	  {
            		  flag = 0;
            		  privateButton.setBackground(Color.WHITE);
            	  }
			}
		});
		
		trackButton.addActionListener(new ActionListener() {
			 
            public void actionPerformed(ActionEvent e)
            {
            	URL connection;
				try {
					connection = new URL("http://checkip.amazonaws.com/");
					URLConnection con = connection.openConnection();
	                String str = null;
	                String xml = null;
	                String XMLcode;
	                BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
	                str = reader.readLine();
	                //System.out.println(str);
	                reader.close();
	                String tracking = " http://api.ipaddresslabs.com/iplocation/v1.7/locateip?key=demo&ip="+str+"&format=XML";
	               // System.out.println(tracking);
	                BufferedReader reader1 = new BufferedReader(new InputStreamReader(new URL(tracking).openStream()));
	                XMLcode = reader1.readLine();
	                while((XMLcode = reader1.readLine()) != null)
					{	
	                	if (xml==null){ xml = XMLcode;}
	                	else{
						xml = xml + XMLcode;}
					}
	              System.out.println(xml);
	            	    try {
	            	        DocumentBuilderFactory dbf =
	            	            DocumentBuilderFactory.newInstance();
	            	        DocumentBuilder db = dbf.newDocumentBuilder();
	            	        InputSource is = new InputSource();
	            	        is.setCharacterStream(new StringReader(xml));

	            	        Document doc = db.parse(is);
	            	        NodeList nodes = doc.getElementsByTagName("geolocation_data");

	            	        // iterate the employees
	            	        for (int i = 0; i < nodes.getLength(); i++) {
	            	           Element element = (Element) nodes.item(i);

	            	           NodeList name = element.getElementsByTagName("latitude");
	            	           Element line = (Element) name.item(0);
	            	           String lat = getCharacterDataFromElement(line);
	            	          // System.out.println(lat);
	            	           NodeList title = element.getElementsByTagName("longitude");
	            	           line = (Element) title.item(0);
	            	           String lng = getCharacterDataFromElement(line);
	            	           
	            	           _arch.OUT_IToolBar.sendLocation(Double.parseDouble(lat), Double.parseDouble(lng));
	            	          // System.out.println(lng);
	            	          // String browserPath = "C:/Program Files/Internet Explorer/IEXPLORE.EXE"; //Use your browser path
	            	           String browserPath = "C:/Users/arun/AppData/Local/Google/Chrome/Application/chrome.exe";
	            	           String url = "https://maps.google.com/maps?q="+lat+","+lng;
	            	           //transcript.setPage(url);
	            	           try {
//	            	                String[] b = {browserPath, url};
//	            	                Runtime.getRuntime().exec(b);
	            	            }
	            	            catch (Exception exc) {
	            	         exc.printStackTrace();
	            	            }
	 
	            	        }
	            	    }
	            	    catch (Exception e1) {
	            	        e1.printStackTrace();
	            	    }
	            	    
				   
				} catch (IOException e1) {
					
					e1.printStackTrace();
				} 
				
              /* if (flag == 0){
            		flag = 1;
            	}
            	else if (flag == 1)
            	{
            		flag = 0;
            	}*/
				
            }
        }); 
		
		
		f.getContentPane().add("Center", centerPanel);
		f.getContentPane().add("South", bottomPanel);
		f.getContentPane().add("North", topPanel);
		f.addWindowListener(new WindowEventHandler());
		f.setLocation(100, 200);
		f.setSize(800, 600);
		f.setVisible(true);
		validate();
		repaint();
	}
	
	public static String getCharacterDataFromElement(Element e) {
	    Node child = e.getFirstChild();
	    if (child instanceof CharacterData) {
	       CharacterData cd = (CharacterData) child;
	       return cd.getData();
	    }
	    return "?";
	  }
	public void end(){
		
	}
	public void destroy(){
		
	}

	/*
  	  Implementation primitives required by the architecture
	*/
  
    
    public void messageSent (String sender,String message)   {

    	
    	String status = (String) comboBox.getSelectedItem();
    	if (status == "Available")
    	{
    		addMessageToTranscript(sender+ ": " +"<h2>"+message+"</h2>");
    	//	flag1 = 0;
    		
    	}
    	else
    	{
    		//flag1 = 1;
    		JOptionPane.showMessageDialog(this,"User Status: DO NOT DISTURB!", "Message Sending Failed!!", JOptionPane.ERROR_MESSAGE);
    	}
    
		
    }

    public void addMessageToTranscript(String text){
		transcriptBuf.append(text);
		transcriptBuf.append(System.getProperty("line.separator"));
		transcript.setText(transcriptBuf.toString());
	}

	public String reading()
    {
    	String sCurrentLine = null;
    	String Allfile = null;
    	BufferedReader br = null;
		try {
			 
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
	public void actionPerformed(ActionEvent arg0) {
		
		String cmd = arg0.getActionCommand();
		if(cmd.equalsIgnoreCase("Send")){
			System.out.println("HI");
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		String date = " Sent on-" + dateFormat.format(cal.getTime());
		String text = entryField.getText();
		String Msg = getTitle() + ": " + text + date;	
		if(!text.equals("")){
			if(flag == 1){
				_arch.OUT_IToolBar.sendIncognitoMessage(getTitle(), text);
			}else{
				_arch.OUT_IChat.sendMessage(getTitle(), text);	
			}
			
		
		}
		
	}else if(cmd.equals("Color")){
		JColorChooser colorChooser = new JColorChooser();
		Color color = colorChooser.showDialog(ClientImp.this, "Pick Color", Color.GRAY);
		_arch.OUT_IToolBar.sendColor(getTitle(), color.hashCode());
		}
	}

	@Override
	public void fileSent(String sender, String fileName, byte[] fileData) {
		if(!sender.equals(this.getTitle())){
			
			transcript.setText("Recived a file "+fileName+"\n");
		
				try{
			saveFile(filePath+fileName,fileData);
				}catch(Exception e){
					e.printStackTrace();
				}
				
			//File file1 = new File(file, filePath);
		//	}
		}
		
	}

	private byte[] getBytes(java.io.File file) {
		byte[] b = new byte[(int) file.length()];
		FileInputStream fileInputStream = null;
     try {
    	 
    	 fileInputStream = new FileInputStream(file);
           fileInputStream.read(b);
           for (int i = 0; i < b.length; i++) {
                       System.out.print((char)b[i]);
            }
           fileInputStream.close();
      } catch (FileNotFoundException e) {
                  System.out.println("File Not Found.");
                  e.printStackTrace();
      }
      catch (IOException e1) {
               System.out.println("Error Reading The File.");
                e1.printStackTrace();
      }
     
     return b;
     }
	private void saveFile(String strFilePath, byte[] fileData) {
		
        try {
             FileOutputStream fos = new FileOutputStream(strFilePath);
             
             fos.write(fileData);
             fos.close();
       }
      catch(FileNotFoundException ex)   {
             System.out.println("FileNotFoundException : " + ex);
      }
     catch(IOException ioe)  {
             System.out.println("IOException : " + ioe);
      }
		
	}

	@Override
	public void imageSent(String sender, String imageName, byte[] imageData) {
//		if(!sender.equals(getTitle())){
			try{
				saveFile(filePath+imageName,imageData);
					}catch(Exception e){
						e.printStackTrace();
					}
	
//		}
		
		String imgtag = "<img src =\"file:"+filePath+imageName+"\"/>";
    	messageSent(sender, imgtag);
	}

	@Override
	public void gameStarted() {
		_arch.OUT_ITTT.startTTT(f.getLocationOnScreen().x,f.getLocationOnScreen().y-100);
	}

	@Override
	public void gameEnded() {
		_arch.OUT_ITTT.endTTT();
	}

	@Override
	public void played(String sender, int position) {
		if (!sender.equals(getTitle())){
			_arch.OUT_ITTT.opponentMove(position);			
		}
	}

	@Override
	public void myMove(int position) {
		_arch.OUT_IGame.play(getTitle(), position);
	}

	@Override
	public void quit() {
		_arch.OUT_IGame.endGame();
	}

	
	
	public void buzz()
	{
		final int lX = f.getLocationOnScreen().x; 
        final int lY = f.getLocationOnScreen().y; 
        System.out.println(lX+"+"+lY);
        try {  
        	for(int i = 0; i < 20; i++) { 
            Thread.sleep(10); 
            f.setLocation(lX, lY + 5); 
            Thread.sleep(10); 
            f.setLocation(lX, lY - 5);
            Thread.sleep(10); 
            f.setLocation(lX + 5, lY);
            Thread.sleep(10); 
            f.setLocation(lX, lY); 
          } 
            
            } 
          catch (Exception err) { 
            err.printStackTrace(); 
          } 
	}

	@Override
	public void onColorReceived(int color) {
		transcript.setBackground(new Color(color));
		
	}

	@Override
	public void onLocationReceived(double lat, double lon) {
		String url = "https://maps.google.com/maps?q="+lat+","+lon;
		String tag = "<a href = \""+url+"\" target=\"_blank\"> click </a> ";
		messageSent(getTitle(), "lat:"+lat + " \n lon: "+lon);
	}

	@Override
	public void sendTemplet(String sender, String code) {

		String[] result = _arch.OUT_ITempletRetriver.getTemplet(code);
		if(result!=null){
			
			if(result[0].equals("text")){
				
				messageSent(sender, result[1]);
			}else if(result[0].equals("image")){
				String imgtag = "<img src =\"file:"+IconPath+result[1]+"\"/>";
		    	messageSent(sender, imgtag);
				
			}else if(result[0].equals("multimedia")){
				if(result[1].equals("buzz")){
					buzz();	
				}
				
				
			}
		}

		
		
	}
}

class WindowEventHandler extends WindowAdapter {
	  public void windowClosing(WindowEvent evt) {
	    System.exit(0);
	  }
}