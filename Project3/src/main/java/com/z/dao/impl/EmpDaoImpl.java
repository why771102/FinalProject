package com.z.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.z.dao.EmpDao;
import com.z.model.EmpBean;

@Repository
public class EmpDaoImpl implements EmpDao {
	
	SessionFactory factory;
	
	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	@Override
	public void saveEmp(EmpBean mb) {
		Session session = factory.getCurrentSession();
		session.save(mb);
	}

	@Override
	public void updateEmp(EmpBean mb) {
		String hql = "update EmpBean set empName = :empName, roleId = :roleId , email = :email, status = :status where empId = :empId";
		Session session = factory.getCurrentSession();
		session.createQuery(hql).setParameter("empName", mb.getEmpName())
								.setParameter("roleId", mb.getRoleId())
								.setParameter("email", mb.getEmail())
								.setParameter("status", mb.getStatus())
								.setParameter("empId", mb.getEmpId()).executeUpdate();
		
	}

	@Override
	public EmpBean isExists(EmpBean mb) {
		String hql = "from EmpBean where empId = :empId";
		Session session = factory.getCurrentSession();
		EmpBean nmb = null;
		nmb = (EmpBean) session.createQuery(hql).getSingleResult();
		return nmb;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EmpBean> findAllEmps() {
		String hql = "from EmpBean";
		Session session = factory.getCurrentSession();
		List<EmpBean> list = new ArrayList<>();
		list = session.createQuery(hql).getResultList();
		return list;
	}

	@Override
	public EmpBean getEmp(Integer empId) {
		
		String hql = "from EmpBean where empId = :empId";
		Session session = factory.getCurrentSession();
		session.createQuery(hql)
		
		return null;
	}
	
	
	

}
