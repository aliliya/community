package com.nowcoder.community.entity;


public class Page {

    //当前页
    private int current = 1;
    //一页行数
    private int limit = 10;
    //总行数
    private int rows;

    private String path;

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        if(current > 0) {
            this.current = current;
        }
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        if(limit >= 1 && limit <= 100) {
            this.limit = limit;
        }
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        if(rows >= 0) {
            this.rows = rows;
        }
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    /**
     *获取当前页的起始行
     * @return
     */
    public int getOffset(){
        return current * limit -current;
    }

    /**
     *获取总的页数
     * @return
     */
    public int getTotal(){
        if(rows % limit == 0){
            return rows / limit;
        }
        else{
            return rows / limit + 1;
        }
    }

    /**
     * 获取起始页码
     * @return
     */
    public int getFrom(){
        int from = current - 2;
        return from > 1 ? from : 1;
    }

    /**
     * 获取终止页码
     * @return
     */
    public int getTo(){
        int to = current + 2;
        int total = getTotal();
        return to > total ? total : to;
    }

}
