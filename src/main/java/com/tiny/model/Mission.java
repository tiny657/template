package com.tiny.model;

public class Mission {
  private Integer missionId;
  private Integer condition;
  private String desc;

  public Integer getMissionId() {
    return missionId;
  }

  public void setMissionId(Integer missionId) {
    this.missionId = missionId;
  }

  public Integer getCondition() {
    return condition;
  }

  public void setCondition(Integer condition) {
    this.condition = condition;
  }

  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }
}
