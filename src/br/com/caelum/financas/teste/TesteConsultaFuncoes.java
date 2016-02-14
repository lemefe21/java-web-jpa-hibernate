package br.com.caelum.financas.teste;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteConsultaFuncoes {

	public static void main(String[] args) {

		EntityManager manager = new JPAUtil().getEntityManager();

		Conta conta = new Conta();
		conta.setId(1);

		TypedQuery<BigDecimal> typedQuery = manager.createQuery("select sum(m.valor) from Movimentacao m where m.conta = :pConta"
				+ " and m.tipoMovimentacao = :pTipo", BigDecimal.class);

		typedQuery.setParameter("pConta", conta);
		typedQuery.setParameter("pTipo", TipoMovimentacao.ENTRADA);

		//utilizando TypedQuery não é necessário cast para o retorno da consulta
		BigDecimal soma = typedQuery.getSingleResult();

		System.out.println("Soma: " + soma);

		manager.close();

	}

}
