package com.te.pearson.testbeans;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.te.pearson.beans.StoresBean;

public class StoresTest {

	String json = "{\"store_id\":\"15\",\"post_code\":\"600077\",\"city\":\"chennai\",\"address\":\"guindy\",\"opened_date\":null,\"no_of_days\":null}";
	ObjectMapper mapper = new ObjectMapper();

	@Test
	void test() throws JsonProcessingException, ParseException {
		StoresBean store = new StoresBean();
		store.setAddress("guindy");
		store.setCity("chennai");
		store.setStore_id("15");
		store.setPost_code("600077");

		System.out.println(mapper.writeValueAsString(store));

		StoresBean readValue = mapper.readValue(json, StoresBean.class);

		assertEquals(json, mapper.writeValueAsString(readValue));
	}

}
