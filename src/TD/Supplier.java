package TD;

import java.rmi.RemoteException;

public class Supplier implements ISupplier {
	private int id;
	private String nom;

	public Supplier(String nom, int id) {
		this.nom = nom;
		this.id = id;
	}
	
	@Override
	public String question() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println(toString()+" question");
		return System.getProperty("os");
	}

	@Override
	public String question(String s) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println(toString()+" question("+s+")");
		return System.getProperty(s);
	}

	@Override
	public String name() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println(toString()+" name");
		return toString();
	}
	
	public String toString() {
		return nom+id;
	}

}
