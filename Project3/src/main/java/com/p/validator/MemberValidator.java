package com.p.validator;

import org.springframework.stereotype.Component;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.p.model.MemberBean;


@Component
public class MemberValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
//		System.out.println(clazz.getName());
		boolean b = MemberBean.class.isAssignableFrom(clazz);
		return b;
	}

	@Override
	public void validate(Object target, Errors errors) {
		MemberBean member = (MemberBean)target;
		ValidationUtils.rejectIfEmptyOrWhitespace
			(errors, "account", "","帳號欄不能空白!");
		ValidationUtils.rejectIfEmptyOrWhitespace
			(errors, "name", "","姓名欄不能空白!");
		ValidationUtils.rejectIfEmptyOrWhitespace
			(errors, "password", "", "密碼欄位不能空白!");
		ValidationUtils.rejectIfEmptyOrWhitespace
			(errors, "uID", "", "身分證字號欄位不能空白!");
		ValidationUtils.rejectIfEmptyOrWhitespace
			(errors, "birth", "", "出生年月日欄位不能空白!");
		ValidationUtils.rejectIfEmptyOrWhitespace
			(errors, "mobile", "", "連絡電話欄位不能空白!");
		ValidationUtils.rejectIfEmptyOrWhitespace
			(errors, "email", "", "email欄位不能空白!");
		ValidationUtils.rejectIfEmptyOrWhitespace
			(errors, "address", "", "住址欄位不能空白!");
		
		if (member.getAccount().length()<8) {
			errors.rejectValue("account","", "帳號欄不能小於八個字元");
		}

	}

}
