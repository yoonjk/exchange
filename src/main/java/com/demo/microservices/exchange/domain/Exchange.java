package com.demo.microservices.exchange.domain;

import java.io.Serializable;

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
public class Exchange implements Serializable{
  String curUnit; // USD,
  String baseDt;
  String ttb;      //292.56 보낼때
  String tts;      //:"298.46", 받을 떄
  String dealBasR;  //":"295.51" 매매 기준율
  String curNm;  //":"아랍에미리트 디르함"


  @Builder
  public Exchange(String cur_unit, String base_dt, String ttb, String tts, String deal_bas_r, String cur_nm) {
    this.curUnit = cur_unit;
    this.baseDt = base_dt;
    this.ttb = ttb;
    this.tts = tts;
    this.dealBasR = deal_bas_r;
    this.curNm = cur_nm;
  }
}
