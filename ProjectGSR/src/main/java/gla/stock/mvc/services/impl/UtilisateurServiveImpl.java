package gla.stock.mvc.services.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import gla.stock.mvc.dao.IUtilisateurDao;
import gla.stock.mvc.entities.Utilisateur;
import gla.stock.mvc.services.IUtilisateurServive;

@Transactional
public class UtilisateurServiveImpl implements IUtilisateurServive {
	
	private IUtilisateurDao dao10;
	
	public void setDao10(IUtilisateurDao dao10) {
		this.dao10 = dao10;
	}

	@Override
	public Utilisateur save(Utilisateur entity) {
		return dao10.save(entity);
	}

	@Override
	public Utilisateur update(Utilisateur entity) {
		return dao10.update(entity);
	}

	@Override
	public List<Utilisateur> selectAll() {
		return dao10.selectAll();
	}

	@Override
	public List<Utilisateur> selectAll(String sortField, String sort) {
		return dao10.selectAll(sortField, sort);
	}

	@Override
	public Utilisateur getById(Long id) {
		return dao10.getById(id);
	}

	@Override
	public void remove(Long id) {
		dao10.remove(id);
	}

	@Override
	public Utilisateur findOne(String paramName, Object paramValue) {
		return dao10.findOne(paramName, paramValue);
	}

	@Override
	public Utilisateur findOne(String[] paramNames, Object[] paramValues) {
		return dao10.findOne(paramNames, paramValues);
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		// TODO Auto-generated method stub
		return dao10.findCountBy(paramName, paramValue);
	}

}
