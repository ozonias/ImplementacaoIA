
public class Passageiro {

	// declara��o de vari�veis
	private String n;
	private double id;
	private double pclass;
	private String sexo;
	private boolean morreu;
	
	
	public String getNome() {
		return n;
	}
	
	public void setNome(String nome) {
		this.n = nome;
	}
	
	public double getIdade() {
		return id;
	}
	
	public void setIdade(double idade) {
		this.id = idade;
	}
	
	public double getPclass() {
		return pclass;
	}
	
	public void setPclass(double pclass) {
		this.pclass = pclass;
	}
	
	public boolean isMorreu() {
		return morreu;
	}

	public void setMorreu(boolean morreu) {
		this.morreu = morreu;
	}

	public boolean getMorreu() {
		return this.morreu ;
	}
	
	
	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public double distanciaPara(Passageiro p){
		double difIdade = p.id - id;
		if(difIdade < 0){
			difIdade = difIdade *-1.0;
		}
		
		double difPclass = p.pclass - pclass;
		if(difPclass < 0){
			difPclass = difPclass *-1.0;
		}
		return difIdade + difPclass;
	}
		

}
