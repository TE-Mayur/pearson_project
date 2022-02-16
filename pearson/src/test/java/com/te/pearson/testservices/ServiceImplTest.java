package com.te.pearson.testservices;

import static org.mockito.Mockito.mock;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.Store;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.opencsv.CSVReader;
import com.te.pearson.beans.StoresBean;
import com.te.pearson.services.StoresServicesImpl;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class ServiceImplTest {

	CSVReader reader;
	@InjectMocks
	private StoresServicesImpl service;

	public ServiceImplTest() {
		reader = mock(CSVReader.class);
	}

	@Test
	void testGetStoreById() throws IOException {
		StoresBean store = new StoresBean();
		store.setAddress("guindy");
		store.setCity("chennai");
		store.setStore_id("1525eec4-7bed-4597-bf5a-e06fcede5f4f");
		store.setNo_of_days(53153453354354L);
		store.setOpened_date("12-05-1995");
		store.setPost_code("600077");

		assertEquals("1525eec4-7bed-4597-bf5a-e06fcede5f4f", service.getData(store.getStore_id()).getStore_id());
	}

}
