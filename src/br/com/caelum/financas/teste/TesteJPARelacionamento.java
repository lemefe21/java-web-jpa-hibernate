package br.com.caelum.financas.teste;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteJPARelacionamento {

	public static void main(String[] args) {

		double inicio = System.currentTimeMillis();

		Conta conta = new Conta("Felipe", "123457", "Banco Real", "9999-1");

		Movimentacao movimentacao = new Movimentacao(new BigDecimal("120.9"),
				TipoMovimentacao.SAIDA, Calendar.getInstance(), "Conta de luz", conta);

		EntityManager manager = new JPAUtil().getEntityManager();

		manager.getTransaction().begin();

		//conta ainda está transient
		manager.persist(conta);
		manager.persist(movimentacao);

		manager.getTransaction().commit();
		manager.close();

		double fim = System.currentTimeMillis();
		System.out.println("Execução em: " + (fim - inicio)/1000 + " segundos.");

	}

}
