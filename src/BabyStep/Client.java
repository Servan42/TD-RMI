package BabyStep;

public class Client {
	public static void main(String args[]){
		// Crée et installe un Security Manager, necessaire seulement si le code est téléchargé
//		if(System.getSecurityManager() == null){
//			System.setSecurityManager(new SecurityManager());
//		}
		try{
			// Si rmiregistery ne tourne pas sur la machine courante, il faut
			// remplacer localhost par le nom de la machine qui héberge le rmiregisteri
			FrenchToEnglish obj = (FrenchToEnglish) java.rmi.Naming.lookup("//localhost:2001/FrenchToEnglishTranslator");
			String word = obj.translate((args.length>0)?args[0]:"Monika");
			System.out.println(word);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
