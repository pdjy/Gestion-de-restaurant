package gla.stock.mvc.services.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import gla.stock.mvc.dao.ICategorieDao;
import gla.stock.mvc.entities.Categorie;
import gla.stock.mvc.services.ICategorieService;

@Transactional
public class CategorieServiceImpl implements ICategorieService {
	
	private ICategorieDao dao2;
	
	public void setDao2(ICategorieDao dao2) {
		this.dao2 = dao2;
	}

	@Override
	public Categorie save(Categorie entity) {
		return dao2.save(entity);
	}

	@Override
	public Categorie update(Categorie entity) {
		return dao2.update(entity);
	}

	@Override
	public List<Categorie> selectAll() {
		return dao2.selectAll();
	}

	@Override
	public List<Categorie> selectAll(String sortField, String sort) {
		return dao2.selectAll(sortField, sort);
	}

	@Override
	public Categorie getById(Long id) {
		return dao2.getById(id);
	}

	@Override
	public void remove(Long id) {
		dao2.remove(id);
	}

	@Override
	public Categorie findOne(String paramName, Object paramValue) {
		return dao2.findOne(paramName, paramValue);
	}

	@Override
	public Categorie findOne(String[] paramNames, Object[] paramValues) {
		return dao2.findOne(paramNames, paramValues);
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		return dao2.findCountBy(paramName, paramValue);
	}

}
