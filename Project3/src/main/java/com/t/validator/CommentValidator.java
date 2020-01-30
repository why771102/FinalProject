package com.t.validator;

import org.springframework.stereotype.Component;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.p.model.MemberBean;
import com.t.model.CommentBean;


@Component
public class CommentValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
//		System.out.println(clazz.getName());
		boolean b = CommentBean.class.isAssignableFrom(clazz);
		return b;
	}

	@Override
	public void validate(Object target, Errors errors) {
		CommentBean comment = (CommentBean)target;
		ValidationUtils.rejectIfEmptyOrWhitespace
			(errors, "watched", "","必選!");
		ValidationUtils.rejectIfEmptyOrWhitespace
			(errors, "grade", "","必選!");
		ValidationUtils.rejectIfEmptyOrWhitespace
			(errors, "commentContent", "", "短評不得空白!");
		
		if (comment.getCommentContent().length()>200) {
			errors.rejectValue("commentContent","", "短評不能大於二百字元");
		}

	}

}
