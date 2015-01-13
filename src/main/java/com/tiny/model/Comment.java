package com.tiny.model;

import java.util.Date;

public class Comment {
  private Integer commentId;
  private Integer documentId;
  private String content;
  private String providerUserId;
  private String name;
  private Boolean isMyDoc;
  private Date regDate;

  public Integer getCommentId() {
    return commentId;
  }

  public void setCommentId(Integer commentId) {
    this.commentId = commentId;
  }

  public Integer getDocumentId() {
    return documentId;
  }

  public void setDocumentId(Integer documentId) {
    this.documentId = documentId;
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

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Boolean getIsMyDoc() {
    return isMyDoc;
  }

  public void setIsMyDoc(Boolean isMyDoc) {
    this.isMyDoc = isMyDoc;
  }

  public Date getRegDate() {
    return regDate;
  }

  public void setRegDate(Date regDate) {
    this.regDate = regDate;
  }

}
