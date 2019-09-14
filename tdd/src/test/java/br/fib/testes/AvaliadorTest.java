package br.fib.testes;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.fib.builders.CriadorDeLeilao;
import br.fib.leilao.Avaliador;
import br.fib.modelo.Lance;
import br.fib.modelo.Leilao;
import br.fib.modelo.Usuario;

public class AvaliadorTest {
	private Avaliador leiloeiro;
	private Usuario joao;
	private Usuario jose;
	private Usuario maria;
	private Usuario antonio;

	@Before
	public void criaAvaliador() {
		this.leiloeiro = new Avaliador();
		this.joao = new Usuario("João");
		this.jose = new Usuario("José");
		this.maria = new Usuario("Maria");
		this.antonio = new Usuario("Antonio");
	}

	@Test
	public void deveRetornarOMaiorEMenorLance() {
		Leilao leilao = new CriadorDeLeilao().para("Playstation 3 Novo").lance(joao, 100.0).lance(maria, 200.0)
				.lance(jose, 300.0).lance(maria, 400.0).constroi();

		leiloeiro.avalia(leilao);

		// comparando a saida com o esperado
		assertEquals(400, leiloeiro.getMaiorLance(), 0.00001);
		assertEquals(100, leiloeiro.getMenorLance(), 0.00001);
	}

	@Test
	public void deveEntenderLancesEmOrdemCrescenteComOutrosValores() {

		Leilao leilao = new CriadorDeLeilao().para("Playstation 3 Novo").lance(joao, 1000.0).lance(maria, 2000.0)
				.lance(jose, 3000.0).lance(maria, 2500.0).constroi();

		leiloeiro.avalia(leilao);

		// comparando a saida com o esperado
		assertEquals(3000, leiloeiro.getMaiorLance(), 0.00001);
		assertEquals(1000, leiloeiro.getMenorLance(), 0.00001);
	}

	@Test
	public void deveEntenderLancesEmOrdemCrescente() {
		Leilao leilao = new CriadorDeLeilao().para("Playstation 3 Novo").lance(joao, 100.0).lance(maria, 200.0)
				.lance(jose, 300.0).lance(maria, 400.0).constroi();
		leiloeiro.avalia(leilao);

		// comparando a saida com o esperado
		assertEquals(400, leiloeiro.getMaiorLance(), 0.00001);
		assertEquals(100, leiloeiro.getMenorLance(), 0.00001);
	}

	@Test
	public void deveEntenderLancesEmOrdemDescrescente() {
		Leilao leilao = new CriadorDeLeilao().para("Playstation 3 Novo").lance(joao, 100.0).lance(maria, 200.0)
				.lance(jose, 300.0).lance(maria, 400.0).constroi();

		leiloeiro.avalia(leilao);

		// comparando a saida com o esperado
		assertEquals(400, leiloeiro.getMaiorLance(), 0.00001);
		assertEquals(100, leiloeiro.getMenorLance(), 0.00001);
	}

	@Test
	public void deveEntenderLancesComValoresIguais() {
		Leilao leilao = new CriadorDeLeilao().para("Playstation 3 Novo").lance(joao, 150.0).lance(maria, 200.0)
				.lance(jose, 150.0).lance(maria, 400.0).lance(antonio, 850.0).constroi();

		leiloeiro.avalia(leilao);

		// comparando a saida com o esperado
		assertEquals(850, leiloeiro.getMaiorLance(), 0.00001);
		assertEquals(150, leiloeiro.getMenorLance(), 0.00001);
	}

	@Test
	public void deveEntenderLancesSemOrdemEspecifica() {
		Leilao leilao = new CriadorDeLeilao().para("Playstation 3 Novo").lance(joao, 500.0).lance(jose, 150.0)
				.lance(maria, 850.0).lance(antonio, 200.0).constroi();

		leiloeiro.avalia(leilao);

		// comparando a saida com o esperado
		assertEquals(850, leiloeiro.getMaiorLance(), 0.00001);
		assertEquals(150, leiloeiro.getMenorLance(), 0.00001);
	}

	@Test
	public void deveEntenderLancesApenasUmValor() {
		Leilao leilao = new CriadorDeLeilao().para("Playstation 3 Novo").lance(joao, 500.0).constroi();

		leiloeiro.avalia(leilao);

		// comparando a saida com o esperado
		assertEquals(500, leiloeiro.getMaiorLance(), 0.00001);
		assertEquals(500, leiloeiro.getMenorLance(), 0.00001);
	}

	@Test
	public void deveEncontrarOsTresMaioresLances() {
		Leilao leilao = new CriadorDeLeilao().para("Playstation 3 Novo").lance(joao, 100.0).lance(jose, 300.0)
				.lance(maria, 200.0).lance(antonio, 400.0).constroi();

		leiloeiro.avalia(leilao);

		List<Lance> maiores = leiloeiro.getTresMaiores();

		assertEquals(3, maiores.size());
		assertEquals(400, maiores.get(0).getValor(), 0.00001);
		assertEquals(300, maiores.get(1).getValor(), 0.00001);
		assertEquals(200, maiores.get(2).getValor(), 0.00001);
	}

}
