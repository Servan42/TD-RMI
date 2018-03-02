package BabyStep;

import java.rmi.registry.LocateRegistry;

public class Server {
	public static void main(String args[]) {
		try {
			FrenchToEnglish obj = new FrenchToEnglishImpl();
			
			LocateRegistry.createRegistry(2001);
			java.rmi.Naming.bind("//localhost:2001/FrenchToEnglishTranslator", obj);
			System.out.println("Serveur et registre opérationels");
		} catch(Exception e) {
			System.out.println("C'est la panique "+e.toString());
		}
	}
}
