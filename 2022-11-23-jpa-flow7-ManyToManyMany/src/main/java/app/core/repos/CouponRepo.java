package app.core.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import app.core.antities.Coupon;

public interface CouponRepo extends JpaRepository<Coupon, Integer> {

}
