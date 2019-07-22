package common;

import java.io.Serializable;


public class Pagination implements Serializable {
    // current page no. starting from 1, not 0.
    private int currPageNo = 1;
    // total number of pages
    private int numberPages;
    // total number of records
    private int numberRecords;
    // page size; number of  records per page
    private int pageSize = 10;
    // starting index of current page. starting from 0.
    private int startIndex = -1;

    public Pagination() {
    }

    // used in the input parameter
//    public Pagination(int currPageNo, int pageSize) {
//        this.currPageNo = currPageNo;
//        this.pageSize = pageSize;
//    }

    public Pagination(int currPageNo, int pageSize, int numberRecords) {
        this.currPageNo = currPageNo;
        this.pageSize = pageSize;
        setNumberRecords(numberRecords);
    }

    public int getCurrPageNo() {
        return this.currPageNo;
    }

    public void setCurrPageNo(int currPageNo) {
        this.currPageNo = currPageNo;
    }

    public int getNumberPages() {
        return this.numberPages;
    }

    public void setnumberPages(int numberPages) {
        this.numberPages = numberPages;
    }

    public int getNumberRecords() {
        return this.numberRecords;
    }

    // 给 numberRecords 赋值，会导致计算 numberPages，（重新）计算 currPageNo，以及 startIndex.
    public void setNumberRecords(int numberRecords) {
        this.numberRecords = numberRecords;
        if (numberRecords == 0) {
            numberPages = 0;
            currPageNo = 0;     // means: n/a
            startIndex = 0;     // means: n/a
            return;
        }

        numberPages = numberRecords / pageSize + (numberRecords % pageSize > 0 ? 1 : 0);
        if (currPageNo > numberPages) {
            currPageNo = numberPages;
        }
        startIndex = (currPageNo - 1) * pageSize;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public String toString() {
        final StringBuilder sb = new StringBuilder("Pagination{");
        sb.append("numberRecords=").append(numberRecords);
        sb.append(", pageSize=").append(pageSize);
        sb.append(", numberPages=").append(numberPages);
        sb.append(", currPageNo=").append(currPageNo);
        sb.append(", startIndex=").append(startIndex);
        sb.append('}');
        return sb.toString();
    }

}