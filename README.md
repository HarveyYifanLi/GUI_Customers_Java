# GUI_Customers_Java
This is a Graphical User Interface (GUI) developed in Java functioning as a Registration System for customers.
The Export button defined in the GUI also enables outputing the registered customers (which are contained in Vector<Customer> customers) as a file in a format that can be directly loaded into the MySQL database.

## CustomerList.java
This file defines the CustomerList constructor within which an GUI object is called and with an WindowAdapter object
added to handle the window closing event.

The invoking main method is also defined.
## GUI.java
This is the primary file where the "view" and "controllers" of our registration GUI are defined and where the business logic is added
through various buttons which use the so-called Event Delegation Model, namely, a listener object (from either an Adapter
class or a listener interface)is delegated to handle the event fired from the component/container object.

The GUI contains three divisions: "North","Center" and "South".

## Customer.java
The "model" part of our GUI app where the Customer class is defined.



