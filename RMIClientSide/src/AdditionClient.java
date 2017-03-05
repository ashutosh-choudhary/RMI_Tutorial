import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class AdditionClient {
	public static void main(String[] args) {		
		AdditionInterface hello;
		try{
			System.setSecurityManager(new SecurityManager());
			Registry r = LocateRegistry.getRegistry("localhost", 1099);
			hello = (AdditionInterface) r.lookup("//localhost/ABC");
			int result = hello.add(9, 12);
			System.out.println("Result from server: " + result);			
		}catch (Exception e){
			System.out.println("HelloClient exception: " + e);
		}
	}

}
