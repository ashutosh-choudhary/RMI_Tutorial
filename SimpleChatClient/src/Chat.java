import java.rmi.*;
import java.rmi.server.*;
public class Chat extends UnicastRemoteObject implements ChatInterface{
	public String name;
	public ChatInterface client =null;
	
	public Chat(String n) throws RemoteException {
		super();
		this.name = n;
	}
	
	public String getName() throws RemoteException {
		return this.name;
	}
	
	public void send(String msg) throws RemoteException {
		System.out.println(msg);
		
	}
	
	public void setClient(ChatInterface c) throws RemoteException {
		client=c;
	}
	
	public ChatInterface getClient() throws RemoteException {
		return client;
	}
	
}
