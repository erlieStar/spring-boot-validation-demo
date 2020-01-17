package com.javashitang.util;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

public class CommonUtil {

		public static String getErrorResult(Object o, Class<?>... groups) {
				StringBuilder errorMsg = new StringBuilder();
				ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
				Validator validator = vf.getValidator();
				Set<ConstraintViolation<Object>> set = validator.validate(o, groups);
				for(ConstraintViolation<Object> constraintViolation : set) {
						errorMsg.append(constraintViolation.getMessage()).append(" ");
				}
				return errorMsg.toString();
		}
}
