package app.core.facades;

import org.springframework.stereotype.Component;

import app.core.annotations.MyAnnotation;

@Component
public class CompanyFacade {

	public int addCoupon() {
		if (Math.random() < 0.5) {

			System.out.println("coupon added");
			return (int) (Math.random() * 101);
		} else {
			throw new RuntimeException("addCoupon failed");
		}
	}

	@MyAnnotation
	public void removeCoupon(int id) {

		System.out.println("coupon " + id + " remove");
	}

}
