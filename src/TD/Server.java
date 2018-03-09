package TD;
import java.rmi.registry.*;
import java.rmi.RemoteException;
import java.rmi.RMISecurityManager;

/**
 * @author morat 
 */
public class Server {
  /**
   * @param args
   */
  public static void main(final String args[]) {
    String nom="";
    int nombre=1; int port = 1099;
    Registry registry=null;
    // récupération des arguments
    if (args.length!=3){
      System.out.println("Server <nom générique des objets distants> <nombre de noms> <port du registry>");
      System.exit(1);
    }
    try  {
      nom = args[0];
      port = Integer.parseInt(args[1]);
      nombre = Integer.parseInt(args[2]);
    }catch(Exception e) {
      System.out.println("Server <nom générique des objets distants> <nombre de noms> <port du registry>");
      System.exit(1);
    }
    // installation d'un securityManager
    // A COMPLETER : INSTALLATIOND'UN SECURITYMANAGER
	// Crée et installe un Security Manager, necessaire seulement si le code est téléchargé
	if(System.getSecurityManager() == null){
		System.setSecurityManager(new SecurityManager());
	}
    
    try {
    	LocateRegistry.createRegistry(2001);  
    	for(int i=1;i<=nombre;i++){
    		Supplier obj = new Supplier(nom, i);
    		java.rmi.Naming.bind("//localhost:2001/"+nom+i, obj);
    	}
    	System.out.println("Tous les objets sont enregistrés dans le serveur d'objets distants");
    } catch (Exception e) {
      System.out.println("Server err: " + e);
    }
  }
}
