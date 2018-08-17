package gla.stock.mvc.services;

import java.util.List;

import gla.stock.mvc.entities.Utilisateur;

public interface IUtilisateurServive {
	
	public Utilisateur save(Utilisateur entity);
	
	public Utilisateur update(Utilisateur entity);
	
	public List<Utilisateur> selectAll();
	
	public List<Utilisateur> selectAll(String sortField, String sort); 
	
	public Utilisateur getById(Long id);
	
	public void remove(Long id);
	
	public Utilisateur findOne(String paramName, Object paramValue);
	
	public Utilisateur findOne(String[] paramNames, Object[] paramValues);
	
	public int findCountBy(String paramName, String paramValue);

}
