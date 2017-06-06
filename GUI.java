import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
import java.io.*;

class GUI extends Frame {
	private final TextField
		nameField = new TextField(),
		addressField = new TextField(),
		telephoneField = new TextField(),
		emailField = new TextField();
	private final List customerNames = new List(CustomerList.LINE_COUNT);
	private final Button
		homeButton = new Button("Home"),
		addButton = new Button("Add"),
		removeButton = new Button("Remove"),
		showButton = new Button("Show"),
		exportButton = new Button("Export");

	// define an export method so that listener object can call this method when used by the exportedButton.
	static final String SEPARATOR = "\t";
	static void writeToCSV(Vector<Customer> customers){
        try{
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("/Users/yifan/Desktop/Output.csv"), "UTF-8"));
            //bw.newLine();
            for (Customer customer : customers){

                StringBuffer oneLine = new StringBuffer();
                oneLine.append(customer.getName().trim().length() == 0 ? "" : customer.getName());
                oneLine.append(SEPARATOR);
                oneLine.append(customer.getAddress().trim().length() == 0 ? "" : customer.getAddress());
                oneLine.append(SEPARATOR);
                oneLine.append(customer.getTelephone().trim().length() == 0 ? "" : customer.getTelephone());
                oneLine.append(SEPARATOR);
                oneLine.append(customer.getEmail().trim().length() == 0 ? "" : customer.getEmail());
                oneLine.append(SEPARATOR);

                bw.write(oneLine.toString());
                bw.newLine();
            }
            bw.flush();
            bw.close();
        }
        catch (UnsupportedEncodingException e) {System.out.println(e.getMessage());}
        catch (FileNotFoundException e){System.out.println(e.getMessage());}
        catch (IOException e){System.out.println(e.getMessage());}

	}// end of writeCSV


	GUI(int lines){
		Panel panel = new Panel(new GridLayout(4,2));// HAVE TO USE the GirdLayout to create 4 rows and 2 columns for the panel

		Label nameLabel = new Label("Name:");
		Label addressLabel = new Label("Address:");
		Label telephoneLabel = new Label("Telephone:");
		Label emailLabel = new Label("Email:");

		panel.add(nameLabel);
		panel.add(nameField);

		panel.add(addressLabel);
		panel.add(addressField);

		panel.add(telephoneLabel);
		panel.add(telephoneField);

		panel.add(emailLabel);
		panel.add(emailField);

		add(panel,"North"); // PLACE THE PANEL TO THE GUI North division

		panel = new Panel();
		Label namesLabel = new Label("Names:");
		panel.add(namesLabel);
		customerNames.setSize(100,50);
		panel.add(customerNames);

		add(panel,"Center"); // PLACE THE PANEL TO THE GUI Center division

		panel = new Panel();
		panel.add(homeButton);
		panel.add(addButton);
		panel.add(removeButton);
		panel.add(showButton);
		panel.add(exportButton);

		add(panel,"South"); // PLACE THE PANEL TO THE GUI South division

		// add the logic to the buttons by delegating listener class/interface object
		addButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Customer customer = new Customer();
				customer.name = nameField.getText();
				customer.address = addressField.getText();
				customer.telephone = telephoneField.getText();
				customer.email = emailField.getText();

				CustomerList.customers.addElement(customer);
				customerNames.addItem(customer.name);
				// when added, empty the TextFields!
				nameField.setText("");
				addressField.setText("");
				telephoneField.setText("");
				emailField.setText("");

			}
		});
		removeButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int index = customerNames.getSelectedIndex();
				Customer customer = (Customer) CustomerList.customers.elementAt(index);
				if(index<0) return;
				//before removing, set the TextField to the values of the current Customer object so that we can create it again once mis-deleted
				nameField.setText(customer.name);
				addressField.setText(customer.address);
				telephoneField.setText(customer.telephone);
				emailField.setText(customer.email);

				CustomerList.customers.removeElementAt(index);
				customerNames.remove(index);

			}
		});
		showButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int index = customerNames.getSelectedIndex();
				Customer customer = (Customer) CustomerList.customers.elementAt(index);
				if(index<0) return;
				nameField.setText(customer.name);
				nameField.show();
				addressField.setText(customer.address);
				addressField.show();
				telephoneField.setText(customer.telephone);
				telephoneField.show();
				emailField.setText(customer.email);
				emailField.show();
			}
		});
		homeButton.addActionListener(new ActionListener(){ // home button essentially acting like a cleaner
			public void actionPerformed(ActionEvent e){
				nameField.setText("");
				nameField.show();
				addressField.setText("");
				addressField.show();
				telephoneField.setText("");
				telephoneField.show();
				emailField.setText("");
				emailField.show();
			}
		});

		exportButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
			 	//Vector<Customer> customers = CustomerList.customers;
			    GUI.writeToCSV(CustomerList.customers);

			}
		});
	}

	GUI(String title, int lines){
		this(lines);
		setTitle(title);
	}

}
