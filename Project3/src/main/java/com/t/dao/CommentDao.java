package com.t.dao;

import java.util.List;

import com.a.model.MovieBean;
import com.l.model.ProductsBean;
import com.p.model.MemberBean;
import com.t.model.CommentBean;
import com.t.model.ExpectationBean;

public interface CommentDao {
	
	//從前端抓電影ID
	
	//抓出該會員是否在該留言執行過偏好設定
	public boolean checkCommentExist(Integer memberID,Integer movieID);
	
	//查詢並列出電影ID們
	public List<String> getMovies();
	
	//用電影ID查comment(未登入) 照時間排序 早到晚
	public List<CommentBean> getCommentByMovieNoLoginByTime(Integer movieID);
	
	//用電影ID查comment(未登入) 照時間排序 晚到早
	public List<CommentBean> getCommentByMovieNoLoginByTimeDesc(Integer movieID);
			
	//用電影ID查comment(未登入) 照評分排序 低到高
	public List<CommentBean> getCommentByMovieNoLoginByGrade(Integer movieID);
		
	//用電影ID查comment(未登入) 照評分排序 高到低
	public List<CommentBean> getCommentByMovieNoLoginByGradeDesc(Integer movieID);
		
	//用電影ID查comment(登入) 照時間排序 早到晚
	public List<CommentBean> getCommentByMovieOrderByTime(Integer movieID,Integer memberIDBlock);
	
	//用電影ID查comment(登入) 照時間排序 晚到早
	public List<CommentBean> getCommentByMovieOrderByTimeDesc(Integer movieID,Integer memberIDBlock);
		
	//用電影ID查comment(登入) 照評分排序 低到高
	public List<CommentBean> getCommentByMovieOrderByGrade(Integer movieID,Integer memberIDBlock);
		
	//用電影ID查comment(登入) 照評分排序 高到低
	public List<CommentBean> getCommentByMovieOrderByGradeDesc(Integer movieID,Integer memberIDBlock);
	
	//抓出該電影的平均星數
	public Double getAvgGrade(Integer movieID);
	
	//抓出該會員在該電影所留的短評ID && deleteComment = 0
	public Integer getCommentID(Integer memberID,Integer movieID);
	
	//抓到commentID後把資料都列出來
	List<CommentBean> memberComment();

	//印出所有該電影的評價(commentDelete不為1 && block不為1)及評論時間  要標示 已觀賞是否為1
	List<CommentBean> findAllComment();

	//建立新短評
	void addComment(CommentBean cb);
	MovieBean getMovieById(int movieID);
	MemberBean getMemberById(int memberID);
	List<MovieBean> getMovieList();
//	List<MemberBean> getMemberList();
	
	//查詢單筆留言
	public CommentBean getTheCommentBean(Integer commentID);
	
	//修改留言
	public void updateComment(CommentBean cb);

	//將刪除的短評commentDelete 0改1
	void deleteComment(Integer commentID);

	//將檢舉的短評reportComment 0改1
	void reportComment(Integer commentID);
	
	//將審核後沒問題的短評reportComment 1改0
	void cancalReportComment(Integer commentID);

	//將檢舉的短評ID傳送至後台
	List<CommentBean> findAllReportComment();
	
}
