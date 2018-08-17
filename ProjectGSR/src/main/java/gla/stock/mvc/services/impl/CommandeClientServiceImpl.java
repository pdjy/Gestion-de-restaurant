package gla.stock.mvc.services.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import gla.stock.mvc.dao.ICommandeClientDao;
import gla.stock.mvc.entities.CommandeClient;
import gla.stock.mvc.services.ICommandeClientService;

@Transactional
public class CommandeClientServiceImpl implements ICommandeClientService {
	
	private ICommandeClientDao dao3;
	
	public void setDao3(ICommandeClientDao dao3) {
		this.dao3 = dao3;
	}

	@Override
	public CommandeClient save(CommandeClient entity) {
		return dao3.save(entity);
	}

	@Override
	public CommandeClient update(CommandeClient entity) {
		return dao3.update(entity);
	}

	@Override
	public List<CommandeClient> selectAll() {
		return dao3.selectAll();
	}

	@Override
	public List<CommandeClient> selectAll(String sortField, String sort) {
		return dao3.selectAll(sortField, sort);
	}

	@Override
	public CommandeClient getById(Long id) {
		return dao3.getById(id);
	}

	@Override
	public void remove(Long id) {
		dao3.remove(id);
	}

	@Override
	public CommandeClient findOne(String paramName, Object paramValue) {
		return dao3.findOne(paramName, paramValue);
	}

	@Override
	public CommandeClient findOne(String[] paramNames, Object[] paramValues) {
		return dao3.findOne(paramNames, paramValues);
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		return dao3.findCountBy(paramName, paramValue);
	}

}
