package br.com.crud.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.crud.exception.NegocioException;
import br.com.crud.model.Planta;
import br.com.crud.model.PlantaAdquirida;

public class PlantaDAO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public Planta salvar(Planta planta) {
		return manager.merge(planta);
		
	}
	
	public void excluir(Planta planta) {
		try {
			
			planta = buscaPorId(planta.getId());
			manager.remove(planta);
			manager.flush();
			
		} catch (Exception e) {
			throw new NegocioException("A Planta não pode seer excluida");
		}
	}
	
	public Planta buscaPorId(Long id) {
		return manager.find(Planta.class, id);
	}
	
	public List<Planta> listAllPlanta(){
		return manager.createNativeQuery("SELECT * FROM PLANTA", Planta.class).getResultList();
	}
	
	
	public PlantaAdquirida buscaPorIdColecao(Long id) {
		return manager.find(PlantaAdquirida.class, id);
	}
	
	public PlantaAdquirida salvarPllantaAdquirida(PlantaAdquirida planta) {
		return manager.merge(planta);
		
	}
	
	public void excluirColecao(PlantaAdquirida planta) {
		try {
			
			planta = buscaPorIdColecao(planta.getId());
			manager.remove(planta);
			manager.flush();
			
		} catch (Exception e) {
			throw new NegocioException("A Planta não pode seer excluida");
		}
	}
	
	public List<PlantaAdquirida> buscaColecaoPorUsuario(Long idUsuario) {
		
		try {
			System.out.println("-------------------------------------");
					System.out.println(idUsuario);

					
			Query query = manager.createNativeQuery("SELECT * FROM colecao WHERE idUsuario =:idUsuario", PlantaAdquirida.class);
			query.setParameter("idUsuario", idUsuario);
			List<PlantaAdquirida> colecaoEncontrada = query.getResultList();
			
			return colecaoEncontrada; 
			
		} catch (Exception e) {
			throw new NegocioException("Colecao não encontrada");
		}
				
	}

}
