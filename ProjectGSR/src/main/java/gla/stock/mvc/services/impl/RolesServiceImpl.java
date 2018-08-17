package gla.stock.mvc.services.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import gla.stock.mvc.dao.IRolesDao;
import gla.stock.mvc.entities.Roles;
import gla.stock.mvc.services.IRolesService;

@Transactional
public class RolesServiceImpl implements IRolesService {
	
	private IRolesDao dao12;
	
	public void setDao12(IRolesDao dao12) {
		this.dao12 = dao12;
	}

	@Override
	public Roles save(Roles entity) {
		return dao12.save(entity);
	}

	@Override
	public Roles update(Roles entity) {
		return dao12.update(entity);
	}

	@Override
	public List<Roles> selectAll() {
		return dao12.selectAll();
	}

	@Override
	public List<Roles> selectAll(String sortField, String sort) {
		return dao12.selectAll(sortField, sort);
	}

	@Override
	public Roles getById(Long id) {
		return dao12.getById(id);
	}

	@Override
	public void remove(Long id) {
		dao12.remove(id);
	}

	@Override
	public Roles findOne(String paramName, Object paramValue) {
		return dao12.findOne(paramName, paramValue);
	}

	@Override
	public Roles findOne(String[] paramNames, Object[] paramValues) {
		return dao12.findOne(paramNames, paramValues);
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		return dao12.findCountBy(paramName, paramValue);
	}

}
