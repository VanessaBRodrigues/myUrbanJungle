package br.com.crud.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.crud.dao.UsuarioDAO;
import br.com.crud.model.Usuario;
import br.com.crud.util.FacesUtil;
import br.com.crud.util.Transacional;

public class UsuarioService implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private UsuarioDAO usuarioDAO;	
	
	
	@Transacional
	public void salvar(Usuario usuario) {
		
		Integer usuarioExiste = usuarioDAO.existeUsuario(usuario.getEmail());
		
		if(usuarioExiste == 0) {
			usuarioDAO.salvar(usuario);
			FacesUtil.addInfoMessage("Usuario Salvo com sucesso");
		}else {
			FacesUtil.addWarnMessage("Usuario informado já existe");
		}
			
	}
	
	@Transacional
	public void excluir(Usuario usuario) {
		usuarioDAO.excluir(usuario);
	}
	

	@Transacional
	public void alterar(Usuario usuario) {
		
		Integer usuarioExiste = usuarioDAO.existeUsuario(usuario.getEmail());
		System.out.println(usuarioExiste);
		
		if(usuarioExiste > 0) {
			usuarioDAO.alterar(usuario);	
			FacesUtil.addInfoMessage("Senha alterada com sucesso");
		}else {
			FacesUtil.addWarnMessage("O email informado não existe");
		}
		
	}
	
	public Usuario usuarioExisteParaLogar(Usuario usuario) {
		System.out.println("----------------"); 
		System.out.println(usuario);  
		Usuario usuarioEncontrado = new Usuario();
		
		Integer usuarioExiste = usuarioDAO.existeUsuario(usuario.getEmail());
		
		System.out.println("----------------"); 
		System.out.println(usuarioExiste);  
		
		if(usuarioExiste == 0) {
			System.out.println("entoru no IF");
			return usuarioEncontrado;
		}else {
			System.out.println("----------------"); 
			System.out.println("ENTROU NO ELSE");   
			usuarioEncontrado = usuarioDAO.buscaPorEmail(usuario.getEmail());
			return usuarioEncontrado;
			
		}
		
					
	}
	
	public Boolean senhaInvalida(String senhaDgitada, String senhaEncontrada) {
		
		System.out.println("----------------"); 
		System.out.println(senhaDgitada);   
		System.out.println(senhaEncontrada);   
		if(!senhaDgitada.equals(senhaEncontrada)) {
			System.out.println("----------------"); 
			System.out.println("ENTROU NO iif da senha errada");   
			FacesUtil.addWarnMessage("Usuario e/ou senha estão incorretos");
			return true;
			
		}
		return false;
		
		
	}

	
	
	public List<Usuario> listAll() {
		return usuarioDAO.listAllUsuarios();
	}
	
	public Usuario buscaPorId(Long id) {
		return usuarioDAO.buscaPorId(id);
	}
	
	public Usuario buscaPorEmail(String email) {
		return usuarioDAO.buscaPorEmail(email);
	}

}
