package com.l.dao.impl;


import java.time.LocalDate;
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
import com.l.model.MOrderDetailBean;
import com.l.model.ProductsBean;
import com.p.model.MemberBean;
import com.z.model.EmpBean;


@Repository
public class mOrdersDaoImpl implements mOrdersDao{
	SessionFactory factory;
	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	//查詢所有runID時間在現在時間和expectedOffDate之間之電影ID
		@Override
		public List<RunningBean> getAllOnMoive(LocalDate day){
			List<RunningBean>rbList =new ArrayList<RunningBean>(); 
			String hql ="from RunningBean where  release <= :endTime  and expectedOffDate >= :startTime ";
			String startTime = (day.toString())+" "+"00:00:00"; 
			String endTime = (day.toString())+" "+"23:59:59"; 
			Session session =factory.getCurrentSession();
			rbList=session.createQuery(hql).setParameter("endTime", endTime)
	                                       .setParameter("startTime", startTime)
	                                       .getResultList();
			
			return rbList;
		}
		
		//用runID查出exOffDay和release
		@Override
		public RunningBean getDayAndRelease(Integer runID){
			Session session = factory.getCurrentSession();
			RunningBean rb = session.get(RunningBean.class, runID);
			return rb;
		}
		
		
		//用runID查playStartTime
		@Override
		public List<ShowTimeHistoryBean> getplayStartTime(Integer runID,String dateTime,String exOffDay){
			String hql="from ShowTimeHistoryBean where playStartTime <= :enddate  and playStartTime >= :startdate and runID = :runID";
			String startTime = dateTime; 
			List<ShowTimeHistoryBean> list=new ArrayList<>();
			Session session=factory.getCurrentSession();
			list=session.createQuery(hql).setParameter("enddate", exOffDay)
										.setParameter("startdate", startTime)
										.setParameter("runID", runID).getResultList();
			System.out.println(exOffDay);
			System.out.println(startTime);
			return list;
		}
		
		//用StartTimeID查	單筆
		@Override
		public Object getStartTimeByID(Integer showTimeId) {
		Session session =factory.getCurrentSession();
		ShowTimeHistoryBean sthb=session.get(ShowTimeHistoryBean.class, showTimeId);
			return sthb;
		}
	
	
	
		//新增訂單
		@Override
		public void addMOrder(MOrderBean mob) {
			Session session =factory.getCurrentSession();
			ShowTimeHistoryBean sthb = getShowTimeHistory(mob.getShowTimeID());
			mob.setShowTimeHistoryBean(sthb);
			EmpBean eb = getEmp(mob.getEmpId());
			mob.setEmpBean(eb);
			MemberBean mb = getMemberById(mob.getMemberID());
			mob.setMemberBean(mb);
			session.save(mob);
		}
		//新增訂單明細
		@Override
		public void addMOrderDetail(MOrderDetailBean modb) {
			Session session =factory.getCurrentSession();
			MOrderBean sthb = getOrderBeanID(modb.getOrdersID());
			modb.setmOrderBean(sthb);
			ProductsBean pb = getProductBeanID(modb.getProductID());
			modb.setProductsBean(pb);
			
			session.save(modb);
		}
		
		//修改票狀態、領票時間、員工ID原本1
		@Override
		public void updateTicket(MOrderBean mob) {
			String hql="UPDATE MOrderBean SET orderTime=:neworderTime, ticketStatus=:newticketStatus,showTimeID=:newshowTimeID, memberID=:newmemberID,ticketTime=:newticketTime,empID=:newempID WHERE ordersID=:id";
			Session session=factory.getCurrentSession();
				int n=session.createQuery(hql)	
						.setParameter("neworderTime",mob.getOrderTime())
						.setParameter("newticketStatus", mob.getTicketStatus())
						.setParameter("newshowTimeID", mob.getShowTimeHistoryBean().getShowTimeId())
						.setParameter("newticketStatus",mob.getTicketStatus())
						.setParameter("newmemberID",mob.getMemberID())
						.setParameter("newticketTime",mob.getTicketTime())			
						.setParameter("newempID",mob.getEmpId())
						.setParameter("id", mob.getOrdersID())
						.executeUpdate();
		}

		//查詢單筆OrderID
		@Override
		public MOrderBean getOrderID(Integer orderID) {
			Session session = factory.getCurrentSession();
			MOrderBean mb = session.get(MOrderBean.class,orderID);
			return mb;
			
		}
		
		@Override
		public ShowTimeHistoryBean getShowTimeHistory(int showTimeId) {
			ShowTimeHistoryBean sthb = null;
			Session session = factory.getCurrentSession();
			sthb = session.get(ShowTimeHistoryBean.class, showTimeId);
			return sthb;
		}
		
		@Override
		public EmpBean getEmp(int empID) {
			EmpBean eb = null;
			Session session = factory.getCurrentSession();
			eb = session.get(EmpBean.class, empID);
			return eb;
		}
		
		
		@Override
		public MemberBean getMemberById(int memberID) {
			MemberBean mb = null;
			Session session = factory.getCurrentSession();
			mb = session.get(MemberBean.class, memberID);
			return mb;
		}

		@Override
		public MOrderBean getOrderBeanID(int OrderID) {
			MOrderBean mb = null;
			Session session = factory.getCurrentSession();
			mb = session.get(MOrderBean.class, OrderID);
			return mb;
		}
	
		@Override
		public ProductsBean getProductBeanID(int ProductsID) {
			ProductsBean pb = null;
			Session session = factory.getCurrentSession();
			pb = session.get(ProductsBean.class, ProductsID);
			return pb;
		}

		
		
}
