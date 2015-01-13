package com.tiny.model;

import java.util.Date;

public class MyDoc {
  private Integer myDocId;
  private String title;
  private String content;
  private String providerUserId;
  private String tag;
  private Boolean isGoal;
  private Date regDate;

  // undo xssFilter
  private String rawContent;

  public Integer getMyDocId() {
    return myDocId;
  }

  public void setMyDocId(Integer myDocId) {
    this.myDocId = myDocId;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getProviderUserId() {
    return providerUserId;
  }

  public void setProviderUserId(String providerUserId) {
    this.providerUserId = providerUserId;
  }

  public String getTag() {
    return tag;
  }

  public void setTag(String tag) {
    this.tag = tag;
  }

  public Boolean getIsGoal() {
    return isGoal;
  }

  public void setIsGoal(Boolean isGoal) {
    this.isGoal = isGoal;
  }

  public Date getRegDate() {
    return regDate;
  }

  public void setRegDate(Date regDate) {
    this.regDate = regDate;
  }

  public String getRawContent() {
    return rawContent;
  }

  public void setRawContent(String rawContent) {
    this.rawContent = rawContent;
  }
}
