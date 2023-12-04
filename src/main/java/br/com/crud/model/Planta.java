package br.com.crud.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;


@Entity
public class Planta implements Serializable{

	private static final long serialVersionUID = 1L;
		
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	private String nome;
	@NotEmpty
	private String nome_cientifico;
	
	private String frequencia_rega;
	private String luminosidade;
	private Boolean toxidade;
	private String frequencia_poda;
	private String solo_fertilizacao;
	private String clima_temperatura;
	private String obs_experiencia;
	private String url_imagem;
	private Date dt_edicao;
	private Date dt_criacao;
	
	

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNome_cientifico() {
		return nome_cientifico;
	}
	public void setNome_cientifico(String nome_cientifico) {
		this.nome_cientifico = nome_cientifico;
	}
	public String getFrequencia_rega() {
		return frequencia_rega;
	}
	public void setFrequencia_rega(String frequencia_rega) {
		this.frequencia_rega = frequencia_rega;
	}
	public String getLuminosidade() {
		return luminosidade;
	}
	public void setLuminosidade(String luminosidade) {
		this.luminosidade = luminosidade;
	}
	public Boolean getToxidade() {
		return toxidade;
	}
	public void setToxidade(Boolean toxidade) {
		this.toxidade = toxidade;
	}
	public String getFrequencia_poda() {
		return frequencia_poda;
	}
	public void setFrequencia_poda(String frequencia_poda) {
		this.frequencia_poda = frequencia_poda;
	}
	public String getSolo_fertilizacao() {
		return solo_fertilizacao;
	}
	public void setSolo_fertilizacao(String solo_fertilizacao) {
		this.solo_fertilizacao = solo_fertilizacao;
	}
	public String getClima_temperatura() {
		return clima_temperatura;
	}
	public void setClima_temperatura(String clima_temperatura) {
		this.clima_temperatura = clima_temperatura;
	}
	public String getObs_experiencia() {
		return obs_experiencia;
	}
	public void setObs_experiencia(String obs_experiencia) {
		this.obs_experiencia = obs_experiencia;
	}
	
	public Date getDt_edicao() {
		return dt_edicao;
	}
	public void setDt_edicao(Date dt_edicao) {
		this.dt_edicao = dt_edicao;
	}
	public Date getDt_criaccao() {
		return dt_criacao;
	}
	public void setDt_criacao(Date dt_criacao) {
		this.dt_criacao = dt_criacao;
	}
	
	public String getUrl_imagem() {
		return url_imagem;
	}
	public void setUrl_imagem(String url_imagem) {
		this.url_imagem = url_imagem;
	}
	// Metodo para verificar se o registro é uma inclusão
	public boolean isInclusao() {
		return getId() == null ? true : false;
	}
	
	// Metodo para verificar se o registro é uma edição
	public boolean isEdicao() {
		return !isInclusao();
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Planta other = (Planta) obj;
		return Objects.equals(id, other.id);
	}
	@Override
	public String toString() {
		return "Planta [id=" + id + ", nome=" + nome + ", nome_cientifico=" + nome_cientifico + ", frequencia_rega="
				+ frequencia_rega + ", luminosidade=" + luminosidade + ", toxidade=" + toxidade + ", frequencia_poda="
				+ frequencia_poda + ", solo_fertilizacao=" + solo_fertilizacao + ", clima_temperatura="
				+ clima_temperatura + ", obs_experiencia=" + obs_experiencia + ", dt_edicao=" + dt_edicao
				+ ", dt_criacao=" + dt_criacao + "]";
	}
	

	
	

}
