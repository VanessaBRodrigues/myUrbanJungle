package br.com.crud.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;



@Entity(name="colecao")
public class PlantaAdquirida implements Serializable{

	private static final long serialVersionUID = 1L;
		
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long idUsuario;
	private Long idPlanta;
	
	@NotNull
	private String apelido;
	private double investimento;
	private Date dt_compra;
	private String loja_compra;
	
	private String ambiente;
	private Boolean fertilizacao;
	private Date dt_fertilizacao;
	
	private Boolean poda;
	private Date dt_poda;
	
	private Boolean defensivo;
	private Date dt_defensivo;
	
	private Date dt_edicao;
	private Date dt_criacao;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private StatusDesejo statusDesejo;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private StatusSaude statusSaude;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Long getIdPlanta() {
		return idPlanta;
	}

	public void setIdPlanta(Long idPlanta) {
		this.idPlanta = idPlanta;
	}

	public double getInvestimento() {
		return investimento;
	}

	public void setInvestimento(double investimento) {
		this.investimento = investimento;
	}

	public Date getDt_compra() {
		return dt_compra;
	}

	public void setDt_compra(Date dt_compra) {
		this.dt_compra = dt_compra;
	}

	public String getLoja_compra() {
		return loja_compra;
	}

	public void setLoja_compra(String loja_compra) {
		this.loja_compra = loja_compra;
	}

	public String getAmbiente() {
		return ambiente;
	}

	public void setAmbiente(String ambiente) {
		this.ambiente = ambiente;
	}

	public Boolean getFertilizacao() {
		return fertilizacao;
	}

	public void setFertilizacao(Boolean fertilizacao) {
		this.fertilizacao = fertilizacao;
	}

	public Date getDt_fertilizacao() {
		return dt_fertilizacao;
	}

	public void setDt_fertilizacao(Date dt_fertilizacao) {
		this.dt_fertilizacao = dt_fertilizacao;
	}

	public Boolean getPoda() {
		return poda;
	}

	public void setPoda(Boolean poda) {
		this.poda = poda;
	}

	public Date getDt_poda() {
		return dt_poda;
	}

	public void setDt_poda(Date dt_poda) {
		this.dt_poda = dt_poda;
	}

	public Boolean getDefensivo() {
		return defensivo;
	}

	public void setDefensivo(Boolean defensivo) {
		this.defensivo = defensivo;
	}

	public Date getDt_defensivo() {
		return dt_defensivo;
	}

	public void setDt_defensivo(Date dt_defensivo) {
		this.dt_defensivo = dt_defensivo;
	}

	public StatusDesejo getStatusDesejo() {
		return statusDesejo;
	}

	public void setStatusDesejo(StatusDesejo statusDesejo) {
		this.statusDesejo = statusDesejo;
	}

	public StatusSaude getStatusSaude() {
		return statusSaude;
	}

	public void setStatusSaude(StatusSaude statusSaude) {
		this.statusSaude = statusSaude;
	}
	

	public Date getDt_edicao() {
		return dt_edicao;
	}

	public void setDt_edicao(Date dt_edicao) {
		this.dt_edicao = dt_edicao;
	}

	public Date getDt_criacao() {
		return dt_criacao;
	}

	public void setDt_criacao(Date dt_criacao) {
		this.dt_criacao = dt_criacao;
	}
	
	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
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
		PlantaAdquirida other = (PlantaAdquirida) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "PlantaAdquirida [id=" + id + ", idUsuario=" + idUsuario + ", idPlanta=" + idPlanta + ", apelido="
				+ apelido + ", investimento=" + investimento + ", dt_compra=" + dt_compra + ", loja_compra="
				+ loja_compra + ", ambiente=" + ambiente + ", fertilizacao=" + fertilizacao + ", dt_fertilizacao="
				+ dt_fertilizacao + ", poda=" + poda + ", dt_poda=" + dt_poda + ", defensivo=" + defensivo
				+ ", dt_defensivo=" + dt_defensivo + ", dt_edicao=" + dt_edicao + ", dt_criacao=" + dt_criacao
				+ ", statusDesejo=" + statusDesejo + ", statusSaude=" + statusSaude + "]";
	}

	

}
