package com.group5.sep3.DataBaseCommunication.RestManagers.Impl;

import com.google.gson.reflect.TypeToken;
import com.group5.sep3.BusinessLogic.model.Item;
import com.group5.sep3.DataBaseCommunication.RestClientImpl;
import com.group5.sep3.DataBaseCommunication.RestManagers.RestManager;
import com.group5.sep3.util.JsonHelper;
import com.group5.sep3.util.ProjectUtil;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;

public class ItemRestManagerImpl implements RestManager<Item> {


    @Override
    public Item put(Item obj) {

        String restUrl = obj.getClass().getSimpleName();

        RestClientImpl.getInstance().put(restUrl, obj);

        return obj;
    }

    @Override
    public Item post(Item obj) {
        ProjectUtil.notImplemented();
        return null;
    }

    @Override
    public Item get(Item obj) {
        String restUrl = obj.getClass().getSimpleName() + "/" + obj.getId();
        Object restResponse = RestClientImpl.getInstance().get(restUrl);
        ProjectUtil.testPrint(restResponse.getClass() + "\n" + restResponse);
        return JsonHelper.fromJson((String) restResponse, Item.class);
    }

    @Override
    public Collection<Item> getAll() {

        String restUrl = Item.class.getSimpleName();

        String jsonString = (String) RestClientImpl.getInstance().get(restUrl);
        ProjectUtil.testPrint(jsonString);
        Type type = new TypeToken<ArrayList<Item>>(){}.getType();
        ArrayList<Item> items = JsonHelper.fromJson(jsonString, type);

        for (Item item : items) {
            System.out.println(item.getItemName());
        }

        return items;
    }


    @Override
    public Item delete(Item obj) {
        ProjectUtil.notImplemented();
        return null;
    }


}
