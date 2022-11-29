package com.demo.microservices.exchange.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.microservices.exchange.domain.Exchange;

public interface ExchangeRepository extends JpaRepository<Exchange, Long>{
  public Exchange findByCur_unit(String curUnit);
}
