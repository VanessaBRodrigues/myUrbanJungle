package br.com.crud.service;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import br.com.crud.dao.PlantaDAO;
import br.com.crud.model.Planta;
import br.com.crud.model.PlantaAdquirida;
import br.com.crud.util.Transacional;

public class PlantaService implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private PlantaDAO plantaDAO;	
	
	
	@Transacional
	public void salvar(Planta planta) {
		if (planta.isInclusao()) {
			planta.setDt_criacao(new Date());
		}
		
		if (planta.isEdicao()) {
			planta.setDt_edicao(new Date());
		}
		
		plantaDAO.salvar(planta);
	}
	
	
	
	@Transacional
	public void salvarPlantaAdquirida(PlantaAdquirida planta) {
		if (planta.isInclusao()) {
			planta.setDt_criacao(new Date());
		}
		
		if (planta.isEdicao()) {
			planta.setDt_edicao(new Date());
		}
		
		plantaDAO.salvarPllantaAdquirida(planta);
	}
	
	
	@Transacional
	public void excluir(Planta planta) {
		plantaDAO.excluir(planta);
	}
	
	@Transacional
	public void excluirColecao(PlantaAdquirida planta) {
		plantaDAO.excluirColecao(planta);
	}
	
	
	public List<Planta> listAll() {
		return plantaDAO.listAllPlanta();
	}
	
	public Planta porId(Long id) {
		return plantaDAO.buscaPorId(id);
	}
	
	public List<PlantaAdquirida> buscaColecaoPorUsuario(Long idUsuario) {
		return plantaDAO.buscaColecaoPorUsuario(idUsuario);
	}
	
	public PlantaAdquirida buscaPorIdColecao(Long id) {
		return plantaDAO.buscaPorIdColecao(id);
	}

}
