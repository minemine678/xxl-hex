package com.xxl;

import com.xxl.demo.msg.DemoRequest;
import com.xxl.hex.handler.response.HexResponse;
import com.xxl.hex.remote.client.HexClient;
import com.xxl.hex.serialise.JacksonUtil;

import java.lang.reflect.InvocationTargetException;

public class DemoTest {

	private static final String BASE_URL = "http://localhost:8080/hex";
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {

		// 封装参数
		DemoRequest demoRequest = new DemoRequest();
		demoRequest.setA(1);
		demoRequest.setB(2);

		String mapping = "demohandler";

		HexResponse.SimpleHexResponse demoResponse = (HexResponse.SimpleHexResponse) HexClient.handle(BASE_URL, mapping, demoRequest, HexResponse.SimpleHexResponse.class);

		System.out.println(JacksonUtil.writeValueAsString(demoResponse));

	}

}
