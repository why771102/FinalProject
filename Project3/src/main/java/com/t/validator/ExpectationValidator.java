package com.t.validator;

import org.springframework.stereotype.Component;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.p.model.MemberBean;
import com.t.model.CommentBean;
import com.t.model.ExpectationBean;


@Component
public class ExpectationValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
//		System.out.println(clazz.getName());
		boolean b = ExpectationBean.class.isAssignableFrom(clazz);
		return b;
	}

	@Override
	public void validate(Object target, Errors errors) {
//		ExpectationBean expectation = (ExpectationBean)target;
		ValidationUtils.rejectIfEmptyOrWhitespace
			(errors, "expective", "","必選!");

	}

}
