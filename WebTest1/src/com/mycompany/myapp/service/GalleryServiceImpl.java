package com.mycompany.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.myapp.dao.GalleryDao;
import com.mycompany.myapp.dto.Gallery;
@Component
public class GalleryServiceImpl implements GalleryService{

	@Autowired
	private GalleryDao dao;
	
	@Override
	public void galleryWrite(Gallery gallery) {
		dao.galleryInsert(gallery);
		
	}
	

	@Override
	public List<Gallery> galleryListAll() {
		List<Gallery> list = dao.gallerySelectAll();
		return list;
	}
	
	@Override
	public int galleryTotalRows() {
		int totalRows = dao.galleryCountAll();
		return totalRows;
	}
	
	@Override
	public List<Gallery> galleryListPage(int pageNo, int rowsPerPage) {
		List<Gallery> list = dao.gallerySelectPage(pageNo, rowsPerPage);
		return list;
	}

	

	@Override
	public Gallery getGallery(int gno) {
		Gallery gallery = dao.gallerySelectByGno(gno);
		return gallery;
	}

	@Override
	public void galleryUpdate(Gallery gallery) {
		dao.galleryUpdate(gallery);
		
	}



	@Override
	public void galleryDelete(int gno) {
		dao.galleryDelete(gno);
		
	}
	 

}
