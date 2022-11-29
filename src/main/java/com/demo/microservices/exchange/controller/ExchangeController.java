package com.demo.microservices.exchange.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.microservices.exchange.controller.dto.ExchangeDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class ExchangeController {
  @GetMapping("/")
  public ExchangeDto hello() {
    return ExchangeDto.builder()
    .id(1L)
    .cur_unit("USD")
    .tts("298.46")
    .ttb("292.56") 
    .deal_bas_r("295.51")
    .bkpr("295")
    .yy_efee_r("") 
    .ten_dd_efee_r("")
    .kftc_bkpr("295")
    .build();
  }
}
