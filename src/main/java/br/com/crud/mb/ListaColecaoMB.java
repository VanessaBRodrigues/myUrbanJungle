package br.com.crud.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.crud.model.Planta;
import br.com.crud.model.PlantaAdquirida;
import br.com.crud.model.Usuario;
import br.com.crud.service.PlantaService;
import br.com.crud.util.FacesUtil;
import br.com.crud.util.UsuarioUtil;

@Named
@ViewScoped
public class ListaColecaoMB implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private PlantaService plantaService;
	
	private List<PlantaAdquirida> exibeColecao = new ArrayList<>();
	
	private List<PlantaAdquirida> plantaSelecionadas = new ArrayList<>();
	
	private Planta plantaOrginalSelecionada = new Planta();
	
	@PostConstruct
	public void inicializar() {
		
		UsuarioUtil usuarioUtil = new UsuarioUtil();
		Usuario usuarioLogado = usuarioUtil.recuperaSessao();
		exibeColecao = plantaService.buscaColecaoPorUsuario(usuarioLogado.getId());
	
	}
	
	public void excluirSelecionados() {
		for (PlantaAdquirida  planta : plantaSelecionadas) {
			plantaService.excluirColecao(planta);
			exibeColecao.remove(planta);
		}
		
		FacesUtil.addInfoMessage("Planta(s) excluída(s) com sucesso!");
	}
	
	public void mostrarSelecionados() {
	    FacesContext fc = FacesContext.getCurrentInstance();
	    Map<String,String> params = fc.getExternalContext().getRequestParameterMap();
	    String colecaoIddString =  params.get("colecaoId"); 
	    long colecaoId = Long.parseLong(colecaoIddString);
	    plantaOrginalSelecionada = plantaService.porId(colecaoId);
	    System.out.println("------");  
	    System.out.println(colecaoId);  
	    System.out.println("------");  
	    System.out.println(plantaOrginalSelecionada.toString());  
		
	}
	

	public List<PlantaAdquirida> getExibeColecao() {
		return exibeColecao;
	}

	public void setExibeColecao(List<PlantaAdquirida> exibeColecao) {
		this.exibeColecao = exibeColecao;
	}

	public List<PlantaAdquirida> getPlantaSelecionadas() {
		return plantaSelecionadas;
	}

	public void setPlantaSelecionadas(List<PlantaAdquirida> plantaSelecionadas) {
		this.plantaSelecionadas = plantaSelecionadas;
	}

	public Planta getPlantaOrginalSelecionada() {
		return plantaOrginalSelecionada;
	}

	public void setPlantaOrginalSelecionada(Planta plantaOrginalSelecionada) {
		this.plantaOrginalSelecionada = plantaOrginalSelecionada;
	}


	

}
