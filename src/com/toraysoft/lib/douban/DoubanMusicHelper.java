package com.toraysoft.lib.douban;

import org.json.JSONObject;

import android.content.Context;

import com.toraysoft.tools.rest.RestCallback.OnResponseCallback;
import com.toraysoft.tools.rest.RestParameter;

public class DoubanMusicHelper extends DoubanHelper {

	static DoubanMusicHelper instance;
	
	protected DoubanMusicHelper(Context context) {
		super(context);
	}
	
	public static DoubanMusicHelper get(Context context){
		if(instance==null){
			instance = new DoubanMusicHelper(context);
		}
		return instance;
	}

	public void search(String text, OnResponseCallback<JSONObject> l){
		search(text, 0, 0, l);
	}
	
	public void search(String text, int start, int size, OnResponseCallback<JSONObject> l){
		if(size == 0)
			size = DEFAULT_SIZE;
		
		RestParameter params = new RestParameter();
		params.add("start", "" + start);
		params.add("count", "" + size);
		params.add("q", text);

		client.doGet("v2/music/search", params, l);
	}
	
	
	public void getInfoById(String id, OnResponseCallback<JSONObject> l){
		RestParameter params = new RestParameter();
		client.doGet("v2/music/"+id, params, l);
	}
}
