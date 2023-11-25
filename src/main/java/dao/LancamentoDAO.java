package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import entidades.Lancamento;
import util.JPAUtil;

public class LancamentoDAO {

	public static void salvar(Lancamento lancamento) {
	    EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		em.persist(lancamento);
		em.getTransaction().commit();
		em.close();
	}
	
	public static List<Lancamento> buscarTodos(){
		EntityManager em = JPAUtil.criarEntityManager();
		Query query = em.createQuery("select l from Lancamento l");
		List<Lancamento> lista = query.getResultList();
		em.close();
		return lista;
	}

	public static void deletar(Lancamento lancamento){
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		lancamento = em.find(Lancamento.class, lancamento.getId());
		em.remove(lancamento);
		em.getTransaction().commit();
		em.close();
	}
	

	public static Lancamento buscarPorId(Integer id)throws Exception{
		EntityManager em = JPAUtil.criarEntityManager();
		Lancamento lancamento = em.find(Lancamento.class, id);
		em.close();
		return lancamento;
	}
}





