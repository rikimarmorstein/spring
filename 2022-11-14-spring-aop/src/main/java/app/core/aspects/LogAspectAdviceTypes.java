package app.core.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

//@Component
@Aspect
public class LogAspectAdviceTypes {

	@Before("execution(* *add*(..))")
	public void before(JoinPoint jp) {
		System.out.println("\t@Before: " + jp.getSignature().getName());
	}

	@After("execution(* *add*(..))")
	public void after(JoinPoint jp) {
		System.out.println("\t@After: " + jp.getSignature().getName());
	}

	@AfterReturning(pointcut = "execution(* *add*(..))", returning = "count")
	public void afterReturning(JoinPoint jp, int count) {
		System.out.println("\t@AfterReturning: " + jp.getSignature().getName() + " retutning: " + count);
	}

	@AfterThrowing(pointcut = "execution(* *add*(..))", throwing = "e")
	public void afterThrowing(JoinPoint jp, Exception e) {
		System.out.println("\t@AfterThrowing: " + jp.getSignature().getName() + " Error: " + e);
	}

	@Around("execution(* *add*(..))")
	public Object around(ProceedingJoinPoint jp) throws Throwable {
		// before
		System.out.println("@Around - before " + jp.getSignature().getName());
		// business
		Object x;
		try {
			x = jp.proceed();
			// after
			System.out.println("@Around - after return: " + jp.getSignature().getName());
			// return what the business returned or handle an exception
			return x;
		} catch (Exception e) {
			System.out.println("@Around - after throw: " + jp.getSignature().getName());
			throw e;
		}
	}
}
