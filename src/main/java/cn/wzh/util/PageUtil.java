package cn.wzh.util;

public class PageUtil {
    /**
     * 当前页
     */
    private Integer pageNum;
    /**
     * 每页条数
     */
    private Integer pageSize = 5;
    /**
     * 总页数
     */
    private Integer pages;
    /**
     * 总条数
     */
    private Integer total;
    /**
     * 上一页
     */
    private Integer prePage;
    /**
     * 下一页
     */
    private Integer nextPage;
    /**
     * 起始行数
     */
    private Integer startNum;
    /**
     * 结果集
     */
    private Object result;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
        // 将总条数%每页条数，进行取余，如果没有余数，说明刚好满足；如果有余数，说明未满足，则总页再加一。
        pages = total % pageSize == 0 ? total / pageSize : total / pageSize + 1;
    }

    public Integer getPrePage() {
        // 如果当前页为1表示首页，则无法查看上一页，反之，将当前页码减1，以查看上一页。
        return pageNum == 1 ? pageNum : pageNum - 1;
    }

    public void setPrePage(Integer prePage) {
        this.prePage = prePage;
    }

    public Integer getNextPage() {
        // 如果当前页跟总页数保持一致，说明当前在尾页，则无法查看下一页，反之，将当前页码加1，以查看下一页。
        return pageNum.equals(pages) ? pageNum : pageNum + 1;
    }

    public void setNextPage(Integer nextPage) {
        this.nextPage = nextPage;
    }

    public Integer getStartNum() {
        // 计算起始行数：将当前页码减1，再乘每页条数。如果每页条数发生变更，为了避免问题发生，回到首页。
        return (pageNum - 1) * pageSize;
    }

    public void setStartNum(Integer startNum) {
        this.startNum = startNum;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
