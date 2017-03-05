import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.*;

public class AdditionServer {

	public static void main(String[] args) {
	try{
		System.setSecurityManager(new SecurityManager());
		Registry r = LocateRegistry.createRegistry(1099);
		Addition Hello = new Addition();
		r.rebind("//localhost/ABC", Hello);
		System.out.println("Addition Server is ready.");
	}
	catch(Exception e){
		System.out.println("Addition Server failed: " + e);
	}

	}

}
