package com.te.pearson.services;

import java.util.List;

import com.te.pearson.beans.StoresBean;

public interface StoresService {

	public List<StoresBean> fetch(String option);

	public StoresBean getData(String store_id);
}
