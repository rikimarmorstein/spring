package app.core.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect2 {

	@Before("execution(void buyCoupon(int))")
	public void beforeBye() {
		System.out.println(">>> before buy");
	}

}
