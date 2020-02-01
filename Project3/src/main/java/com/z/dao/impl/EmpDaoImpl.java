package com.z.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.p.dao.util.CipherUtils;
import com.p.model.MemberBean;
import com.z.dao.EmpDao;
import com.z.exception.EmpNotFoundException;
import com.z.model.EmpBean;
import com.z.model.EmpStatusBean;
import com.z.model.RoleBean;

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
		RoleBean rb = getRoleById(mb.getRoleId());
		EmpStatusBean esb = getEmpStatusById(mb.getStatus());
		mb.setRoleBean(rb);
		mb.setEmpStatusBean(esb);
		
		mb.setPassword(changeToMd5(mb.getPassword()));	
		session.saveOrUpdate(mb);
	}
	
	@Override
	public String changeToMd5(String str) {
		String strMd5 = CipherUtils.getStringMD5(str);
		return strMd5;
	}
	
	@Override
	public String changeFromMd5(String str) {
		String strMd5 = CipherUtils.encryptString(str , "MD5");
		return strMd5;
	}
	
	
	
	@Override
	public RoleBean getRoleById(Integer roleId) {
		Session session = factory.getCurrentSession();
		RoleBean rb = session.get(RoleBean.class, roleId);
		return rb;
	}
	
	@Override
	public EmpStatusBean getEmpStatusById(Integer status) {
		Session session = factory.getCurrentSession();
		EmpStatusBean esb = session.get(EmpStatusBean.class, status);
		return esb;
	}
	

//	@Override
//	public void updateEmp(EmpBean mb) {
//		String hql = "update EmpBean set empName = :empName, roleId = :roleId , email = :email, status = :status where empId = :empId";
//		Session session = factory.getCurrentSession();
//		session.createQuery(hql).setParameter("empName", mb.getEmpName())
//								.setParameter("roleId", mb.getRoleId())
//								.setParameter("email", mb.getEmail())
//								.setParameter("status", mb.getStatus())
//								.setParameter("empId", mb.getEmpId()).executeUpdate();
//		
//	}

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
		Session session = factory.getCurrentSession();
		EmpBean eb = session.get(EmpBean.class, empId);
		if(eb == null) {
			throw new EmpNotFoundException("查無員工編號：", empId);
		}
		return eb;
	}

	@Override
	public List<RoleBean> getRoleList() {
		String hql = "from RoleBean";
		Session session = factory.getCurrentSession();
		List<RoleBean> list = session.createQuery(hql).getResultList();
		return list;
	}

	@Override
	public List<EmpStatusBean> getEmpStatusList() {
		String hql = "from EmpStatusBean";
		Session session = factory.getCurrentSession();
		List<EmpStatusBean> list = session.createQuery(hql).getResultList();
		return list;
	}
	
	
	@Override
	public EmpBean login(String email, String password) {
		
		String pwd = changeToMd5(password);//將傳入的password進行加密
		
		String hql = "from EmpBean where email = :email and password = :password";
		Session session = factory.getCurrentSession();
		EmpBean eb = null;
		eb = (EmpBean) session.createQuery(hql).setParameter("email", email).setParameter("password", pwd).getSingleResult();
		return eb;
	}
	
	@Override
	public void changePwd(EmpBean mb) {
		Session session = factory.getCurrentSession();
		String hql = "update EmpBean set password = :password where empId = :empId";
		String newPwd = changeToMd5(mb.getPassword());
		session.createQuery(hql).setParameter("password", newPwd).setParameter("empId", mb.getEmpId()).executeUpdate();
	}
	

}
