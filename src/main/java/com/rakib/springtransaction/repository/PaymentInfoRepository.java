package com.rakib.springtransaction.repository;

import com.rakib.springtransaction.entity.PaymentInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentInfoRepository extends JpaRepository<PaymentInfo, String> {
}
