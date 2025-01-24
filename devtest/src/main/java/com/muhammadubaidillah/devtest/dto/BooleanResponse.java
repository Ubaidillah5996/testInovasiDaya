package com.muhammadubaidillah.devtest.dto;

public class BooleanResponse {

	public Object status;
	public Data data;

	public class Data {

		public Boolean result;
		public String message;

		public Data() {

		}

	}

	public BooleanResponse() {
		this.data = new Data();
	}

}
