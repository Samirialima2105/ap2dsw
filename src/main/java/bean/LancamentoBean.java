package bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import dao.LancamentoDAO;
import entidades.Lancamento;


@ManagedBean
public class LancamentoBean {
	
	private Lancamento lancamento = new Lancamento();
	private List<Lancamento> listaLancamento;
	private Lancamento messageLancamento;
	
	
	public String salvar() {
		LancamentoDAO.salvar(lancamento);
//			String texto = lancamento.toString();
//			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, " Info =>", texto));
		return null;
	}
	
	public List<Lancamento> buscarTodos(){
	    listaLancamento = LancamentoDAO.buscarTodos();
	    return listaLancamento;
	}
	
	public String deletar() {
	    LancamentoDAO.deletar(lancamento);
	    return null;
	}
	 	
	public void infoItem(Lancamento lancamento){
		String texto = lancamento.toString();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, " Info =>", texto));
	    		
	}

	public Lancamento getLancamento() {
		return lancamento;
	}

	public void setLancamento(Lancamento lancamento) {
		this.lancamento = lancamento;
	}

	public List<Lancamento> getListaLancamento() {
//		if(listaLancamento==null) {
//		listaLancamento = LancamentoDAO.buscarTodos();
//		} else {
//			listaLancamento = listaLancamento;
//		}
		listaLancamento = (listaLancamento==null) ? LancamentoDAO.buscarTodos(): listaLancamento;
		return listaLancamento;
	}

	public void setListaLancamento(List<Lancamento> listaLancamento) {
		this.listaLancamento = listaLancamento;
	}

	public Lancamento getMessageLancamento() {
		return messageLancamento;
	}

	public void setMessageLancamento(Lancamento messageLancamento) {
		this.messageLancamento = messageLancamento;
	}    
	
	
}
