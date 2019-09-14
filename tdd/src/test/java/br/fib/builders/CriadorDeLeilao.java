package br.fib.builders;

import br.fib.modelo.Lance;
import br.fib.modelo.Leilao;
import br.fib.modelo.Usuario;

public class CriadorDeLeilao {
	private Leilao leilao;

	public CriadorDeLeilao() {
	}

	public CriadorDeLeilao para(String descricao) {
		this.leilao = new Leilao(descricao);
		return this;
	}

	public CriadorDeLeilao lance(Usuario usuario, double valor) {
		leilao.propoe(new Lance(usuario, valor));
		return this;
	}

	public Leilao constroi() {
		return leilao;
	}
}
