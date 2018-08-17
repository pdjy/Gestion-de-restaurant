package gla.stock.mvc.services.impl;

import java.io.InputStream;

import org.springframework.transaction.annotation.Transactional;

import gla.stock.mvc.dao.IFlickrDao;
import gla.stock.mvc.services.IFlickrService;

@Transactional
public class FlickrServiceImpl implements IFlickrService {
	
	private IFlickrDao dao;
	
	public void setDao(IFlickrDao dao) {
		this.dao = dao;
	}

	@Override
	public String savePhoto(InputStream photo, String title) throws Exception {
		return dao.savePhoto(photo, title);
	}

}
