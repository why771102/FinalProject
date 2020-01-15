package com.l.service;

import java.util.List;

import com.a.model.MovieBean;
import com.a.model.RunningBean;
import com.a.model.ShowTimeHistoryBean;
import com.l.model.MOrderBean;
import com.z.model.EmpBean;

public interface mOrdersService {
	//查詢上映status=1電影ID之電影名字
	public List<MovieBean> getMovieName();
	//查詢電影ID之排片ID後,用排片ID查詢播放日期時間
	public RunningBean getRunbyID(MovieBean mb);
	public List<ShowTimeHistoryBean> getShowTimebyID(RunningBean sthb);
	//新增訂單
	public void addMOrder(MOrderBean mob);
	//修改訂單之員工ID原本null
	public List<EmpBean> updateEmpbyID(EmpBean eb);
	//修改票狀態、領票時間
	public MOrderBean updateTicket(MOrderBean mob);
}
