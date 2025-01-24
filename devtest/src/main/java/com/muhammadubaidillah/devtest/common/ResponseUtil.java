package com.muhammadubaidillah.devtest.common;

import com.muhammadubaidillah.devtest.dto.BooleanResponse;

import io.vertx.core.json.JsonObject;

public class ResponseUtil {

	public Object id;
	public String code;
	public JsonObject result;
	public String status;
	
	public ResponseUtil() {

	}

	public static BooleanResponse response(JsonObject responseObject) {
		BooleanResponse booleanResponse = new BooleanResponse();
		if (responseObject.getString("code").equals("200")) {
			booleanResponse.status = Constant.SUCCESS;
			booleanResponse.data.result = true;
		} else if (responseObject.getString("code").equals("201"))  {
			booleanResponse.status = Constant.SUCCESS;
			booleanResponse.data.result = false;
		} else if (responseObject.getString("code").equals("500")) {
			booleanResponse.status = Constant.ERROR;
			booleanResponse.data.result = false;
		} else {
			booleanResponse.status = Constant.NOT_FOUND;
			booleanResponse.data.result = false;
		}
		return booleanResponse;
	}

}
