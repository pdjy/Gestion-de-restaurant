package gla.stock.mvc.services.impl;

import java.util.List;

import gla.stock.mvc.dao.ILigneVenteDao;
import gla.stock.mvc.entities.LigneVente;
import gla.stock.mvc.services.ILigneVenteService;

public class LigneVenteServiceImpl implements ILigneVenteService {
	
	private ILigneVenteDao dao8;
	
	public void setDao8(ILigneVenteDao dao8) {
		this.dao8 = dao8;
	}

	@Override
	public LigneVente save(LigneVente entity) {
		return dao8.save(entity);
	}

	@Override
	public LigneVente update(LigneVente entity) {
		return dao8.update(entity);
	}

	@Override
	public List<LigneVente> selectAll() {
		return dao8.selectAll();
	}

	@Override
	public List<LigneVente> selectAll(String sortField, String sort) {
		return dao8.selectAll(sortField, sort);
	}

	@Override
	public LigneVente getById(Long id) {
		return dao8.getById(id);
	}

	@Override
	public void remove(Long id) {
		dao8.remove(id);
	}

	@Override
	public LigneVente findOne(String paramName, Object paramValue) {
		return dao8.findOne(paramName, paramValue);
	}

	@Override
	public LigneVente findOne(String[] paramNames, Object[] paramValues) {
		return dao8.findOne(paramNames, paramValues);
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		return dao8.findCountBy(paramName, paramValue);
	}

}
