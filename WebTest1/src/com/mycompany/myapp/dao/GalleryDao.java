package com.mycompany.myapp.dao;

import java.util.List;

import com.mycompany.myapp.dto.Gallery;

public interface GalleryDao {
	public int galleryInsert(Gallery gallery);
	public List<Gallery> gallerySelectAll();
	public List<Gallery> gallerySelectPage(int pageNo, int rowsPerPage);
	public int galleryCountAll();
	public Gallery gallerySelectByGno(int gno);
	public void galleryUpdate(Gallery gallery);
	//public void galleryDelete(int gno);

}
