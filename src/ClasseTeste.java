
public class ClasseTeste {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ControlerPassageiro cp = new ControlerPassageiro();
		
		for(Passageiro p : cp.teste){
			cp.testarSeMorreu(p);
			 System.out.println(p.isMorreu());
		}
		
	}

}
