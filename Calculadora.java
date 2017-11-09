package parades.mananciais.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Calculadora {
	DateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
	

	public String gerarRelatorioMensal(Sistema sistema, Date mesAno){
		Medicao atual, anterior;
		
		String relatorio = "Relatorio do Sistema " + sistema.getNome() + "\n\n";
		for(Represa represa:sistema.getRepresas()){
			relatorio += "\tRepresa: " + represa.nome + "\n";
			relatorio += String.format("%10s %12s %15s","Data", "Volume", "Variacao Diaria\n");
			anterior = null;
			for(Medicao medicao:represa.medicoes){
				atual = medicao;
				relatorio += String.format("%10s %12.2f %15.2f",formater.format(medicao.getData()),
						medicao.getVolume(),represa.calcularVariacao(atual, anterior));
				relatorio += "\n";
				anterior = atual;
			}
			
			// calculando a variacao por Represa.
			relatorio += "------------------------------------------------";
			relatorio += "\nVariacao Total da Represa: " + String.format("%12.2f",represa.calcularVariacaoTotal());
			relatorio += "\n\n";
		} 
		
		// calculando variacao total por Sistema.
		relatorio += "------------------------------------------------";
		relatorio += "\nVariacao Total do Sistema: " + String.format("%12.2f",sistema.variacaoTotalDoSistema());
		relatorio += "\n\n";
		System.out.println(relatorio);
		return relatorio;
	}
	
}
	
