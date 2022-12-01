package com.demo.microservices.exchange.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.microservices.exchange.dao.CommonDao;
import com.demo.microservices.exchange.domain.Exchange;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service 
public class ExchangeService {
  @Autowired 
  CommonDao commonDao;
 
  public int bulkLoadExchange(List<Exchange> list) {
    int count = 0;
    Map<String, Object> map = new HashMap<>();
    map.put("list", list);
    try { 
    // 실행 결과 row 갯수를 리턴합니다.
      count += commonDao.insert("bulkloadExchange", map);
  } catch ( Exception e) {
    throw new RuntimeException(e);
  }
  return count;
}
  public List<Exchange> findByCurUnit(String curUnit, String startDate, String endDate) {
    List<Exchange> exchangeList= new ArrayList<Exchange>();
    HashMap<String, Object> params = new HashMap<String, Object>();
    try {
      // startPage = 1 ~ ..
  
      params.put("curUnit", curUnit);
      params.put("startDate", startDate );
      params.put("endDate", endDate);

      
      exchangeList = commonDao.selectList("findByCurUnit", params);
      log.info("exchangeList:{}", exchangeList);
    } catch ( Exception e) {
      throw new RuntimeException(e);
    }
    return exchangeList;
  }


  public List<Exchange> searchCurUnit(String curUnit, int pageNo, int pageSize) {
    List<Exchange> exchangeList= new ArrayList<Exchange>();
    HashMap<String, Object> params = new HashMap<String, Object>();
    int page = 0;
    try {
      // startPage = 1 ~ ..
      page = (Integer.valueOf(pageNo) - 1) * Integer.valueOf(pageSize);
      
      if (page < 1) 
        page = 1;

      params.put("cur_unit", curUnit);
      params.put("page_no", page );
      params.put("page_size", Integer.valueOf(pageSize));
      exchangeList = commonDao.selectList("searchCurUnit", params);
    } catch ( Exception e) {
      throw new RuntimeException(e);
    }
    return exchangeList;
  }


  public int upSertExchange(Exchange exchange) {
  
    int rc = 0;
    try {
      rc = commonDao.insert("upsertExchange", exchange);
    } catch ( Exception e) {
      throw new RuntimeException(e);
    }
    return rc;
  }  

  public int deleteExchange(String curUnit, String baseDate) {
  
    int rc = 0;
    Exchange exchange = Exchange.builder()
                          .cur_unit(curUnit)
                          .base_dt(baseDate)
                          .build();
    try {
      rc = commonDao.delete("deleteExchange", exchange);
    } catch ( Exception e) {
      throw new RuntimeException(e);
    }
    return rc;

  }  
}
