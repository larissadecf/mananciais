package parades.mananciais.model;

import java.util.ArrayList;

public class Represa {
	public String nome;
	public ArrayList<Medicao> medicoes;
	public Represa() {
		this.nome = "";
		this.medicoes = new ArrayList<>();
	}
	public Represa(String nome, ArrayList<Medicao> medicoes) {
		this.nome = nome;
		this.medicoes = medicoes;
	}
	
	public double calcularVariacao(Medicao atual, Medicao anterior){
		if(anterior != null){
			return ((atual.getVolume()/anterior.getVolume())-1)*100;
		} else {
			return 0.0;
		}
	}
	
	public Medicao medicaoInicial(){
		return medicoes.get(0);
	}
	
	public Medicao medicaoFinal(){
		return medicoes.get(medicoes.size()-1);
	}
	
	public double calcularVariacaoTotal(){
		return calcularVariacao(medicaoFinal(), medicaoInicial());
	}

	@Override
	public String toString() {
		return "Represa [nome=" + nome + ", medicoes=" + medicoes + "]";
	}

	
}
