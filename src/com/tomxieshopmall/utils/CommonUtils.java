package com.tomxieshopmall.utils;

import java.util.UUID;

public class CommonUtils {

	/**
	 * public method to generate uuid
	 * 
	 * @return
	 */
	public static String getUuid() {

		return UUID.randomUUID().toString();
	}

}
