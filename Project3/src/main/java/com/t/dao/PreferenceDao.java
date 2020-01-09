package com.t.dao;

import java.util.List;

import com.t.model.PreferenceBean;

public interface PreferenceDao {

	//抓出該會員在本電影留言區的所有讚 噓和屏蔽
	List<PreferenceBean> getPreference();
	
	//按讚 建立新欄位，good設為1 bad設為0 block設為0，如果good為1，則改為0，如果bad為1，則good改為1 bad改為0

	//按噓 建立新欄位，good設為0 bad設為1 block設為0，如果good為1，則good改為0 bad改為1，如果bad為1，則改為0

	//按屏蔽 建立新欄位，good設為0 bad設為0 block設為1，若已經有欄位，將block改為1

	//屏蔽全部 到comment資料表抓出該短評的作者會員ID，列出該作者所有短評ID，再回到Preference 
	//建立新欄位，讚 噓 屏蔽設為0,0,1，若已有過設定，將屏蔽設為1

	//抓出每則短評的讚、噓總數

}
