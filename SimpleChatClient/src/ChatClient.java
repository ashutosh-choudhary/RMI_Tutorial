import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.*;
import java.util.*;

public class ChatClient {

	public static void main(String[] args) {
		try{
			System.setSecurityManager(new SecurityManager());
			Scanner s = new Scanner(System.in);
			System.out.println("Enter your name and press Return");
			String name = s.nextLine().trim();
			ChatInterface client = new Chat(name);
			Registry r = LocateRegistry.getRegistry("10.0.0.115", 1099);
			ChatInterface server = (ChatInterface) r.lookup("ABC");
			String msg="["+client.getName()+"] got connected";
			server.send(msg);
			System.out.println("[System] Chat Remote Object is ready:");
			server.setClient(client);
			
			while(true){
				msg = s.nextLine().trim();
				msg="["+client.getName()+"]"+msg;
				server.send(msg);
			}
		}catch (Exception e){
			System.out.println("[System] Server failed: " + e);
		}

	}

}
