package common;

import java.io.Serializable;
import java.util.List;


public class Page<T> implements Serializable {

    // 分页
    private Pagination pagination;
    // 结果列表
    private List<T> result;

    public Page() {
    }

    public Page(Pagination pagination, List<T> result) {
        this.pagination = pagination;
        this.result = result;
    }

    public Pagination getPagination() {
        return this.pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    public List<T> getResult() {
        return this.result;
    }

    public void setResult(List<T> result) {
        this.result = result;
    }

    /**
     * 是否还有下一页数据
     *
     * @return 是否还有下一页数据
     */
    public boolean hasNextPage() {
        return (result != null && pagination.getCurrPageNo() < pagination.getNumberPages());
    }

    @Override
    public String toString() {
        return "Page{" +
                "pagination=" + pagination.toString() +
                "\nresult.size=" + (result == null ? 0 : result.size()) +
                "\nresult=" + (result == null ? "NULL" : result.toString()) +
                '}';
    }
}