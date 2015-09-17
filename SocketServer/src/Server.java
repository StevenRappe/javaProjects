import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

// creates server, listens for socket, reads from and writes to client
public class Server {
	
	static ServerSocket listener = null;
	static Socket socket = null;
	static int readInputSize, sum=0;
	static ObjectOutputStream oos;
	static ObjectInputStream ois;
	
	
	public static void main(String[] args) throws IOException {
		
		Server host = new Server();
		
		host.createHost();
		host.accept();
		
		oos = new ObjectOutputStream(socket.getOutputStream());
		ois = new ObjectInputStream(socket.getInputStream());
		
		host.read();
		host.write();
		
		socket.close();
	}
	
	// create host server
	void createHost()  {
		try {
			listener = new ServerSocket(6920);
			System.out.println("Listener socket created");
			}
			catch(IOException e) {
				System.out.println(e);
		}
	}
	
	// receive connection from client
	void accept() {
		try {
			socket = listener.accept();
			System.out.println("Socket accepted");
			}
			catch(IOException e) {
				System.out.println(e);
		}
	}
	
	// read from client
	void read() throws IOException {
		try {
			readInputSize = (Integer) ois.readObject();
			for (int i=0; i<readInputSize; i++) {
				sum += (Integer) ois.readObject();
			}
			System.out.println(sum);
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	// write to client
	void write() throws IOException {
		try {
			oos.writeObject(sum);
			}
			catch(IOException e) {
				System.out.println(e);
		}
		oos.flush();
	}
}