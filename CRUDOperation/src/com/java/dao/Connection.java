package com.java.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class Connection {

	private SessionFactory factory=null;
	
	public SessionFactory getSessionFactory()
	{
		if(this.factory==null)
		{
			Configuration cfg=new AnnotationConfiguration().configure();
			this.factory=cfg.buildSessionFactory();
		}
		
		return this.factory;
	}
}
