package com.mycompany.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mycompany.myapp.dao.GalleryDao;
import com.mycompany.myapp.dto.Gallery;

public interface GalleryService {
	
	public void galleryWrite(Gallery gallery);
	public List<Gallery> galleryListAll();
	
	public List<Gallery> galleryListPage(int pageNo, int rowsPerPage);
	public int galleryTotalRows();
	
	public Gallery getGallery(int gno);
	public void galleryUpdate(Gallery gallery);
	//public void galleryDelete(int gno);
	
	
	

}
