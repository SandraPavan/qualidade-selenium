package br.fib.dao;

import java.util.List;

import br.fib.service.Conta;

public interface Dao {

	public void salvaConta(Conta conta);

	public List<Conta> getContas();

	public void atualizaConta(Conta conta);

}
