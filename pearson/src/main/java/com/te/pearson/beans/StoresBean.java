package com.te.pearson.beans;

import java.io.Serializable;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StoresBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String store_id;
	
	private String post_code;

	private String city;

	private String address;

	@CsvDate(value = "dd-MM-yyyy") 
	private String opened_date;
	
	private Long no_of_days;
}
