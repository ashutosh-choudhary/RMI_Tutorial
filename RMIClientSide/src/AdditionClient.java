import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class AdditionClient {
	public static void main(String[] args) {		
		AdditionInterface hello;
		try{
			System.setSecurityManager(new SecurityManager());
			Registry r = LocateRegistry.getRegistry("10.0.0.115", 1099);
			hello = (AdditionInterface) r.lookup("ABC");
			int result = hello.add(56, 12);
			System.out.println("Result from server: " + result);			
		}catch (Exception e){
			System.out.println("HelloClient exception: " + e);
		}
	}

}
