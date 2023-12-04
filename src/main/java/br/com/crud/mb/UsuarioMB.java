package br.com.crud.mb;

import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.crud.exception.NegocioException;
import br.com.crud.model.Usuario;
import br.com.crud.service.UsuarioService;
import br.com.crud.util.FacesUtil;

@Named
@ViewScoped
public class UsuarioMB implements Serializable {

	private static final long serialVersionUID = 1L;

	private Usuario usuario = new Usuario();

	@Inject
	private UsuarioService usuarioService;

	public String loginEfetuado() {
		Usuario usuarioLogado = new Usuario();
		Boolean senhaInvalida;
		System.out.println("--------------------------------");
		System.out.println(usuario.toString());
		usuarioLogado = usuarioService.usuarioExisteParaLogar(usuario);
		senhaInvalida = usuarioService.senhaInvalida(usuario.getSenha(), usuarioLogado.getSenha());
		System.out.println("AAAAAAAA");

		if (usuarioLogado != null && senhaInvalida == false) {

			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user",
					usuarioLogado.getEmail());
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("idUser", usuarioLogado.getId());

			return "index.xhtml?faces-redirect=true";

		} else {
			FacesUtil.addWarnMessage("Usuario não encontrado ou senha inválida");
			return "";
		}

	}

	public void salvar() {

		try {
			usuarioService.salvar(usuario);
		} catch (NegocioException e) {
			FacesUtil.addWarnMessage("Não foi possivel cadastrar o usuário");
		}

	}

	public void alterar() {

		try {
			usuarioService.alterar(usuario);

		} catch (Exception e) {
			FacesUtil.addWarnMessage("Não foi possivel a troca de senha.");
		}

	}

	/**
	 * GET and SET
	 * 
	 * @return
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
