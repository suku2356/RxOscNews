package com.hzy.rxoscnews.bean;

import java.util.List;

/**
 * Created by huzongrao on 16-9-2.
 */
public class ResultDetail {
    List<AboutItem> abouts;
    String author;
    int authorId;
    String authorPortrait;
    int authorRelation;
    String body;
    int commentCount;
    boolean favorite;
    String href;
    int id;
    String pubDate;
    Software software;
    String title;
    int viewCount;

    public List<AboutItem> getAbouts() {
        return abouts;
    }

    public void setAbouts(List<AboutItem> abouts) {
        this.abouts = abouts;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getAuthorPortrait() {
        return authorPortrait;
    }

    public void setAuthorPortrait(String authorPortrait) {
        this.authorPortrait = authorPortrait;
    }

    public int getAuthorRelation() {
        return authorRelation;
    }

    public void setAuthorRelation(int authorRelation) {
        this.authorRelation = authorRelation;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public Software getSoftware() {
        return software;
    }

    public void setSoftware(Software software) {
        this.software = software;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }
}
