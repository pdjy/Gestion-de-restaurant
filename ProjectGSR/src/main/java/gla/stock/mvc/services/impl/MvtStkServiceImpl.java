package gla.stock.mvc.services.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import gla.stock.mvc.dao.IMvtStkDao;
import gla.stock.mvc.entities.MvtStk;
import gla.stock.mvc.services.IMvtStkService;

@Transactional
public class MvtStkServiceImpl implements IMvtStkService {
	
	private IMvtStkDao dao9;
	
	public void setDao9(IMvtStkDao dao9) {
		this.dao9 = dao9;
	}

	@Override
	public MvtStk save(MvtStk entity) {
		return dao9.save(entity);
	}

	@Override
	public MvtStk update(MvtStk entity) {
		return dao9.update(entity);
	}

	@Override
	public List<MvtStk> selectAll() {
		return dao9.selectAll();
	}

	@Override
	public List<MvtStk> selectAll(String sortField, String sort) {
		return dao9.selectAll(sortField, sort);
	}

	@Override
	public MvtStk getById(Long id) {
		return dao9.getById(id);
	}

	@Override
	public void remove(Long id) {
		dao9.remove(id);
	}

	@Override
	public MvtStk findOne(String paramName, Object paramValue) {
		return dao9.findOne(paramName, paramValue);
	}

	@Override
	public MvtStk findOne(String[] paramNames, Object[] paramValues) {
		return dao9.findOne(paramNames, paramValues);
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		return dao9.findCountBy(paramName, paramValue);
	}

}
