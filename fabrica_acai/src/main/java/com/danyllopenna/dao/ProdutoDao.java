package com.danyllopenna.dao;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.danyllopenna.dominio.Produto;
import com.danyllopenna.factory.conexao;

public class ProdutoDao {
	
	StringBuilder sql = new StringBuilder();
	Connection conecta = conexao.conectando();
	
	public void salvar(Produto p ) {
		sql.append("insert into produto");
		sql.append(" (tipoproduto,loteproduto,quantidadeproduto,valorproduto,vendedorproduto,datacompraproduto) ");
		sql.append("values(?,?,?,?,?,?)");
		
		try {
			PreparedStatement salvar = conecta.prepareStatement(sql.toString());
			salvar.setString(1,p.getTipo());
			salvar.setString(2,p.getLote());
			salvar.setDouble(3,p.getQuantidade());
			salvar.setDouble(4,p.getValor());
			salvar.setString(5,p.getVendedor());
			SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
			java.util.Date dataformatada = formato.parse(p.getDataCompra());
			java.sql.Date datano = new java.sql.Date(dataformatada.getTime());
			salvar.setDate(6,datano);
			salvar.executeUpdate();
			System.out.println("gravado com sucesso");			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Produto> listar()throws SQLException{
		sql.append("select * ");
		sql.append("from produto ");
		
		
			PreparedStatement listar = conecta.prepareStatement(sql.toString());
			ResultSet resultado = listar.executeQuery();
			ArrayList<Produto> lista = new ArrayList<Produto>();
			while(resultado.next()) {
				Produto p = new Produto();
				p.setIdproduto(resultado.getLong("idproduto"));
				p.setLote(resultado.getString("loteproduto"));
				p.setTipo(resultado.getString("tipoproduto"));
				p.setQuantidade(resultado.getDouble("quantidadeproduto"));
				p.setValor(resultado.getDouble("valorproduto"));
				p.setVendedor(resultado.getString("vendedorproduto"));
				
				// trazendo e formatando a data pra apresentação
				SimpleDateFormat data1 = new SimpleDateFormat("dd-MM-yyyy");
				String datanova = data1.format(resultado.getDate("datacompraproduto"));
				p.setDataCompra(datanova);
				
				lista.add(p);
			}
			
		return lista;
	}
	
	public static void main (String[] args) {
		/*	Produto p1 = new Produto();
			p1.setTipo("açai");
			p1.setLote("LTA0002");
			p1.setQuantidade(30.5);
			p1.setValor(100.10);
			p1.setVendedor("paragominas");
			p1.setDataCompra("12-10-2002");
			
			ProdutoDao dao = new ProdutoDao();
			dao.salvar(p1);
			
			
			*/
			
		
		ProdutoDao pdao = new ProdutoDao();
		try {
		ArrayList<Produto> lista = pdao.listar();
		for(Produto p : lista) {
			System.out.println("resultado: "+p);
			
		}
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	
	}
}


