package com.demo.microservices.exchange.controller;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.microservices.exchange.controller.dto.ExchangeDto;
import com.demo.microservices.exchange.domain.Exchange;
import com.demo.microservices.exchange.service.ExchangeService;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class ExchangeController {
  @Autowired 
  ExchangeService exchangeService;
  
  @ApiOperation(value = "dummy", notes = "display dummy data")
  @GetMapping("/")
  public ExchangeDto hello() {
    return ExchangeDto.builder()
    .curUnit("USD")
    .baseDt("yyyymmdd")
    .tts("298.46")
    .ttb("292.56") 
    .dealBasR("295.51")
    .curNm("dollar")
    .build();
  }
  @ApiOperation(value = "search Cur Unit and expose API to APIC", notes = "search current from startDate to endDate")
  @GetMapping("/exchange/{curUnit}")
  public List<Exchange> findByCurUnit(@PathVariable String curUnit, 
  @RequestParam(value = "startDate", required = false) String startDate,
  @RequestParam(value = "endDate", required = false) String endDate) {
    return exchangeService.findByCurUnit(curUnit, startDate, endDate);
  }

  @ApiOperation(value = "search Cur Unit and expose API to APIC", notes = "Paging search")
  @GetMapping("/exchange/{curUnit}/{pageNo}")
  public List<Exchange> searchExchangeCurUnit(@PathVariable String curUnit, @PathVariable int pageNo, 
  @RequestParam(value = "pageSize", required = false, defaultValue="10") int pageSize) {
    return exchangeService.searchCurUnit(curUnit, pageNo, pageSize);
  }

  @PostMapping("/exchange")
  public ResponseEntity<String> addExchange(@RequestBody ExchangeDto exchangeDto) {
    Exchange exchange = exchangeDto.toExchange();
    exchangeService.upSertExchange(exchange);
    return new ResponseEntity<>("Success", HttpStatus.CREATED);
  }

  @PutMapping("/exchange")
  public ResponseEntity<String>  upsertExchange(@RequestBody ExchangeDto exchangeDto) {
    Exchange exchange = exchangeDto.toExchange();
    exchangeService.upSertExchange(exchange);
    return new ResponseEntity<>("Success", HttpStatus.CREATED);
  }

  @DeleteMapping("/exchange/{curUnit}/{baseDate}")
  public ResponseEntity<String> deleteExchange(@PathVariable String curUnit, @PathVariable String baseDate) {
    exchangeService.deleteExchange(curUnit, baseDate);
    return new ResponseEntity<>("Success", HttpStatus.OK);
  }
  @ApiOperation(value = "bulkload Exchange daily", notes = "bulkload Exchange daily")
  @DeleteMapping("/exchange/bulkload/{baseDate}")
  public ResponseEntity<String> bulkloadExchange(@RequestBody List<Exchange> bulkExchanges, @PathVariable String baseDate) {
    exchangeService.bulkLoadExchange(bulkExchanges);
    return new ResponseEntity<>("Success", HttpStatus.OK);
  }  
}