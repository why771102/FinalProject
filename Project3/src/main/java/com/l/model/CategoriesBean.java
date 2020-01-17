package com.l.model;


import java.io.Serializable;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.a.model.ShowTimeHistoryBean;
import com.p.model.MemberBean;
import com.sun.istack.NotNull;
import com.z.model.EmpBean;

@Entity
@Table(name="categories")
public class CategoriesBean implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer categoryID;
	@NotNull
	@Column(nullable=false, columnDefinition = "NVARCHAR(40)")
	String categoryName;
	
	
	
	
	public CategoriesBean() {}
	
	public CategoriesBean(Integer categoryID,String categoryName) {
		this.categoryID=categoryID;
		this.categoryName=categoryName;

	}
	
	public Integer getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(Integer categoryID) {
		this.categoryID = categoryID;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

}