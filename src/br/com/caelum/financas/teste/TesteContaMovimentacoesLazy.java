package br.com.caelum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteContaMovimentacoesLazy {

	public static void main(String[] args) {

		EntityManager manager = new JPAUtil().getEntityManager();

		//Conta conta = manager.find(Conta.class, 1);
		//System.out.println(conta.getMovimentacoes().size());

		Query query = manager.createQuery("select c from Conta c join fetch c.movimentacoes");
		//fetch torna o comportamento EAGER, n�o retorna todos os dados, somente os que s�o demandados
		List<Conta>contas = query.getResultList();

		//N (objetos retornados) + 1  = qtd de consultas
		//todo comportamento toMany assumem um comportamento LAZY (pregui�oso)
		for (Conta conta : contas) {
			System.out.println("N�mero de movimenta��es da conta " + conta.getId() + ": " + conta.getMovimentacoes().size());
		}

		manager.close();

	}

}
