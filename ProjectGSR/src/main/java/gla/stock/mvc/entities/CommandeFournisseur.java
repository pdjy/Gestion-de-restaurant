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
public class CommandeFournisseur implements Serializable {

	@Id
	@GeneratedValue
	private Long idCommandeFournisseur;
	
	//@Temporal(TemporalType.TIMESTAMP)
	private String dateCommande;
	
	@ManyToOne
	@JoinColumn(name="idFournisseur")
	private Fournisseur fournisseur;
	
	@ManyToOne 
	@JoinColumn(name="id_article")
	private Article article;
	
	@ManyToOne 
	@JoinColumn(name="idMvtStk")
	private MvtStk mvtStk;
	
	@ManyToOne 
	@JoinColumn(name="idCategorie")
	private Categorie categorie;
	
	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	@OneToMany(mappedBy = "commandeFournisseur")
	private List<LigneCommandeFournisseur> ligneCommandeFournisseurs ;

	public Long getIdCommandeFournisseur() {
		return idCommandeFournisseur;
	}

	public void setIdCommandeFournisseur(Long id) {
		this.idCommandeFournisseur = id;
	}

	public String getDateCommande() {
		return dateCommande;
	}

	public void setDateCommande(String dateCommande) {
		this.dateCommande = dateCommande;
	}

	public Fournisseur getFournisseur() {
		return fournisseur;
	}

	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}

	public List<LigneCommandeFournisseur> getLigneCommandeFournisseurs() {
		return ligneCommandeFournisseurs;
	}

	public void setLigneCommandeFournisseurs(List<LigneCommandeFournisseur> ligneCommandeFournisseurs) {
		this.ligneCommandeFournisseurs = ligneCommandeFournisseurs;
	}

	public MvtStk getMvtStk() {
		return mvtStk;
	}

	public void setMvtStk(MvtStk mvtStk) {
		this.mvtStk = mvtStk;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
}
