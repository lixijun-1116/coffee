package com.example.coffee.model.entity;

import java.util.Date;

/**
 * Created by Administrator on 2020/4/10.
 */
public class Discovery {
    private String  discoveryId,author,title,cover,content;
    private Integer like,collection,comments,status;
    private Date createTime,updateTime;

    public Discovery() {
    }

    public Discovery(String discoveryId, String author, String title, String cover, String content, Integer like, Integer collection, Integer comments, Integer status, Date createTime, Date updateTime) {
        this.discoveryId = discoveryId;
        this.author = author;
        this.title = title;
        this.cover = cover;
        this.content = content;
        this.like = like;
        this.collection = collection;
        this.comments = comments;
        this.status = status;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Discovery{" +
                "discoveryId='" + discoveryId + '\'' +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", cover='" + cover + '\'' +
                ", content='" + content + '\'' +
                ", like=" + like +
                ", collection=" + collection +
                ", comments=" + comments +
                ", status=" + status +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }

    public String getDiscoveryId() {
        return discoveryId;
    }

    public void setDiscoveryId(String discoveryId) {
        this.discoveryId = discoveryId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getLike() {
        return like;
    }

    public void setLike(Integer like) {
        this.like = like;
    }

    public Integer getCollection() {
        return collection;
    }

    public void setCollection(Integer collection) {
        this.collection = collection;
    }

    public Integer getComments() {
        return comments;
    }

    public void setComments(Integer comments) {
        this.comments = comments;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
