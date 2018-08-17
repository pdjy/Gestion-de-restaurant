package gla.stock.mvc.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Vente implements Serializable {

	@Id
	@GeneratedValue
	private Long idVente;

	private String code;
	
	private String dateVente;
	
	@OneToMany(mappedBy = "vente")
	private List<LigneVente> ligneVentes;
	
	@ManyToOne 
	@JoinColumn(name="id_article")
	private Article article;
	
	@ManyToOne 
	@JoinColumn(name="idMvtStk")
	private MvtStk mvtStk;
	
	public Long getIdVente() {
		return idVente;
	}

	public void setIdVente(Long id) {
		this.idVente = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDateVente() {
		return dateVente;
	}

	public void setDateVente(String dateVente) {
		this.dateVente = dateVente;
	}

	public List<LigneVente> getLigneVentes() {
		return ligneVentes;
	}

	public void setLigneVentes(List<LigneVente> ligneVentes) {
		this.ligneVentes = ligneVentes;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public MvtStk getMvtStk() {
		return mvtStk;
	}

	public void setMvtStk(MvtStk mvtStk) {
		this.mvtStk = mvtStk;
	}
}
