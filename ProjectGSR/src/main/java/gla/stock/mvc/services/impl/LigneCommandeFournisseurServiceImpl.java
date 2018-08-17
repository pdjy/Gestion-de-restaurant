package gla.stock.mvc.services.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import gla.stock.mvc.dao.ICommandeFournisseurDao;
import gla.stock.mvc.dao.ILigneCommandeFournisseurDao;
import gla.stock.mvc.entities.CommandeFournisseur;
import gla.stock.mvc.entities.LigneCommandeFournisseur;
import gla.stock.mvc.services.ICommandeFournisseurService;
import gla.stock.mvc.services.ILigneCommandeFournisseurService;

@Transactional
public class LigneCommandeFournisseurServiceImpl implements ILigneCommandeFournisseurService {

	private ILigneCommandeFournisseurDao dao7;

	public void setDao7(ILigneCommandeFournisseurDao dao7) {
		this.dao7 = dao7;
	}

	@Override
	public LigneCommandeFournisseur save(LigneCommandeFournisseur entity) {
		// TODO Auto-generated method stub
		return dao7.save(entity);
	}

	@Override
	public LigneCommandeFournisseur update(LigneCommandeFournisseur entity) {
		// TODO Auto-generated method stub
		return dao7.update(entity);
	}

	@Override
	public List<LigneCommandeFournisseur> selectAll() {
		// TODO Auto-generated method stub
		return dao7.selectAll();
	}

	@Override
	public List<LigneCommandeFournisseur> selectAll(String sortField, String sort) {
		// TODO Auto-generated method stub
		return dao7.selectAll(sortField, sort);
	}

	@Override
	public LigneCommandeFournisseur getById(Long id) {
		// TODO Auto-generated method stub
		return dao7.getById(id);
	}

	@Override
	public void remove(Long id) {
		dao7.remove(id);

	}

	@Override
	public LigneCommandeFournisseur findOne(String paramName, Object paramValue) {
		// TODO Auto-generated method stub
		return dao7.findOne(paramName, paramValue);
	}

	@Override
	public LigneCommandeFournisseur findOne(String[] paramNames, Object[] paramValues) {
		// TODO Auto-generated method stub
		return dao7.findOne(paramNames, paramValues);
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		// TODO Auto-generated method stub
		return dao7.findCountBy(paramName, paramValue);
	}

}
