package com.p.dao;

import com.l.model.MOrderBean;


public interface MemberProductsQueryDao{
	
	//用MemberID來Query歷史訂單，直接用致緯的mOrderBean
	//希望能秀出1.電影名稱2.電影場次(日期和播出時間)3.票價4.訂票數量
	//5.用戶買了什麼
	//主要就是訂單內容啦
	//這個方法可能會非常複雜
	
	public MOrderBean MemberProductsQuery();//看看參數要填啥

}
