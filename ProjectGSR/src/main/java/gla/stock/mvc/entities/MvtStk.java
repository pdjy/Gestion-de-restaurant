package gla.stock.mvc.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class MvtStk implements Serializable {
	public static final int ENTREE = 1;
	public static final int SORTIE = 2;

	@Id
	@GeneratedValue
	private Long idMvtStk;

	private String dateMvt;
	
	private BigDecimal quantite;
	
	private int typeMvt;
	
	@ManyToOne 
	@JoinColumn(name="id_article")
	private Article article;
	
	@ManyToOne 
	@JoinColumn(name="idCommandeClient")
	private CommandeClient commandeClient;
	
	public CommandeClient getCommandeClient() {
		return commandeClient;
	}

	public void setCommandeClient(CommandeClient commandeClient) {
		this.commandeClient = commandeClient;
	}

	@ManyToOne 
	@JoinColumn(name="idVente")
	private Vente vente;
	
	public Long getIdMvtStk() {
		return idMvtStk;
	}

	public void setIdMvtStk(Long id) {
		this.idMvtStk = id;
	}

	public String getDateMvt() {
		return dateMvt;
	}

	public void setDateMvt(String dateMvt) {
		this.dateMvt = dateMvt;
	}

	public BigDecimal getQuantite() {
		return quantite;
	}

	public void setQuantite(BigDecimal quantite) {
		this.quantite = quantite;
	}

	public int getTypeMvt() {
		return typeMvt;
	}

	public void setTypeMvt(int typeMvt) {
		this.typeMvt = typeMvt;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public Vente getVente() {
		return vente;
	}

	public void setVente(Vente vente) {
		this.vente = vente;
	}
}
