package app.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import app.core.antities.Coupon;
import app.core.antities.Customer;
import app.core.repos.CouponRepo;
import app.core.repos.CustomerRepo;

//@Component
public class Test1 implements CommandLineRunner {

	@Autowired
	private CouponRepo couponRepo;
	@Autowired
	private CustomerRepo customerRepo;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Test 1");

		Coupon coupon1 = new Coupon(0, "aaa", 5, null);
		Coupon coupon2 = new Coupon(0, "bbb", 5, null);
		Coupon coupon3 = new Coupon(0, "ccc", 5, null);
		Coupon coupon4 = new Coupon(0, "ddd", 5, null);

		Customer customer1 = new Customer(0, "Kela", 18, null);
		Customer customer2 = new Customer(0, "Dani", 23, null);

		try {

			couponRepo.save(coupon1);
			couponRepo.save(coupon2);
			couponRepo.save(coupon3);
			couponRepo.save(coupon4);

			customerRepo.save(customer1);
			customerRepo.save(customer2);

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

}
