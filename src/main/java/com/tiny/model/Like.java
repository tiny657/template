package com.tiny.model;

import java.util.Date;

public class Like {
  private String providerUserId;
  private Integer documentId;
  // true : like
  // false : dislike
  private Boolean isLike;
  private Date regDate;

  public String getProviderUserId() {
    return providerUserId;
  }

  public void setProviderUserId(String providerUserId) {
    this.providerUserId = providerUserId;
  }

  public Integer getDocumentId() {
    return documentId;
  }

  public void setDocumentId(Integer documentId) {
    this.documentId = documentId;
  }

  public Boolean getIsLike() {
    return isLike;
  }

  public void setIsLike(Boolean isLike) {
    this.isLike = isLike;
  }

  public Date getRegDate() {
    return regDate;
  }

  public void setRegDate(Date regDate) {
    this.regDate = regDate;
  }
}
