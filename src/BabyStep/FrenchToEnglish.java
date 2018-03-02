package BabyStep;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface FrenchToEnglish extends Remote {
	// Translate the given word from french to english
	String translate(String word) throws RemoteException;
}
