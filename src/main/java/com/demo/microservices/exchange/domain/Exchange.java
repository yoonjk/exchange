package com.demo.microservices.exchange.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.demo.microservices.exchange.controller.dto.ExchangeDto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor

public class Exchange {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;
  String cur_unit; // USD,
  String exch_dt;
  String ttb;      //292.56 보낼때
  String tts;      //:"298.46", 받을 떄
  String deal_bas_r;  //":"295.51" 매매 기준율
  String bkpr;     //":"295",      장부가격
  String yy_efee_r;  //":null격
  String ten_dd_efee_r;  //":null,
  String kftc_bkpr;  //":"295",
  String kftc_deal_bas_r;  //":"295.51",
  String cur_nm;  //":"아랍에미리트 디르함"


  @Builder
  public Exchange(Long id, String cur_unit, String ttb, String tts, String deal_bas_r, String bkpr, String yy_efee_r, String ten_dd_efee_r, String kftc_bkpr, String kftc_deal_bas_r, String cur_nm) {
    this.id = id;
    this.cur_unit = cur_unit;
    this.ttb = ttb;
    this.tts = tts;
    this.deal_bas_r = deal_bas_r;
    this.bkpr = bkpr;
    this.yy_efee_r = yy_efee_r;
    this.ten_dd_efee_r = ten_dd_efee_r;
    this.kftc_bkpr = kftc_bkpr;
    this.kftc_deal_bas_r = kftc_deal_bas_r;
    this.cur_nm = cur_nm;
  }
  public ExchangeDto toExchangeDto() {
    return new ExchangeDto(id, cur_unit, ttb, tts, deal_bas_r, bkpr, yy_efee_r, ten_dd_efee_r, kftc_bkpr, kftc_deal_bas_r, cur_nm);
  }
}
