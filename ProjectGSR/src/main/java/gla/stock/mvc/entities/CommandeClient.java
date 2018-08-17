package gla.stock.mvc.entities;

import java.io.Serializable;
import java.math.BigDecimal;
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
public class CommandeClient implements Serializable {

	@Id
	@GeneratedValue
	private Long idCommandeClient;
	
	private String code;
	
	//@Temporal(TemporalType.TIMESTAMP)
	private String dateCommande;
	
	private BigDecimal prixTotal;
	
	@ManyToOne 
	@JoinColumn(name="id_article")
	private Article article;
	
	@ManyToOne 
	@JoinColumn(name="idMvtStk")
	private MvtStk mvtStk;
	
	@ManyToOne 
	@JoinColumn(name="idCategorie")
	private Categorie categorie;
	
	@ManyToOne
	@JoinColumn(name="idClient")
	private Client client;
	
	@OneToMany(mappedBy = "commandeClient")
	private List<LigneCommandeClient> ligneCommandeClients;
	
	

	public Long getIdCommandeClient() {
		return idCommandeClient;
	}

	public void setIdCommandeClient(Long id) {
		this.idCommandeClient = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDateCommande() {
		return dateCommande;
	}

	public void setDateCommande(String dateCommande) {
		this.dateCommande = dateCommande;
	}

	public BigDecimal getPrixTotal() {
		return prixTotal;
	}

	public void setPrixTotal(BigDecimal prixTotal) {
		this.prixTotal = prixTotal;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<LigneCommandeClient> getLigneCommandeClients() {
		return ligneCommandeClients;
	}

	public void setLigneCommandeClients(List<LigneCommandeClient> ligneCommandeClients) {
		this.ligneCommandeClients = ligneCommandeClients;
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

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
}
