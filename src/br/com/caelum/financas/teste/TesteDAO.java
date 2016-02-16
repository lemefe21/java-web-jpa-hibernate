package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.MovimentacaoDAO;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteDAO {

	public static void main(String[] args) {

		EntityManager manager = new JPAUtil().getEntityManager();

		Conta conta = new Conta();
		conta.setId(1);

		MovimentacaoDAO dao = new MovimentacaoDAO(manager);
		Double media = dao.mediaDaContaPeloTipo(conta, TipoMovimentacao.ENTRADA);

		System.out.println("Média: " + media);

		manager.close();

	}

}
