import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;


public class ControlerPassageiro {

	// declaração das variáveis  
	public List<Passageiro> treinamento; //criação da lista treinamento que eh do tipo passageiro
	public List<Passageiro> teste; //criação da lista teste que eh do tipo passageiro
	private int k = 3; // tamanho máximo 
	private String nomeArquivoTreinamento = "treinamento.csv"; //variável para importar o arquivo csv
	private String nomeArquivoTeste = "teste.csv"; //variável para importar o arquivo csv
	
	
	//ler as duas listas
	public ControlerPassageiro(){
		treinamento = lerLista(nomeArquivoTreinamento);
		teste = lerLista(nomeArquivoTeste);
	}
	
	// metódo utilizado para classificar se o passageiro em uma determinada posição foi morto ou sobreviveu
	public void testarSeMorreu(Passageiro p){
		
		List<Tupla> maisProximos = new ArrayList<Tupla>(k);
		
		for(Passageiro classificado : treinamento){
			Tupla newT = new Tupla(classificado, p);
			maisProximos.add(newT);
			if(maisProximos.size() == k){
				break;
			}
		}
		
		// esse for é feito para pegar os k(passageiros) mais proximos de acordo com o algoritmo 
		for(Passageiro classificado : treinamento){
			Tupla newT = new Tupla(classificado, p);
			Collections.sort(maisProximos);
			
			Tupla maisDistante = maisProximos.get(0);// ver se o mas distante vai ficar no inicio ou no fim K
			
			if(maisDistante.getDistancia() > newT.getDistancia()){
				maisProximos.remove(maisDistante);
				maisProximos.add(newT);
			}	
		}
		
		int quantidadeMortos = 0 , quantidadeVivo = 0;
		for(Tupla t : maisProximos){
			if(t.getClassificado().isMorreu()){
				quantidadeMortos++;
			}else{
				quantidadeVivo++;
			}
		}
		
		p.setMorreu(quantidadeMortos > quantidadeVivo);
		
	}
	
	
	public List<Passageiro> lerLista(String nomeArquivo){
		List<StringTokenizer> toks = lerArquivo(nomeArquivo);
		List<Passageiro> treinamento = new ArrayList<>();
		
		for(StringTokenizer t : toks){
			
			Passageiro p = new Passageiro();
			if(nomeArquivo.equals(this.nomeArquivoTreinamento)){
				//preenchendo o arquivo
				if(t.nextToken().equalsIgnoreCase("0")){   // morreu
					p.setMorreu(true);
				}else{
					p.setMorreu(false);
				}
			}
			
			
			p.setPclass(Double.valueOf(t.nextToken()));
			
			p.setNome(t.nextToken()+", "+t.nextToken());
			
			p.setSexo(t.nextToken());
			
			
			p.setIdade(Double.valueOf(t.nextToken()));
			
			treinamento.add(p);
			
		}
		return treinamento;
		
	}
	
	private List<StringTokenizer> lerArquivo(String nomeArquivo) {  
	        String linha = null;  
	        List<StringTokenizer> tok = new ArrayList<StringTokenizer>();
	        try {  
	            // instancia do arquivo que vou ler  
	            FileReader reader = new FileReader(nomeArquivo);  
	            BufferedReader leitor = new BufferedReader(reader);  
	  
	            boolean descartadoOPrimeiro = false;
	            // loop que percorrer todas as  linhas do arquivo.txt que eu quero ler  
	            while ((linha = leitor.readLine()) != null) {  
	            	
	                      //No metodo StringTokenizer passo os parametros que quero ler, em seguida o que eu quero descartar no meu caso (,).   
	                StringTokenizer st = new StringTokenizer(linha, "," );  
	                    // Aqui determino que enquanto existir tokens que ele fara a leitura  
	                if(!descartadoOPrimeiro){
	                	descartadoOPrimeiro = true;
	                	continue;
	                }else{
	                	tok.add(st);
	                }
	            }  
	  
	            leitor.close();  
	            reader.close();  
	            return tok;
	        } catch (Exception e) {  
	            e.printStackTrace();  
	  
	        }
			return null;  
	    }
	
	
}
