package com.pms.app.util;

import org.joda.time.DateTime;

public class CodeUtils {
	
	public static String getInsRecordCode(){
		return "RK" + new DateTime().toString("yyyyMMddHHmmss");
	}
}
