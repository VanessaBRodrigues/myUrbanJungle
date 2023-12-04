package br.com.crud.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.crud.model.Planta;
import br.com.crud.service.PlantaService;
import br.com.crud.util.FacesUtil;

@Named
@ViewScoped
public class ListaPlantaMB implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private PlantaService plantaService;
	
	private List<Planta> plantas = new ArrayList<>();
	
	private List<Planta> plantaSelecionadas = new ArrayList<>();
	
	
	@PostConstruct
	public void inicializar() {
		plantas = plantaService.listAll();
	
	}
	
	public void excluirSelecionados() {
		for (Planta planta : plantaSelecionadas) {
			plantaService.excluir(planta);
			plantas.remove(planta);
		}
		
		FacesUtil.addInfoMessage("Planta(s) excluída(s) com sucesso!");
	}
	


	public List<Planta> getPlantas() {
		return plantas;
	}

	public void setPlantas(List<Planta> plantas) {
		this.plantas = plantas;
	}

	public List<Planta> getPlantaSelecionadas() {
		return plantaSelecionadas;
	}

	public void setPlantaSelecionadas(List<Planta> plantaSelecionadas) {
		this.plantaSelecionadas = plantaSelecionadas;
	}

	

}
