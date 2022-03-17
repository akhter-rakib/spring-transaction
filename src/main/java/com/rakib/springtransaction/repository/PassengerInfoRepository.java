package com.rakib.springtransaction.repository;

import com.rakib.springtransaction.entity.PassengerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerInfoRepository extends JpaRepository<PassengerInfo, Long> {
}
