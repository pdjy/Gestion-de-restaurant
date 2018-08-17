package gla.stock.mvc.services.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import gla.stock.mvc.dao.IFournisseurDao;
import gla.stock.mvc.entities.Fournisseur;
import gla.stock.mvc.services.IFournisseurService;

@Transactional
public class FournisseurServiceImpl implements IFournisseurService {
	
	private IFournisseurDao dao5;
	
	public void setDao5(IFournisseurDao dao5) {
		this.dao5 = dao5;
	}

	@Override
	public Fournisseur save(Fournisseur entity) {
		return dao5.save(entity);
	}

	@Override
	public Fournisseur update(Fournisseur entity) {
		return dao5.update(entity);
	}

	@Override
	public List<Fournisseur> selectAll() {
		return dao5.selectAll();
	}

	@Override
	public List<Fournisseur> selectAll(String sortField, String sort) {
		return dao5.selectAll(sortField, sort);
	}

	@Override
	public Fournisseur getById(Long id) {
		return dao5.getById(id);
	}

	@Override
	public void remove(Long id) {
		dao5.remove(id);
	}

	@Override
	public Fournisseur findOne(String paramName, Object paramValue) {
		return dao5.findOne(paramName, paramValue);
	}

	@Override
	public Fournisseur findOne(String[] paramNames, Object[] paramValues) {
		return dao5.findOne(paramNames, paramValues);
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		return dao5.findCountBy(paramName, paramValue);
	}

}
