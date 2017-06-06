import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

public class CustomerList{
	static final int LINE_COUNT = 10;
	static final Vector customers = new Vector();

	public CustomerList(){
		GUI mainWindow = new GUI("Customer List",LINE_COUNT);
		mainWindow.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				if(e.getID()==WindowEvent.WINDOW_CLOSING)
					System.exit(0);
			}
		});
		mainWindow.pack();
		mainWindow.show();
	}
	public static void main(String[] args){
		new CustomerList();
	}
}

