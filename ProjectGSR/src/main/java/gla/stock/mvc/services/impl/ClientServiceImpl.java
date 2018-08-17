package gla.stock.mvc.services.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import gla.stock.mvc.dao.IClientDao;
import gla.stock.mvc.entities.Client;
import gla.stock.mvc.services.IClientService;

@Transactional
public class ClientServiceImpl implements IClientService {
	
	private IClientDao dao1;
	
	public void setDao1(IClientDao dao1) {
		this.dao1 = dao1;
	}

	@Override
	public Client save(Client entity) {
		return dao1.save(entity);
	}

	@Override
	public Client update(Client entity) {
		return dao1.update(entity);
	}

	@Override
	public List<Client> selectAll() {
		return dao1.selectAll();
	}

	@Override
	public List<Client> selectAll(String sortField, String sort) {
		return dao1.selectAll(sortField, sort);
	}

	@Override
	public Client getById(Long id) {
		return dao1.getById(id);
	}

	@Override
	public void remove(Long id) {
		dao1.remove(id);
	}

	@Override
	public Client findOne(String paramName, Object paramValue) {
		return dao1.findOne(paramName, paramValue);
	}

	@Override
	public Client findOne(String[] paramNames, Object[] paramValues) {
		return dao1.findOne(paramNames, paramValues);
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		return dao1.findCountBy(paramName, paramValue);
	}

}
