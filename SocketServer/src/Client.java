/*
 * Steven Rappe
 * Assignment 8
 * Socket Communication
 * 
 * Creates a client and server which communicate using
 * a single thread. Client writes list to server which
 * in turn calculates the sum of the list's elements and
 * sends sum to the client.
 */

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;


public class Client {
	
	static ArrayList<Integer> al;
	static Scanner stdin;
	static String tempString, hostName;
	static Integer autoBoxInt;
	static Socket socket = null;
	static int numberCount = 0, finalInput = 0;
	static ObjectOutputStream oos;
	static ObjectInputStream ois;
	
	public Client() {
		al = new ArrayList<Integer>();
		stdin = new Scanner(System.in);
	}
	
	public static void main(String[] args) throws IOException {
		
		Client client = new Client();
		
		client.createList();
		client.connect();
		
		oos = new ObjectOutputStream(socket.getOutputStream());
		ois = new ObjectInputStream(socket.getInputStream());
		
		client.write();
		client.read();
		
		socket.close();
	}
	
	// create array list of integers
	void createList() {
		do {
			System.out.println("Enter an integer. Press enter to end loop.");
			tempString = stdin.nextLine();
			try {
				autoBoxInt = new Integer(Integer.parseInt(tempString));
				al.add(autoBoxInt);
				numberCount+=1;
				}
				catch(NumberFormatException e) {
					System.out.println("Invalid input.");
			}
		} while(tempString.length() > 0);
	}
	
	// connect to host server
	void connect() {
		System.out.println("Enter the name of the host machine: ");
		hostName = stdin.next();
		try{
			socket = new Socket(hostName, 6920);
			System.out.println("Client socket created");
			}
			catch (IOException e) {
				System.out.println(e);
		}
	}
	
	// write to server
	void write() throws IOException {
		try {
			oos.writeObject(numberCount);
		
			for (int i=0; i<numberCount; i++) {
				oos.writeObject(al.get(i));
				}
			}
			catch (IOException e) {
				System.out.println(e);
		}
		oos.flush();
	}
	
	// read from server
	void read() throws IOException {
		try {
			finalInput = (Integer) ois.readObject();
			}
			catch (ClassNotFoundException e) {
				System.out.println(e);
		}
	}
}