package com.demo.microservices.exchange.controller.dto;

import com.demo.microservices.exchange.domain.Exchange;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
 @Builder
 @NoArgsConstructor
public class ExchangeDto {
  String curUnit; // USD,
  String baseDt;
  String ttb;      //292.56 보낼때
  String tts;      //:"298.46", 받을 떄
  String deal_bas_r;  //":"295.51" 매매 기준율
  String cur_nm;  //":"아랍에미리트 디르함"   

  public ExchangeDto(String cur_unit, String base_dt, String ttb, String tts, String deal_bas_r,String cur_nm) {
 
    this.curUnit = cur_unit;
    this.baseDt = base_dt;
    this.tts = tts;
    this.ttb = ttb;
    this.deal_bas_r = deal_bas_r;
    this.cur_nm = cur_nm;
  }

  public Exchange toExchange() {
    return new Exchange(curUnit, baseDt, ttb, tts, deal_bas_r, cur_nm); 
  }
}
