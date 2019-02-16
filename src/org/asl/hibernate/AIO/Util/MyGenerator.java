package org.asl.hibernate.AIO.Util;

import java.io.Serializable;

import org.asl.hibernate.AIO.DTO.AioDTO;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.query.Query;

public class MyGenerator implements IdentifierGenerator {

	@Override
	public Serializable generate(SharedSessionContractImplementor arg0, Object arg1) throws HibernateException {
		// Session se = HibernateUtil.getFactory().openSession();
		Query<AioDTO> qry = arg0.createQuery("select f from AioDTO f where id=(select max(id) from AioDTO f)");
		AioDTO a1 = qry.uniqueResult();
		if (a1 != null)
			return a1.getId() + 5;
		else
			return 1;
	}

}
