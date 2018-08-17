package gla.stock.mvc.services.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import gla.stock.mvc.dao.ICommandeFournisseurDao;
import gla.stock.mvc.entities.CommandeFournisseur;
import gla.stock.mvc.services.ICommandeFournisseurService;

@Transactional
public class CommandeFournisseurServiceImpl implements ICommandeFournisseurService {
	
	private ICommandeFournisseurDao dao4;
	
	public void setDao4(ICommandeFournisseurDao dao4) {
		this.dao4 = dao4;
	}

	@Override
	public CommandeFournisseur save(CommandeFournisseur entity) {
		return dao4.save(entity);
	}

	@Override
	public CommandeFournisseur update(CommandeFournisseur entity) {
		return dao4.update(entity);
	}

	@Override
	public List<CommandeFournisseur> selectAll() {
		return dao4.selectAll();
	}

	@Override
	public List<CommandeFournisseur> selectAll(String sortField, String sort) {
		return dao4.selectAll(sortField, sort);
	}

	@Override
	public CommandeFournisseur getById(Long id) {
		return dao4.getById(id);
	}

	@Override
	public void remove(Long id) {
		dao4.remove(id);
	}

	@Override
	public CommandeFournisseur findOne(String paramName, Object paramValue) {
		return dao4.findOne(paramName, paramValue);
	}

	@Override
	public CommandeFournisseur findOne(String[] paramNames, Object[] paramValues) {
		return dao4.findOne(paramNames, paramValues);
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		return dao4.findCountBy(paramName, paramValue);
	}

}
