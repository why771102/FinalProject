package com.l.dao.impl;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.a.model.MovieBean;
import com.a.model.RunningBean;
import com.a.model.ShowTimeHistoryBean;


import com.l.dao.mOrdersDao;
import com.l.model.MOrderBean;
import com.l.model.ProductsBean;
import com.z.model.EmpBean;


@Repository
public class mOrdersDaoImpl implements mOrdersDao{
	SessionFactory factory;
	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}
	
	//查詢上映status=1電影ID之電影名字
	@Override
	@SuppressWarnings("unchecked")	
	public List<MovieBean> getMovieName(){
			String hql="FROM MovieBean where status=1";
			Session session=null;
			List<MovieBean> list=new ArrayList<>();
			session = factory.getCurrentSession();
			list=session.createQuery(hql).getResultList();
			return list;
			}
	//查詢電影ID之排片ID後,用排片ID查詢播放日期時間
	public RunningBean getRunbyID(MovieBean mb) {
				String hql="from RunningBean rb where rb.runID=:runID";
				Session session=factory.getCurrentSession();
				RunningBean rb=(RunningBean) session.createQuery(hql).setParameter("runID", mb).getResultList();
				return rb;
	}
	public List<ShowTimeHistoryBean> getShowTimebyID(RunningBean rb){
			String hql="from showTimeHistoryBean sthb where sthb.playStartTime=:playStartTime";
			Session session=factory.getCurrentSession();
			List<ShowTimeHistoryBean> list=new ArrayList<>();
			list= session.createQuery(hql).setParameter("playStartTime", rb).getResultList();
			return list;
		}
		//新增訂單
		public void addMOrder(MOrderBean mob) {
			
		}
		//修改訂單之員工ID原本null
		public List<EmpBean> updateEmpbyID(EmpBean eb){
			
		}
		//修改票狀態、領票時間
		public MOrderBean updateTicket(MOrderBean mob) {
			
		}
}
