package com.somnus.validation;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.hibernate.validator.HibernateValidator;
import org.hibernate.validator.messageinterpolation.ResourceBundleMessageInterpolator;
import org.hibernate.validator.resourceloading.PlatformResourceBundleLocator;
import org.junit.Test;

import com.somnus.validation.model.User;

@SuppressWarnings("unused")
public class ValidationTest {
	
	@Test
	public void defaultValidator(){
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		User user = new User("adm#in","12345");
		Set<ConstraintViolation<User>> constraintViolations = validator.validate(user);
		for(ConstraintViolation<User> data:constraintViolations){
			System.out.println(data.getPropertyPath().toString() + data.getMessage());
		}
	}
	
	@Test
	public void hibernateValidator(){
		Validator validator = Validation.byProvider(HibernateValidator.class).configure()
				/*.messageInterpolator(new ResourceBundleMessageInterpolator(new PlatformResourceBundleLocator("message/validate")))*/
				/*.failFast(true)*/
				.buildValidatorFactory().getValidator();
		User user = new User("adm#in","12345");
		Set<ConstraintViolation<User>> constraintViolations = validator.validate(user);
		for(ConstraintViolation<User> data:constraintViolations){
			System.out.println(data.getPropertyPath().toString() + data.getMessage());
		}
	}
	
}
