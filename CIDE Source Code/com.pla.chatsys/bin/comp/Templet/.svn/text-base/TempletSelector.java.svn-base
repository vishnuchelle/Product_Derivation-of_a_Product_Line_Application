package comp.Templet;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import comp.Templet.TemplateGUI.SelectInterfce;


/*
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */ 




/**
 * Component to be used as tabComponent;
 * Contains a JLabel to show the text and 
 * a JButton to close the tab it belongs to 
 */ 
public class TempletSelector extends JDialog implements ActionListener {
	
	
	public SelectInterfce selectInterface;
	JFrame f = new JFrame();
	JList list;
	public TempletSelector() {
		
		 
	 JPanel closePanel = new JPanel();
		  closePanel.setLayout(new FlowLayout());
		  f.add(closePanel);
		  String [] message = {"I am Busy!","Talk to you later!","At a Meeting","On phone! Catch you later","Good Morning","Good Night","Get Well Soon!"};
		  	JLabel labName = new JLabel();
		  	labName.setText("Demo");
		   list = new JList(message);
		   String val = (String)list.getSelectedValue();
		   list.addListSelectionListener(new SelectionHandler());
		   closePanel.add(labName);
		    closePanel.add(list);
		    list.setSize(00, 200);
		  f.add(closePanel, BorderLayout.WEST);
		  f.setBounds(200, 200, 400, 400);
		  f.setVisible(true);
		  f.setResizable(false);
		  f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	
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
	 public void setSelectInterface(SelectInterfce selectInterface){
		 this.selectInterface = selectInterface;
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
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
public interface SelectInterfce{
		
		public void onItemSelect(String msg);
	}
}

