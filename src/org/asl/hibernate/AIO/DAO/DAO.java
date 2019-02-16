package org.asl.hibernate.AIO.DAO;

import java.util.List;

import org.asl.hibernate.AIO.DTO.AioDTO;
import org.asl.hibernate.AIO.Util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class DAO {
	public static void get(int i) {
		Session se = HibernateUtil.getFactory().openSession();
		AioDTO ob1=se.get(AioDTO.class, i);
		System.out.println(ob1);
	}

	public static void load(int i) {
		Session se = HibernateUtil.getFactory().openSession();
		AioDTO ob1 = se.load(AioDTO.class, i);
		System.out.println(ob1);
	}

	public static void save(AioDTO r1) {
		Session se = HibernateUtil.getFactory().openSession();
		Transaction tx = se.beginTransaction();
		se.save(r1);
		tx.commit();
		se.close();

	}

	public static void update(int i, int c, String upd) {
		Session se = HibernateUtil.getFactory().openSession();
		AioDTO ob1 = se.get(AioDTO.class, i);
		Transaction tx = se.beginTransaction();
		if (c == 1) {
			ob1.setName(upd);
		} else if (c == 2) {
			ob1.setPhone(upd);
		} else {
			System.out.println("Invalid");
			return;
		}
		se.update(ob1);
		tx.commit();
		System.out.println("Updated");
	}

	public static void delete(int i) {
		Session se = HibernateUtil.getFactory().openSession();
		AioDTO ob1 = se.get(AioDTO.class, i);
		Transaction tx = se.beginTransaction();
		se.delete(ob1);
		tx.commit();
		System.out.println("Deleted");
	}

	public static void showAllHql() {
		Session se = HibernateUtil.getFactory().openSession();
		Query<AioDTO> qry = se.createQuery("from AioDTO");
		List<AioDTO> lst = qry.list();
		lst.forEach(System.out::println);
	}

	public static void selectHql(int id) {
		Session se = HibernateUtil.getFactory().openSession();
		String hql = "from AioDTO A where A.id=:idd" ;
		try {
			Query<AioDTO> qry = se.createQuery(hql);
			qry.setParameter("idd", id);
			AioDTO a1 = qry.uniqueResult();
			System.out.println(a1);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
	}

	public static void updateHql(int i, int c, String upd) {
		String hql = "";
		Session se = HibernateUtil.getFactory().openSession();
		Transaction tx = se.beginTransaction();
		if (c == 1) {
			hql = "update AioDTO set name=:nm where id=" + i;
			Query<AioDTO> qry = se.createQuery(hql);
			qry.setParameter("nm", upd);
			qry.executeUpdate();
			tx.commit();
		} else if (c == 2) {
			hql = "update AioDTO set phone=:ph where id=" + i;
			Query<AioDTO> qry = se.createQuery(hql);
			qry.setParameter("nm", upd);
			qry.executeUpdate();
			tx.commit();

		}

	}

	public static void deleteHql(int i) {
		String hql = "Delete AioDTO where id=" + i;
		Session se = HibernateUtil.getFactory().openSession();
		Transaction tx = se.beginTransaction();
		Query<AioDTO> qry = se.createQuery(hql);
		qry.executeUpdate();
		tx.commit();

	}
}
