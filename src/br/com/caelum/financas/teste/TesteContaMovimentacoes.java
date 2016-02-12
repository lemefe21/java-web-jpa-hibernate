package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteContaMovimentacoes {

	public static void main(String[] args) {

		EntityManager manager = new JPAUtil().getEntityManager();

		Conta conta = manager.find(Conta.class, 1); //select 1

		//quantidade de movimentacoes da conta id 1
		System.out.println(conta.getMovimentacoes().size()); //select 2

		manager.close();

		//se o manager estiver antes de pegar a qtd de moviemntação
		//é lançada LazyInitializationException
		//O Hibernate precisa do EntityManager aberto para inicializar
		//o relacionamento e executar o segundo select

	}

}
