package app.core.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.core.security.LoginHoures;

@Component
@Aspect
public class HouresAspect {

	@Autowired
	private LoginHoures loginhoures;

	@Around("execution(* app.core.facades.*.*(..))")
	public Object loginAdvice(ProceedingJoinPoint jp) throws Throwable {
		if (loginhoures.isLogged()) {
			return jp.proceed();
		} else {
			throw new RuntimeException("The system is not active at this time");
		}
	}

}
