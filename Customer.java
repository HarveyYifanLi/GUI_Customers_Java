import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.FileOutputStream;

public class Customer {
	String name, address, telephone, email;
	Customer(){};

	Customer(String name, String address, String telephone, String email){
		this.name = name;
		this.address = address;
		this.telephone = telephone;
		this.email = email;
	}
	public String getName(){
		return name;
	}
	public String getAddress(){
		return address;
	}
	public String getTelephone(){
		return telephone;
	}
	public String getEmail(){
		return email;
	}



}