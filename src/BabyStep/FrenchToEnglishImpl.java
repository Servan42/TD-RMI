package BabyStep;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class FrenchToEnglishImpl extends UnicastRemoteObject implements FrenchToEnglish {

	public FrenchToEnglishImpl() throws RemoteException {
		super();
	}
	
	@Override
	public String translate(String word) throws RemoteException {
		String result = "Monika";
		return result;
	}

}
