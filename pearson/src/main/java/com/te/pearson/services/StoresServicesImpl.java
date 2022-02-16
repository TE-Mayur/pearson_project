package com.te.pearson.services;

import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;
import com.te.pearson.beans.StoresBean;
import com.te.pearson.customexceptions.CustomException;

@Service
public class StoresServicesImpl implements StoresService {

	@Override
	public List<StoresBean> fetch(String option) {

		List<StoresBean> beans = new ArrayList<StoresBean>();

		Map<String, String> map = new HashMap<String, String>();
		map.put("Store Id", "store_id");
		map.put("Post Code", "post_code");
		map.put("City", "city");
		map.put("Address", "address");
		map.put("Opened Date", "opened_date");

		HeaderColumnNameTranslateMappingStrategy<StoresBean> strategy = new HeaderColumnNameTranslateMappingStrategy<StoresBean>();
		strategy.setType(StoresBean.class);
		strategy.setColumnMapping(map);
		CSVReader reader = null;
		try {
			reader = new CSVReader(new FileReader("src/main/resources\\stores.csv"));

		} catch (Exception e) {
			throw new CustomException("Data is not present");
		}
		CsvToBean<StoresBean> bean = new CsvToBean<StoresBean>();
		@SuppressWarnings("deprecation")
		List<StoresBean> list = bean.parse(strategy, reader);

		for (StoresBean storesBean : list) {
			Date from = null;
			try {
				from = new SimpleDateFormat("dd-MM-yyyy").parse(storesBean.getOpened_date());
				Date untill = new Date();

				long durationInMillies = Math.abs(untill.getTime() - from.getTime());
				long duration = TimeUnit.DAYS.convert(durationInMillies, TimeUnit.MILLISECONDS);

				storesBean.setNo_of_days(duration);

			} catch (ParseException e) {
				e.printStackTrace();
			}
		}

		if (option.equalsIgnoreCase("city")) {
			beans = list.stream().sorted((a, b) -> a.getCity().compareTo(b.getCity())).collect(Collectors.toList());
		} else if (option.equalsIgnoreCase("city")) {
			beans = null;
		}
		return beans;

	}

	@Override
	public StoresBean getData(String store_id) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("Store Id", "store_id");
		map.put("Post Code", "post_code");
		map.put("City", "city");
		map.put("Address", "address");
		map.put("Opened Date", "opened_date");

		HeaderColumnNameTranslateMappingStrategy<StoresBean> strategy = new HeaderColumnNameTranslateMappingStrategy<StoresBean>();
		strategy.setType(StoresBean.class);
		strategy.setColumnMapping(map);
		CSVReader reader = null;
		try {
			reader = new CSVReader(new FileReader("src/main/resources\\stores.csv"));

		} catch (Exception e) {
			throw new CustomException("Data is not present");
		}
		CsvToBean<StoresBean> bean = new CsvToBean<StoresBean>();
		@SuppressWarnings("deprecation")
		List<StoresBean> list = bean.parse(strategy, reader);

		StoresBean result = null;
		for (StoresBean bean2 : list) {
			if (bean2.getStore_id().equals(store_id)) {
				result = bean2;
			}
		}
		if (result != null) {
			return result;
		} else {
			throw new CustomException("Provided id is wrong .. Please try again");
		}
	}

}
