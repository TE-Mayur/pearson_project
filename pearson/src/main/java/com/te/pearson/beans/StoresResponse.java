package com.te.pearson.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StoresResponse {

	private Boolean error;

	private Object data;
}
