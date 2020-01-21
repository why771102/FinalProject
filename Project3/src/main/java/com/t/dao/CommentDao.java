package com.t.dao;

import java.util.List;

import com.a.model.MovieBean;
import com.l.model.ProductsBean;
import com.p.model.MemberBean;
import com.t.model.CommentBean;
import com.t.model.ExpectationBean;

public interface CommentDao {
	//從cookie抓會員ID
	
	//從前端抓電影ID	
	
	//查詢並列出電影ID們
	public List<String> getMovies();
	
	//用列出的電影ID查comment
	public List<CommentBean> getCommentByMovie(Integer movieID);
	
	//抓出該電影的平均星數(小數點後1位)
	public ExpectationBean getAvgGrade(Integer grade);
	
	//抓出該會員在該電影所留的短評 && deleteComment = 0
	CommentBean getComment(Integer commentId);
	
	//抓到commentID後把資料都列出來
	List<CommentBean> memberComment();

	//印出所有該電影的評價(commentDelete不為1 && block不為1)及評論時間  要標示 已觀賞是否為1
	List<CommentBean> findAllComment();

	//建立新短評
	void addComment(CommentBean cb);
	MovieBean getMovieById(int movieID);
	MemberBean getMemberById(int memberID);
	List<MovieBean> getMovieList();
	List<MemberBean> getMemberList();
	
	//查詢單筆留言
	public CommentBean getTheCommentBean(Integer commentID);
	
	//修改留言
	public void updateComment(CommentBean cb);

	//將刪除的短評commentDelete 0改1
	void deleteComment(Integer commentID);

	//將檢舉的短評reportComment 0改1
	void reportComment(Integer commentID);

	//將檢舉的短評ID傳送至後台
	List<CommentBean> findAllReportComment();
}
