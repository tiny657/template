package com.tiny.model;

import java.util.Date;
import java.util.List;

public class Member {
  private String providerUserId;
  private String name;
  private boolean gender;
  private String email;
  private Integer level;
  private Integer point;
  private Integer doc;
  private Integer comment;
  private Integer commentOnMyDoc;
  private Integer like;
  private Integer likeOnMyDoc;
  private Integer dislike;
  private Integer dislikeOnMyDoc;
  private Integer sharing;
  private Integer sharingOfMyDoc;
  private Integer chanceToDoc;
  private Integer chanceToComment;
  private Integer chanceToLike;
  private Integer chanceToDislike;
  private String locale;
  private Date regDate;
  private Date lastLoginDate;

  // from document, comment, like
  private Integer usageOfDoc;
  private Integer usageOfComment;
  private Integer usageOfLike;
  private Integer usageOfDislike;

  // from item, mission, docOnMember
  private List<DocOnMember> docsOnMember;
  private List<Item> items;
  private List<Mission> missions;

  // installed
  private Boolean isTemplateMember;

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

  public boolean isGender() {
    return gender;
  }

  public void setGender(boolean gender) {
    this.gender = gender;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Integer getLevel() {
    return level;
  }

  public void setLevel(Integer level) {
    this.level = level;
  }

  public Integer getPoint() {
    return point;
  }

  public void setPoint(Integer point) {
    this.point = point;
  }

  public Integer getDoc() {
    return doc;
  }

  public void setDoc(Integer doc) {
    this.doc = doc;
  }

  public Integer getComment() {
    return comment;
  }

  public void setComment(Integer comment) {
    this.comment = comment;
  }

  public Integer getCommentOnMyDoc() {
    return commentOnMyDoc;
  }

  public void setCommentOnMyDoc(Integer commentOnMyDoc) {
    this.commentOnMyDoc = commentOnMyDoc;
  }

  public Integer getLike() {
    return like;
  }

  public void setLike(Integer like) {
    this.like = like;
  }

  public Integer getLikeOnMyDoc() {
    return likeOnMyDoc;
  }

  public void setLikeOnMyDoc(Integer likeOnMyDoc) {
    this.likeOnMyDoc = likeOnMyDoc;
  }

  public Integer getDislike() {
    return dislike;
  }

  public void setDislike(Integer dislike) {
    this.dislike = dislike;
  }

  public Integer getDislikeOnMyDoc() {
    return dislikeOnMyDoc;
  }

  public void setDislikeOnMyDoc(Integer dislikeOnMyDoc) {
    this.dislikeOnMyDoc = dislikeOnMyDoc;
  }

  public Integer getSharing() {
    return sharing;
  }

  public void setSharing(Integer sharing) {
    this.sharing = sharing;
  }

  public Integer getSharingOfMyDoc() {
    return sharingOfMyDoc;
  }

  public void setSharingOfMyDoc(Integer sharingOfMyDoc) {
    this.sharingOfMyDoc = sharingOfMyDoc;
  }

  public Integer getChanceToDoc() {
    return chanceToDoc;
  }

  public void setChanceToDoc(Integer chanceToDoc) {
    this.chanceToDoc = chanceToDoc;
  }

  public Integer getChanceToComment() {
    return chanceToComment;
  }

  public void setChanceToComment(Integer chanceToComment) {
    this.chanceToComment = chanceToComment;
  }

  public Integer getChanceToLike() {
    return chanceToLike;
  }

  public void setChanceToLike(Integer chanceToLike) {
    this.chanceToLike = chanceToLike;
  }

  public Integer getChanceToDislike() {
    return chanceToDislike;
  }

  public void setChanceToDislike(Integer chanceToDislike) {
    this.chanceToDislike = chanceToDislike;
  }

  public String getLocale() {
    return locale;
  }

  public void setLocale(String locale) {
    this.locale = locale;
  }

  public Date getRegDate() {
    return regDate;
  }

  public void setRegDate(Date regDate) {
    this.regDate = regDate;
  }

  public Date getLastLoginDate() {
    return lastLoginDate;
  }

  public void setLastLoginDate(Date lastLoginDate) {
    this.lastLoginDate = lastLoginDate;
  }

  public Integer getUsageOfDoc() {
    return usageOfDoc;
  }

  public void setUsageOfDoc(Integer usageOfDoc) {
    this.usageOfDoc = usageOfDoc;
  }

  public Integer getUsageOfComment() {
    return usageOfComment;
  }

  public void setUsageOfComment(Integer usageOfComment) {
    this.usageOfComment = usageOfComment;
  }

  public Integer getUsageOfLike() {
    return usageOfLike;
  }

  public void setUsageOfLike(Integer usageOfLike) {
    this.usageOfLike = usageOfLike;
  }

  public Integer getUsageOfDislike() {
    return usageOfDislike;
  }

  public void setUsageOfDislike(Integer usageOfDislike) {
    this.usageOfDislike = usageOfDislike;
  }

  public List<DocOnMember> getDocsOnMember() {
    return docsOnMember;
  }

  public void setDocsOnMember(List<DocOnMember> docsOnMember) {
    this.docsOnMember = docsOnMember;
  }

  public List<Item> getItems() {
    return items;
  }

  public void setItems(List<Item> items) {
    this.items = items;
  }

  public List<Mission> getMissions() {
    return missions;
  }

  public void setMissions(List<Mission> missions) {
    this.missions = missions;
  }

  public Boolean getIsTemplateMember() {
    return isTemplateMember;
  }

  public void setIsTemplateMember(Boolean isTemplateMember) {
    this.isTemplateMember = isTemplateMember;
  }
}
