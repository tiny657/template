package com.tiny.model;

public class Item {
  private Integer itemId;
  private String name;
  private Integer condition;
  private Integer price;
  private String desc;

  public Integer getItemId() {
    return itemId;
  }

  public void setItemId(Integer itemId) {
    this.itemId = itemId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getCondition() {
    return condition;
  }

  public void setCondition(Integer condition) {
    this.condition = condition;
  }

  public Integer getPrice() {
    return price;
  }

  public void setPrice(Integer price) {
    this.price = price;
  }

  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }
}
