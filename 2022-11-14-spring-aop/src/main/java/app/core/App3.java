package app.core;

import java.time.LocalDateTime;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import app.core.facades.CompanyFacade;
import app.core.facades.CustomerFacade;
import app.core.security.LoginHoures;
import app.core.security.LoginManager;

public class App3 {

	public static void main(String[] args) {

		try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);) {

			CompanyFacade companyFacade = ctx.getBean(CompanyFacade.class);
			CustomerFacade customerFacade = ctx.getBean(CustomerFacade.class);
			LoginManager loginManager = ctx.getBean(LoginManager.class);
			LoginHoures logh = ctx.getBean(LoginHoures.class);
			logh.login(LocalDateTime.now());
			// loginManager.login("123");
			companyFacade.addCoupon();
			companyFacade.removeCoupon(109);

			customerFacade.buyCoupon(500);
			customerFacade.buyCoupon(500);
			customerFacade.buyCoupon(500);
			customerFacade.useCoupon(500);
			customerFacade.useDiscount();
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

}
