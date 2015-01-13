package com.tiny.model;

import java.util.Date;

public class Document {
  private Integer documentId;
  private String content;
  private Integer point;
  private Integer like;
  private Integer dislike;
  private Integer comment;
  private Integer sharing;
  private String providerUserId;
  private String name;
  private Date regDate;

  // from Like
  private Boolean hasMyLike;
  private Boolean hasMyDislike;

  // undo xssFilter
  private String rawContent;

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

  public Integer getPoint() {
    return point;
  }

  public void setPoint(Integer point) {
    this.point = point;
  }

  public Integer getLike() {
    return like;
  }

  public void setLike(Integer like) {
    this.like = like;
  }

  public Integer getDislike() {
    return dislike;
  }

  public void setDislike(Integer dislike) {
    this.dislike = dislike;
  }

  public Integer getComment() {
    return comment;
  }

  public void setComment(Integer comment) {
    this.comment = comment;
  }

  public Integer getSharing() {
    return sharing;
  }

  public void setSharing(Integer sharing) {
    this.sharing = sharing;
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

  public Date getRegDate() {
    return regDate;
  }

  public void setRegDate(Date regDate) {
    this.regDate = regDate;
  }

  public Boolean getHasMyLike() {
    return hasMyLike;
  }

  public void setHasMyLike(Boolean hasMyLike) {
    this.hasMyLike = hasMyLike;
  }

  public Boolean getHasMyDislike() {
    return hasMyDislike;
  }

  public void setHasMyDislike(Boolean hasMyDislike) {
    this.hasMyDislike = hasMyDislike;
  }

  public String getRawContent() {
    return rawContent;
  }

  public void setRawContent(String rawContent) {
    this.rawContent = rawContent;
  }
}
