package br.com.crud.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.crud.exception.NegocioException;
import br.com.crud.model.Usuario;

public class UsuarioDAO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public Usuario salvar(Usuario usuario) {
		return manager.merge(usuario);
		
	}
	
	public void excluir(Usuario usuario) {
		try {
			
			usuario = buscaPorId(usuario.getId());
			manager.remove(usuario);
			manager.flush();
			
		} catch (Exception e) {
			throw new NegocioException("O usuário não pode ser Excluido");
		}
	}
	
	public void alterar(Usuario usuario) {
		try {
			
			Usuario usuarioId = buscaPorEmail(usuario.getEmail());
			usuarioId.setSenha(usuario.getSenha());
			manager.merge(usuarioId);
			manager.flush();
			
		} catch (Exception e) {
			throw new NegocioException("O usuário não pode ser Alterado");
		}
	}
	
	public Usuario buscaPorId(Long id) {
		return manager.find(Usuario.class, id);
	}
	
	
	public Integer existeUsuario(String email) {
		
		try {
			System.out.println("----------------"); 
			System.out.println(email);
			Query query = manager.createNativeQuery("SELECT COUNT(*) FROM USUARIO WHERE email =:email");
			query.setParameter("email", email);
	        int resultCount = ((Number) query.getSingleResult()).intValue();
	        System.out.println("----------------"); 
	        System.out.println(resultCount);
			return resultCount;
	
		} catch (Exception e) {
			throw new NegocioException("Não foi possivel buscar o usuario");
		}
		
		

	}
	
	
	public Usuario buscaPorEmail(String email) {
		
		try {
			System.out.println("----------------"); 
			System.out.println(email);
			Query query = manager.createNativeQuery("SELECT * FROM USUARIO WHERE email =:email", Usuario.class);
			query.setParameter("email", email);
			Usuario usuarioEncontrado =  (Usuario) query.getSingleResult();
			System.out.println("-------busca por emaiil---------"); 
			System.out.println(usuarioEncontrado); 
			
			return usuarioEncontrado;
		} catch (Exception e) {
			throw new NegocioException("Usuario não existe");
		}
				
	}
	
	public List<Usuario> listAllUsuarios(){
		return manager.createNativeQuery("SELECT * FROM USUARIO", Usuario.class).getResultList();
	}

}
