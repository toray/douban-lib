package com.toraysoft.lib.douban;

import org.json.JSONObject;

import android.content.Context;

import com.toraysoft.tools.rest.RestCallback.OnResponseCallback;
import com.toraysoft.tools.rest.RestParameter;

public class DoubanMovieHelper extends DoubanHelper {

	static DoubanMovieHelper instance;

	protected DoubanMovieHelper(Context context) {
		super(context);
	}

	public static DoubanMovieHelper get(Context context) {
		if (instance == null) {
			instance = new DoubanMovieHelper(context);
		}
		return instance;
	}

	public void search(String text, OnResponseCallback<JSONObject> l) {
		search(text, 0, 0, l);
	}

	public void search(String text, int start, int size,
			OnResponseCallback<JSONObject> l) {
		if (size == 0)
			size = DEFAULT_SIZE;

		RestParameter params = new RestParameter();
		params.add("start", "" + start);
		params.add("count", "" + size);
		params.add("q", text);

		client.doGet("v2/movie/search", params, l);
	}

	public void getInfoById(String id, OnResponseCallback<JSONObject> l) {
		RestParameter params = new RestParameter();
		client.doGet("v2/movie/" + id, params, l);
	}

	public void getTop250(OnResponseCallback<JSONObject> l) {
		RestParameter params = new RestParameter();
		client.doGet("v2/movie/top250", params, l);
	}
}
