package br.fib.database;

import java.util.ArrayList;
import java.util.List;

import br.fib.models.Usuario;
import br.fib.service.Conta;

//git
public class ContaBuilder {
	private List<Conta> contas;

	public ContaBuilder() {
		contas = new ArrayList<Conta>();
	}

	public ContaBuilder addConta(Conta conta, Usuario usuario) {
		conta.setUsuario(usuario);
		this.contas.add(conta);
		return this;
	}

	public List<Conta> constroi() {
		return this.contas;
	}
}
