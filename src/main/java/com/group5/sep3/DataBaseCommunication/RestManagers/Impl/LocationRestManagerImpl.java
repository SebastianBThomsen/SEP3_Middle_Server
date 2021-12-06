package com.group5.sep3.DataBaseCommunication.RestManagers.Impl;

import com.google.gson.reflect.TypeToken;
import com.group5.sep3.BusinessLogic.model.Location;
import com.group5.sep3.DataBaseCommunication.RestClientImpl;
import com.group5.sep3.DataBaseCommunication.RestManagers.RestManager;
import com.group5.sep3.util.JsonHelper;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;

public class LocationRestManagerImpl implements RestManager<Location> {

	@Override
	public Location put(Location obj) {
		String restUrl = obj.getClass().getSimpleName();
		String tmp = (String) RestClientImpl.getInstance().put(restUrl, obj);

		return JsonHelper.fromJson(tmp, Location.class);
	}

	@Override
	public Location post(Location obj) {
		String restUrl = obj.getClass().getSimpleName();
		String tmp = (String) RestClientImpl.getInstance().post(restUrl, obj);

		return JsonHelper.fromJson(tmp, Location.class);
	}

	@Override
	public Location get(Location obj) {
		String restUrl = obj.getClass().getSimpleName() + "/" + obj.getId();
		Object restResponse = RestClientImpl.getInstance().get(restUrl);

		return JsonHelper.fromJson((String) restResponse, Location.class);
	}

	@Override
	public Collection<Location> getAll() {
		String restUrl = Location.class.getSimpleName();
		String jsonString = (String) RestClientImpl.getInstance().get(restUrl);
		Type type = new TypeToken<ArrayList<Location>>() {
		}.getType();

		return JsonHelper.fromJson(jsonString, type);
	}

	@Override
	public Location delete(Location obj) {
		String restUrl = Location.class.getSimpleName() + "/" + obj.getId();

		return RestClientImpl.getInstance().delete(restUrl) ? obj : null;
	}
}
