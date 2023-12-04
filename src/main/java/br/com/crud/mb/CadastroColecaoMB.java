package br.com.crud.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.crud.model.Planta;
import br.com.crud.model.PlantaAdquirida;
import br.com.crud.model.StatusDesejo;
import br.com.crud.model.StatusSaude;
import br.com.crud.model.Usuario;
import br.com.crud.service.PlantaService;
import br.com.crud.util.FacesUtil;
import br.com.crud.util.UsuarioUtil;

@Named
@ViewScoped
public class CadastroColecaoMB implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Planta planta = new Planta();
	private List<Planta> plantas = new ArrayList<>();
	private List<Planta> plantaEncontrada = new ArrayList<>();
	
	private PlantaAdquirida plantaAdquirida = new PlantaAdquirida();
	
	private Long idObjeto;
	private String nomeObjeto;
	
	@Inject
	private PlantaService plantaService;
	
	
	@PostConstruct
	public void inicializar() {
		System.out.println("chamou");
		plantas = plantaService.listAll();
	
	}
	
	public void inicializarCadastro() {
		
		if (nomeObjeto.equalsIgnoreCase("planta")) {
			planta = plantaService.porId(idObjeto);
			
		} else {
			if (idObjeto != null) {
				plantaAdquirida = plantaService.buscaPorIdColecao(idObjeto);
				planta = plantaService.porId(plantaAdquirida.getIdPlanta());
				
			}
		}
	}
	
	

	
	public String salvar() {
		UsuarioUtil usuarioUtil = new UsuarioUtil();
		Usuario usuarioLogado = usuarioUtil.recuperaSessao();
		
		if(usuarioLogado == null) {
			return "login.xhtml?faces-redirect=true";
			
		}else {
			plantaAdquirida.setIdPlanta(planta.getId()); 
			plantaAdquirida.setIdUsuario(usuarioLogado.getId());     
			plantaService.salvarPlantaAdquirida(plantaAdquirida);
			return "lista-colecao.xhtml?faces-redirect=true";
		}
	
		
	}
	

	public String excluir() {
		plantaService.excluirColecao(plantaAdquirida);
		return "lista-colecao.xhtml?faces-redirect=true";
	}
	
	

	
	
	public StatusSaude[] getStatusSaude() {
	        return StatusSaude.values();
	}
	
	public StatusDesejo[] getStatusDesejo() {
        return StatusDesejo.values();
}

	public Planta getPlanta() {
		return planta;
	}

	public void setPlanta(Planta planta) {
		this.planta = planta;
	}
	public List<Planta> getPlantas() {
		return plantas;
	}

	public void setPlantas(List<Planta> plantas) {
		this.plantas = plantas;
	}

	public List<Planta> getPlantaEncontrada() {
		return plantaEncontrada;
	}

	public void setPlantaEncontrada(List<Planta> plantaEncontrada) {
		this.plantaEncontrada = plantaEncontrada;
	}


	public PlantaAdquirida getPlantaAdquirida() {
		return plantaAdquirida;
	}

	public void setPlantaAdquirida(PlantaAdquirida plantaAdquirida) {
		this.plantaAdquirida = plantaAdquirida;
	}

	public Long getIdObjeto() {
		return idObjeto;
	}

	public void setIdObjeto(Long idObjeto) {
		this.idObjeto = idObjeto;
	}

	public String getNomeObjeto() {
		return nomeObjeto;
	}

	public void setNomeObjeto(String nomeObjeto) {
		this.nomeObjeto = nomeObjeto;
	}

	

}
