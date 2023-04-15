package app.core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import app.core.aspects.StatisticalAspect;
import app.core.facades.CompanyFacade;
import app.core.facades.CustomerFacade;

public class App1 {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);

		CompanyFacade companyFacade = ctx.getBean(CompanyFacade.class);
		CustomerFacade customerFacade = ctx.getBean(CustomerFacade.class);

		companyFacade.addCoupon();
		companyFacade.removeCoupon(109);

		customerFacade.buyCoupon(500);
		customerFacade.buyCoupon(500);
		customerFacade.buyCoupon(500);
		customerFacade.useCoupon(500);
		customerFacade.useDiscount();

		// statistics
		System.out.println("stats: ");
		StatisticalAspect stat = ctx.getBean(StatisticalAspect.class);
		System.out.println("use: " + stat.getUseCount());
		System.out.println("buy: " + stat.getBuyCount());
		ctx.close();

	}

}
