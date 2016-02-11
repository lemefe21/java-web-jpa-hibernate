package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteJPAMerge {

	public static void main(String[] args) {

		double inicio = System.currentTimeMillis();

		Conta conta = new Conta("Felipe", "1212", "Banco Ultra", "9988-1");
		conta.setId(2);

		EntityManager manager = new JPAUtil().getEntityManager();

		manager.getTransaction().begin(); //cuida da transacao

		//quando o objeto já foi managed e agora é detached (id=2)
		//para voltar a ser managed, utilizamos o método merge
		//JPA executa > select > update
		manager.merge(conta);

		manager.getTransaction().commit();
		manager.close();

		double fim = System.currentTimeMillis();
		System.out.println("Execução em: " + (fim - inicio)/1000 + " segundos.");

	}

}
