package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteContaMovimentacoesQueryId {

	public static void main(String[] args) {

		EntityManager manager = new JPAUtil().getEntityManager();

		//quantidade de movimentacoes da conta id 1
		Query query = manager.createQuery("select c from Conta c join fetch c.movimentacoes where c.id = :pId ");
		query.setParameter("pId", 1);

		Conta conta = (Conta) query.getSingleResult();

		manager.close();

		System.out.println(conta.getMovimentacoes().size());
		//query planejada evita o LazyInitializationException fechando o EntityManager
		//antes de buscar as movimentação da conta

	}

}
