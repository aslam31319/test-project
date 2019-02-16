package org.asl.hibernate.AIO.Util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public abstract  class HibernateUtil 
{
	private static final SessionFactory sf;
	static
	{
		Configuration cfg=new Configuration();
		cfg.configure("org\\asl\\hibernate\\AIO\\Config\\hibernate.cfg.xml");
		sf=cfg.buildSessionFactory();
		
	}
	public static SessionFactory getFactory()
	{
		return sf;
	}
}
