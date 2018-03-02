package BabyStep;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class FrenchToEnglishImpl extends UnicastRemoteObject implements FrenchToEnglish {

	public FrenchToEnglishImpl() throws RemoteException {
		super();
	}
	
	@Override
	public String translate(String word) throws RemoteException {
		String result;
		switch(word) {
		case "Monika": result = "Monique";
		case "Monique": result = "Monika";
		case "Tea": result = "Thé";
		case "Thé": result = "Tea";
		case "BDE": result = "FDP";
		case "FDP": result = "BDR";
		case "Nique": result = "le CROUS";
		case "Test": result = "AAAAAAH ERREUR ERREUR ABORT MISSION";
		case "Amina": result = "mina hé hé";
		case "Français": result = "English";
		case "English": result = "Français";
		default: result = "BIEN TENTE DUDE";
		}
		return result;
	}

}
