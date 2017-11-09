package parades.mananciais.model;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class CalculadoraTest {
	Medicao medicao1, medicao2, medicao3, medicao4, medicao5, medicao6,
			medicao7, medicao8;
	ArrayList<Medicao> medicoes1, medicoes2;
	Calculadora calculadora;
	SimpleDateFormat sdf;
	Represa represa1, represa2;
	ArrayList<Represa> represas;
	Sistema sistema;

	@Before
	public void setUp() {
		calculadora = new Calculadora();

		sdf = new SimpleDateFormat("dd/mm/yyyy");

		try {
			medicao1 = new Medicao(100, sdf.parse("01/09/2016"));
			medicao2 = new Medicao(105, sdf.parse("03/09/2016"));
			medicao3 = new Medicao(100, sdf.parse("04/09/2016"));
			medicao4 = new Medicao(110, sdf.parse("05/09/2016"));
			medicao5 = new Medicao(107, sdf.parse("06/09/2016"));
			medicao6 = new Medicao(115, sdf.parse("10/09/2016"));
			medicao7 = new Medicao(120, sdf.parse("12/09/2016"));
			medicao8 = new Medicao(150, sdf.parse("19/09/2016"));

			medicoes1 = new ArrayList<Medicao>();
			medicoes1.add(medicao1);
			medicoes1.add(medicao2);
			medicoes1.add(medicao3);
			medicoes1.add(medicao4);
			medicoes1.add(medicao5);

			represa1 = new Represa("Represa A", medicoes1);

			medicoes2 = new ArrayList<Medicao>();

			medicoes2.add(medicao1);
			medicoes2.add(medicao2);
			medicoes2.add(medicao3);
			medicoes2.add(medicao4);
			medicoes2.add(medicao5);
			medicoes2.add(medicao6);
			medicoes2.add(medicao7);
			medicoes2.add(medicao8);

			represa2 = new Represa("Represa B", medicoes2);

			represas = new ArrayList<Represa>();
			represas.add(represa1);
			represas.add(represa2);

			sistema = new Sistema("Cantareira", represas);
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void test() {

		String retorno = "Relatorio do Sistema Cantareira\n\n\t"
				+ "Represa: Represa A\n"
				+ "      Data       Volume Variacao Diaria\n"
				+ "01/01/2016       100.00            0.00\n"
				+ "03/01/2016       105.00            5.00\n"
				+ "04/01/2016       100.00           -4.76\n"
				+ "05/01/2016       110.00           10.00\n"
				+ "06/01/2016       107.00           -2.73\n"
				+ "------------------------------------------------\n"
				+ "Variacao Total da Represa:         7.00\n\n\t"
				+ "Represa: Represa B\n"
				+ "      Data       Volume Variacao Diaria\n"
				+ "01/01/2016       100.00            0.00\n"
				+ "03/01/2016       105.00            5.00\n"
				+ "04/01/2016       100.00           -4.76\n"
				+ "05/01/2016       110.00           10.00\n"
				+ "06/01/2016       107.00           -2.73\n"
				+ "10/01/2016       115.00            7.48\n"
				+ "12/01/2016       120.00            4.35\n"
				+ "19/01/2016       150.00           25.00\n"
				+ "------------------------------------------------\n"
				+ "Variacao Total da Represa:        50.00\n\n"
				+ "------------------------------------------------\n"
				+ "Variacao Total do Sistema:        28.50\n\n";
		System.out.println(retorno);
		assertEquals("relatorio ",
				calculadora.gerarRelatorioMensal(sistema, null), retorno);

	}
	
	/*@Test
	public void calcularVariacaoTest(){
		assertEquals("variacao positiva", calculadora.calcularVariacao(medicao2, medicao1), 5.0, 0.01);
		assertEquals("variacao negativa", calculadora.calcularVariacao(medicao1, medicao2), -4.76, 0.01);
		assertEquals("variacao nula", calculadora.calcularVariacao(medicao2, medicao2), 0.0, 0.01);
	}*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
