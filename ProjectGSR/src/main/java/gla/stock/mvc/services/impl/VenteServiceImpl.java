package gla.stock.mvc.services.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import gla.stock.mvc.dao.IVenteDao;
import gla.stock.mvc.entities.Vente;
import gla.stock.mvc.services.IVenteService;
@Transactional
public class VenteServiceImpl implements IVenteService {
	
private IVenteDao dao11;
	
	public void setDao11(IVenteDao dao11) {
		this.dao11 = dao11;
	}

	@Override
	public Vente save(Vente entity) {
		return dao11.save(entity);
	}

	@Override
	public Vente update(Vente entity) {
		return dao11.update(entity);
	}

	@Override
	public List<Vente> selectAll() {
		return dao11.selectAll();
	}

	@Override
	public List<Vente> selectAll(String sortField, String sort) {
		return dao11.selectAll(sortField, sort);
	}

	@Override
	public Vente getById(Long id) {
		return dao11.getById(id);
	}

	@Override
	public void remove(Long id) {
		dao11.remove(id);
	}

	@Override
	public Vente findOne(String paramName, Object paramValue) {
		return dao11.findOne(paramName, paramValue);
	}

	@Override
	public Vente findOne(String[] paramNames, Object[] paramValues) {
		return dao11.findOne(paramNames, paramValues);
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		return dao11.findCountBy(paramName, paramValue);
	}
	
	

}
