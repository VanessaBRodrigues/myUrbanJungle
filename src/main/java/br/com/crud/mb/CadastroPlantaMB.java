package br.com.crud.mb;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.crud.model.Planta;
import br.com.crud.service.PlantaService;

@Named
@ViewScoped
public class CadastroPlantaMB implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Planta planta = new Planta();
	
	private Long idPlanta;
	
	@Inject
	private PlantaService plantaService;
	
	
	public void inicializar() {
		if (idPlanta != null) {
			planta = plantaService.porId(idPlanta);
		}
	}
	
	
	public String salvar() {
		plantaService.salvar(planta);
		return "lista-plantas.xhtml?faces-redirect=true";
	}
	
	public String excluir() {
		plantaService.excluir(planta);
		return "lista-plantas.xhtml?faces-redirect=true";
	}


	public Planta getPlanta() {
		return planta;
	}


	public void setPlanta(Planta planta) {
		this.planta = planta;
	}


	public Long getIdPlanta() {
		return idPlanta;
	}


	public void setIdPlanta(Long idPlanta) {
		this.idPlanta = idPlanta;
	}


	

}
