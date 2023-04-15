package app.core.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.core.antities.Coupon;
import app.core.antities.Customer;
import app.core.repos.CouponRepo;
import app.core.repos.CustomerRepo;

@Service
@Transactional
public class AppService {
	@Autowired
	private CustomerRepo customerRepo;
	@Autowired
	private CouponRepo couponRepo;

	public void purchaseCoupon(int customerId, int couponId) {
		Optional<Customer> optCustomer = customerRepo.findById(customerId);
		Optional<Coupon> optCoupon = couponRepo.findById(couponId);
		if (optCoupon.isPresent() && optCustomer.isPresent()) {
			Customer customer = optCustomer.get();
			Coupon coupon = optCoupon.get();
			customer.addCoupon(coupon);
		} else {
			throw new RuntimeException("purchaseCoupon faild - customer or coupon not found");
		}
	}
}
