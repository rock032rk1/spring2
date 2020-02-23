package com.spring.fileupload.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.spring.fileupload.entity.FIleUpload;

@Component
public class FileUploadDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public int save(FIleUpload f) {
		
		Session ses=sessionFactory.getCurrentSession();
		ses.save(f);
		
		return f.getFid();
	}
	
	@Transactional
	public List<FIleUpload> list(){
		
		Session ses=sessionFactory.getCurrentSession();
		List<FIleUpload> flist=null;
		
		Query<FIleUpload> query=ses.createQuery("from FIleUpload",FIleUpload.class);
		
		flist=query.getResultList();
		
		return flist;
	}
}
