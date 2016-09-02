package com.hzy.rxoscnews.bean;

import java.util.List;

/**
 * Created by huzongrao on 16-9-1.
 */
public class NewsEntry {
    int catalog;
    int newsCount;
    int pagesize;
    List<NewsItem> newslist;

    public int getCatalog() {
        return catalog;
    }

    public void setCatalog(int catalog) {
        this.catalog = catalog;
    }

    public int getNewsCount() {
        return newsCount;
    }

    public void setNewsCount(int newsCount) {
        this.newsCount = newsCount;
    }

    public int getPagesize() {
        return pagesize;
    }

    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
    }

    public List<NewsItem> getNewslist() {
        return newslist;
    }

    public void setNewslist(List<NewsItem> newslist) {
        this.newslist = newslist;
    }
}
