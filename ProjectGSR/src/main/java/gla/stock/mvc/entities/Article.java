package gla.stock.mvc.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="article")
public class Article implements Serializable {

	@Id
	@GeneratedValue
	@Column(name="id_article")
	private Long idArticle;
	
	private String codeArticle;
	
	private String designation;
	
	private BigDecimal prixUnitaireHT;
	
	private BigDecimal tauxTVA;
	
	private BigDecimal prixUnitaireTTC;
	
	private String photo;
	
	@ManyToOne //Plusieurs articles dans une categorie
	@JoinColumn(name="idCategorie")
	private Categorie categorie; //Un article appartient à une Categorie
	
	@ManyToOne //Plusieurs articles dans un stock
	@JoinColumn(name="idMvtStk")
	private MvtStk mvtStk; //Un article appartient à un stock
	
	@ManyToOne //Plusieurs articles dans une vente
	@JoinColumn(name="idVente")
	private Vente vente; //Un article appartient à une vente
	
	@ManyToOne //Plusieurs articles dans une commande client
	@JoinColumn(name="idCommandeClient")
	private CommandeClient commandeClient; //Un article appartient à une commande client
	
	@ManyToOne //Plusieurs articles dans une commande client
	@JoinColumn(name="idCommandeFournisseur")
	private CommandeFournisseur commandeFournisseur; //Un article appartient à une commande client
		
	//Constructeur par defaut
	public Article() {
	}

	public Long getIdArticle() {
		return idArticle;
	}

	public void setIdArticle(Long id) {
		this.idArticle = id;
	}

	public String getCodeArticle() {
		return codeArticle;
	}

	public void setCodeArticle(String codeArticle) {
		this.codeArticle = codeArticle;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public BigDecimal getPrixUnitaireHT() {
		return prixUnitaireHT;
	}

	public void setPrixUnitaireHT(BigDecimal prixUnitaireHT) {
		this.prixUnitaireHT = prixUnitaireHT;
	}

	public BigDecimal getTauxTVA() {
		return tauxTVA;
	}

	public void setTauxTVA(BigDecimal tauxTVA) {
		this.tauxTVA = tauxTVA;
	}

	public BigDecimal getPrixUnitaireTTC() {
		return prixUnitaireTTC;
	}

	public void setPrixUnitaireTTC(BigDecimal prixUnitaireTTC) {
		this.prixUnitaireTTC = prixUnitaireTTC;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public MvtStk getMvtStk() {
		return mvtStk;
	}

	public void setMvtStk(MvtStk mvtStk) {
		this.mvtStk = mvtStk;
	}

	public Vente getVente() {
		return vente;
	}

	public void setVente(Vente vente) {
		this.vente = vente;
	}

	public CommandeClient getCommandeClient() {
		return commandeClient;
	}

	public void setCommandeClient(CommandeClient commandeClient) {
		this.commandeClient = commandeClient;
	}

	public CommandeFournisseur getCommandeFournisseur() {
		return commandeFournisseur;
	}

	public void setCommandeFournisseur(CommandeFournisseur commandeFournisseur) {
		this.commandeFournisseur = commandeFournisseur;
	}
	
	
}
