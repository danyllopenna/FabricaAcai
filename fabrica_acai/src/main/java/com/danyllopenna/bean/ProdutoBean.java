package com.danyllopenna.bean;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.ListDataModel;


import com.danyllopenna.dao.ProdutoDao;
import com.danyllopenna.dominio.Produto;

@ManagedBean(name = "MBProduto")
@ViewScoped

public class ProdutoBean {
	
	private ListDataModel<Produto> itens;

	public ListDataModel<Produto> getItens() {
		return itens;
	}

	public void setItens(ListDataModel<Produto> itens) {
		this.itens = itens;
	}
		
	@PostConstruct
	
	public void prepararPesquisa() {
		try {
			ProdutoDao dao = new ProdutoDao();
			ArrayList<Produto> listo = dao.listar();
			itens = new ListDataModel<Produto>(listo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	

}
