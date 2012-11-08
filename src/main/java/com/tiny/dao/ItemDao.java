package com.tiny.dao;

import com.tiny.model.Item;

public interface ItemDao {
	public void save(Item item);
	public Item get(Integer itemId);
}