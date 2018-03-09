package TD;
import java.util.Random;

/**
 * @author morat 
 */
public class Customer extends Thread {
	private static String[] properties;
	private static int nbQuestion = 0;
	static{
		properties = System.getProperties().keySet().toArray(new String[] {});
		for(java.lang.reflect.Method m : ISupplier.class.getDeclaredMethods())
			if(m.getName().equals("question")) nbQuestion++;
	}
	
	String ou, qui, fullName; int num, client;
	private ISupplier obj;
	/**
	 * 
	 * @param ou désignation de la machine distante
	 * @param qui nom générique du Provider
	 * @param num numémo spécifique du Provider
	 * @param client numéro du C
	 */
	public  Customer(String ou, String qui, int num, int client) {
		this.ou=ou; this.qui=qui; this.num=num; this.client=client; this.fullName = "//" + ou + "/" + qui + num;
	}
	public void run(){
		try{
			synchronized (Customer.class){
				System.out.print(this + "->" + fullName);
				obj = (ISupplier) java.rmi.Naming.lookup(fullName);
				System.out.println(" est lié a " + obj.name());
			}
			try{sleep((int) (Math.random() * 1000));}catch(Exception e){}
			synchronized (Customer.class){
				switch(new Random().nextInt(nbQuestion)){
					case 0: { // cas de l'utilisation de question()
						System.out.println(this + "->" + obj.name() + ".question() = " + obj.question());
						break;
					}case 1: { // cas de l'utilisation de question(String)
						String s = select();
						System.out.println(this + "->" + obj.name() + ".question(" + s + ") = " + obj.question(s));
						break;
					}case 2: { // cas de l'utilisation de question(StringBuffer){
						Appendable d = new StringBuffer(select());
						System.out.print(this+"->"+obj.name() + ".question("+d+") = ");
						d = obj.question(d);
						System.out.println(d);
						break;
					}case 3 :{ // cas de l'utilisation de question(StringBuilder){
						StringBuilder d = new StringBuilder(select());
						System.out.println(this+"->"+obj.name()+".question("+d+") = "+obj.question(d).value());
						break;
					}default: {
						System.err.println(this + "->" + obj.name() + " question inconnue");
					}
				}
			}
		}catch(Throwable e){
			synchronized (Customer.class){
				System.out.println("Provider error: " + e);
			}
		}
	}
	public String toString()  {return "Customer"+client;}
	private String select() {return properties[(int)(Math.random()*properties.length)];}
}
