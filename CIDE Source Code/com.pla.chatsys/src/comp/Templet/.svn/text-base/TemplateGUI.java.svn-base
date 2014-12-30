package comp.Templet;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.pla.chatsys.client.ClientImp;

@SuppressWarnings("serial")
public class TemplateGUI extends JDialog implements ActionListener {

	
	public SelectInterfce selectInterface;
	JFrame f = new JFrame();
	JList list;

	public TemplateGUI() {		
		 
		JPanel nothPanel = new JPanel();
		nothPanel.setLayout(new FlowLayout());
		//f.add(nothPanel);
		String [] message = {"I am Busy!","Talk to you later!","At a Meeting","On phone! Catch you later","Good Morning","Good Night","Get Well Soon!"};
		JLabel labName = new JLabel();
		labName.setText("Text Templets");
		list = new JList(message);
		String val = (String)list.getSelectedValue();
		list.addListSelectionListener(new SelectionHandler());
		nothPanel.add(labName);
		nothPanel.add(list);
		list.setSize(00, 200);
		f.add(nothPanel, BorderLayout.NORTH);
//central panel		
		
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new FlowLayout());
		
		
		JLabel labImage = new JLabel();
		labImage.setText("Image Templets");
		JButton image = new JButton(new ImageIcon(ClientImp.IconPath+"smile.png"));
		
		centerPanel.add(labImage);
		centerPanel.add(image);
		f.add(centerPanel, BorderLayout.CENTER);
		  
//south panel		
		JPanel southPanel = new JPanel();
		southPanel.setLayout(new FlowLayout());
		
		
		JLabel labmulti = new JLabel();
		labmulti.setText("Multimedia Templets");
		JButton buzz = new JButton(new ImageIcon(ClientImp.IconPath+"buzz.jpg"));
		
		southPanel.add(labmulti);
		southPanel.add(buzz);
		f.add(southPanel, BorderLayout.SOUTH);
		  
		  f.setBounds(200, 200, 400, 400);
		  f.setVisible(true);
		  f.setResizable(false);
		  f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		  
		  image.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(selectInterface!=null){
				 selectInterface.onItemSelect(":)");
				 f.dispose();
				}
			}
		});
		
		  buzz.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(selectInterface!=null){
				 selectInterface.onItemSelect("buzz");
				 f.dispose();
				}
			}
		});
	}
	 public void setSelectInterface(SelectInterfce selectInterface){
		 this.selectInterface = selectInterface;
	 }
	 public String Values(){
		 String val = (String)list.getSelectedValue();
 		 System.out.println(val);
 		 if(selectInterface!=null){
 			 selectInterface.onItemSelect(val);
 		 }else{
 			 System.out.println("null value");
 		 }
 		   return val;
	 }
	 private class SelectionHandler implements ListSelectionListener {

	      @Override
	      public void valueChanged(ListSelectionEvent e) {
	          if (!e.getValueIsAdjusting()) {
	              //System.out.println(list.getSelectedValue());
	            Values();    
	            f.dispose();
	          }
	      }
	  }
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		// TODO Auto-generated method stub
		
	}
	
	public interface SelectInterfce{
		
		public void onItemSelect(String msg);
	}
	

}
