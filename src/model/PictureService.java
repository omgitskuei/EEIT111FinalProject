package model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PictureService {

	private PictureDAO pDao;

	@Autowired
	public PictureService(PictureDAO pDao) {
		this.pDao = pDao;
	}

	public Picture insert(Picture bean) {
		return pDao.insert(bean);
	}

}
