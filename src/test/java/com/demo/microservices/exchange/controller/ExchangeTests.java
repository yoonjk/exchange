package com.demo.microservices.exchange.controller;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.CoreMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.demo.microservices.exchange.domain.Exchange;
import com.demo.microservices.exchange.service.ExchangeService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest
public class ExchangeTests {
	@Autowired 
	private MockMvc mockMvc;

	@MockBean 
	ExchangeService exchangeService;

	@Autowired 
	private ObjectMapper objectMapper;

	public void givenExchangeObject_whenAllExchange_thenReturnExchangeList() throws Exception {
		List<Exchange> listOfExchange = new ArrayList();

		listOfExchange.add(
			Exchange.builder()
				.base_dt("20221219")
				.cur_nm("USD")
				.cur_unit("USD")
				.build());

		given(exchangeService.exchangeAll()).willReturn(listOfExchange);

		ResultActions response = mockMvc.perform(get("/exchange"));
		
		response.andExpect(MockMvcResultMatchers.status().isOk())
			.andDo(MockMvcResultHandlers.print())
			.andExpect(MockMvcResultMatchers.jsonPath("$.size()", CoreMatchers.is(listOfExchange.size())));
	}
}
