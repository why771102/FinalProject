package com.t.service;

import java.util.List;

import com.t.model.CommentBean;
import com.t.model.ExpectationBean;

public interface CommentService {

	// 從cookie抓會員ID

	// 從前端抓電影ID

	// 抓出該電影的平均星數(小數點後1位)
	public ExpectationBean getAvgGrade(Integer grade);

	// 抓出該會員在該電影所留的短評 && deleteComment = 0
	CommentBean getComment(Integer commentId);

	// 抓到commentId後把資料都列出來
	List<CommentBean> memberComment();

	// 印出所有該電影的評價(commentDelete不為1 && block不為1)及評論時間 要標示 已觀賞是否為1
	List<CommentBean> findAllComment();

	// 建立新短評
	void createComment(CommentBean cb);

	// 將刪除的短評commentDelete 0改1
	void deleteComment(CommentBean cb);

	// 將檢舉的短評ID傳送至後台
}
