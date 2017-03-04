import java.rmi.*;
import java.rmi.server.*;

public class AdditionServer {

	public static void main(String[] args) {
	try{
		System.setSecurityManager(new SecurityManager());
		Addition Hello = new Addition();
		Naming.rebind("rmi://localhost/ABC", Hello);
		System.out.println("Addition Server is ready.");
	}
	catch(Exception e){
		System.out.println("Addition Server failed: " + e);
	}

	}

}
