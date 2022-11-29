package com.demo.microservices.exchange.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.microservices.exchange.domain.Exchange;
import com.demo.microservices.exchange.repository.ExchangeRepository;

@Service 
public class ExchangeService {
  @Autowired 
  ExchangeRepository exchangeRepository;
  
  public List<Exchange> findByAll() {
    return exchangeRepository.findAll();
  }

  public Exchange findById(Long Id) {
    Optional<Exchange> exchange = exchangeRepository.findById(Id);

    if (exchange.isPresent()) {
      return exchange.get();
    }

    return null;
  }
  public Exchange findByCurUnit(String curUnit) {
    Exchange exchange = exchangeRepository.findByCur_unit(curUnit);

    return exchange;
  }

  public boolean saveExchange(Exchange exchange) {
  
    Exchange exch = exchangeRepository.save(exchange);

    if (exch != null) {
      return true;
    } else {
      return false;
    }
  }

  public boolean upSertExchange(Exchange exchange) {
  
    Exchange exch = findById(exchange.getId());

    if (exch != null) {
      return saveExchange(exchange);
    } else {
      return false;
    }
  }  

  public boolean deleteExchange(Long id) {
  
    Exchange exch = findById(id);

    if (exch != null) {
      exchangeRepository.delete(exch);
      return true;
    } else {
      return false;
    } 

  }  
}
