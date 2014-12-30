package com.pla.chatsys.client;

import java.awt.print.PrinterException;

import javax.swing.JEditorPane;
import javax.swing.JOptionPane;



public class PrinterImp implements IPrintCompImp
{
	private PrinterArch _arch;

    public PrinterImp (){
    }

	public void setArch(PrinterArch arch){
		_arch = arch;
	}
	public PrinterArch getArch(){
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
  
    
	public void print(String str){
		
		JEditorPane transcript = new JEditorPane("text/html", "");
		transcript.setText(str);
		try {
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
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e1);
		}
	}
}