import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.*;

public class ChatServer {
	public static void main(String[] args) {		
		try{
			System.setSecurityManager(new SecurityManager());
			Scanner s= new Scanner(System.in);
			System.out.println("Enter your name and press Return");
			String name = s.nextLine().trim();
			
			Chat server = new Chat(name);
			Registry r = LocateRegistry.createRegistry(1099);
			r.rebind("ABC", server);
			System.out.println("[System] Chat Remote Object is ready:");
			
			while(true){
				String msg=s.nextLine().trim();
				if(server.getClient()!=null){
					ChatInterface client=server.getClient();
					msg="["+server.getName()+"]"+msg;
					client.send(msg);
				}
			}
		}catch(Exception e){
			System.out.println("[System] Server failed: " + e);
		}
	}

}
