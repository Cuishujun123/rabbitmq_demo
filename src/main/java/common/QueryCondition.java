package common;

/**
 * @Author: huanghongyi6
 * @Date: 2019/3/12 10:54
 */
public class QueryCondition extends PageCondition{
    /**
     * 排序字段，必须与表字段一致
     */
    private String orderColumn;
    /**
     * 排序类型，DESC / ASC
     */
    private String orderType;

    public String getOrderColumn() {
        return orderColumn;
    }

    public void setOrderColumn(String orderColumn) {
        this.orderColumn = orderColumn;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("QueryCondition{");
        sb.append("orderColumn='").append(orderColumn).append('\'');
        sb.append(", orderType='").append(orderType).append('\'');
        sb.append(", pageCondition='").append(super.toString()).append('\'');
        sb.append('}');
        return sb.toString();
    }
}