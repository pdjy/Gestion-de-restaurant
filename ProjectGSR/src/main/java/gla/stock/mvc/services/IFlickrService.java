package gla.stock.mvc.services;

import java.io.InputStream;

public interface IFlickrService {

	public String savePhoto(InputStream photo, String title) throws Exception;
}
