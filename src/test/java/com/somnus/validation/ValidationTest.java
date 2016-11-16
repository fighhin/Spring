package com.somnus.validation;

import java.text.ParseException;
import java.util.Date;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.apache.commons.lang3.time.DateUtils;
import org.hibernate.validator.HibernateValidator;
import org.hibernate.validator.messageinterpolation.ResourceBundleMessageInterpolator;
import org.hibernate.validator.resourceloading.PlatformResourceBundleLocator;
import org.junit.Test;

import com.somnus.validation.model.User;

@SuppressWarnings("unused")
public class ValidationTest {
	
	@Test
	public void defaultValidator() throws ParseException{
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		User user = new User("admin","123456",DateUtils.parseDate("2014-11-11", new String[] {"yyyy-MM-dd"}));
		Set<ConstraintViolation<User>> constraintViolations = validator.validate(user);
		for(ConstraintViolation<User> data:constraintViolations){
			System.out.println(data.getPropertyPath().toString() + ":" + data.getMessage());
		}
	}
	
	@Test
	public void hibernateValidator(){
		Validator validator = Validation.byProvider(HibernateValidator.class).configure()
				/*.messageInterpolator(new ResourceBundleMessageInterpolator(new PlatformResourceBundleLocator("message/validate")))*/
				/*.failFast(true)*/
				.buildValidatorFactory().getValidator();
		User user = new User("adm#in","12345",new Date());
		Set<ConstraintViolation<User>> constraintViolations = validator.validate(user);
		for(ConstraintViolation<User> data:constraintViolations){
			System.out.println(data.getPropertyPath().toString() + ":" + data.getMessage());
		}
	}
	
}
