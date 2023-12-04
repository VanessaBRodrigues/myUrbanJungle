package br.com.crud.util;

import javax.faces.context.FacesContext;

import br.com.crud.model.Usuario;

public class UsuarioUtil {

	public Usuario recuperaSessao() {
		Usuario usuarioNaSessao = new Usuario(); 
		
		String usuario = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user").toString();
		String id = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("idUser").toString();
		usuarioNaSessao.setEmail(usuario);  
		usuarioNaSessao.setId(Long.parseLong(id));  
		
		return usuarioNaSessao;
		
	}

}
