package TD;

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Supplier extends UnicastRemoteObject implements ISupplier {
	static final long serialVersionUID=42;
	private int id;
	private String nom;

	public Supplier(String nom, int id) throws RemoteException {
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

	@Override
	public void question(Appendable s) throws RemoteException{
		System.out.println("calling question(Appendable)");
		try {
			s.append(question(s.toString()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public IProperty question(StringBuilder s) throws RemoteException{
		System.out.println("calling question(StringBuilder)");
		return new Property(System.getProperty(s.toString()));
	}
}
