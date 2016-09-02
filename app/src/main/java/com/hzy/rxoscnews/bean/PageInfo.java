package com.hzy.rxoscnews.bean;

/**
 * Created by huzongrao on 16-9-2.
 */
public class PageInfo {
    int resultsPerPage;
    int totalResults;

    public int getResultsPerPage() {
        return resultsPerPage;
    }

    public void setResultsPerPage(int resultsPerPage) {
        this.resultsPerPage = resultsPerPage;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }
}
