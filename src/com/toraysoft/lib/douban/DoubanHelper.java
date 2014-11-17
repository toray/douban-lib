package com.toraysoft.lib.douban;

import android.content.Context;

import com.toraysoft.tools.rest.RestClient;

public class DoubanHelper {

	protected static int DEFAULT_SIZE = 20;
	
	RestClient client;

	protected DoubanHelper(Context context){
		client = new RestClient(context, null);
		client.setDebug(true);
		client.setRestHost(DoubanConstant.host);
	}
}
