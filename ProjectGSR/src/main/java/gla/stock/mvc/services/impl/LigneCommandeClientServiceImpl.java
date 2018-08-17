package gla.stock.mvc.services.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import gla.stock.mvc.dao.ILigneCommandeClientDao;
import gla.stock.mvc.entities.LigneCommandeClient;
import gla.stock.mvc.services.ILigneCommandeClientService;

@Transactional
public class LigneCommandeClientServiceImpl implements ILigneCommandeClientService {
	
	private ILigneCommandeClientDao dao6;
	
	public void setDao6(ILigneCommandeClientDao dao6) {
		this.dao6 = dao6;
	}

	@Override
	public LigneCommandeClient save(LigneCommandeClient entity) {
		return dao6.save(entity);
	}

	@Override
	public LigneCommandeClient update(LigneCommandeClient entity) {
		return dao6.update(entity);
	}

	@Override
	public List<LigneCommandeClient> selectAll() {
		return dao6.selectAll();
	}

	@Override
	public List<LigneCommandeClient> selectAll(String sortField, String sort) {
		return dao6.selectAll(sortField, sort);
	}

	@Override
	public LigneCommandeClient getById(Long id) {
		return dao6.getById(id);
	}

	@Override
	public void remove(Long id) {
		dao6.remove(id);
	}

	@Override
	public LigneCommandeClient findOne(String paramName, Object paramValue) {
		return dao6.findOne(paramName, paramValue);
	}

	@Override
	public LigneCommandeClient findOne(String[] paramNames, Object[] paramValues) {
		return dao6.findOne(paramNames, paramValues);
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		// TODO Auto-generated method stub
		return dao6.findCountBy(paramName, paramValue);
	}

}
