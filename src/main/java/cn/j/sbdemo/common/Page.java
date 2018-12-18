package cn.j.sbdemo.common;

import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;

/**
 * 分页参数实体,用于传入service
 * created on 2018/11/27.
 *
 * @author J
 **/
public class Page {

    private int pageNo;
    private int pageSize;
    /**
     * 推荐传入标志位  在service层加以判断 (若是需要多字段排序,可以使用标志位手动拼接排序字段)
     * 也可直接传入表字段
     */
    private String orderField;
    /**
     * asc desc
     * {@link PageUtils#ORDER_TYPE_ASC}
     * {@link PageUtils#ORDER_TYPE_DESC}
     */
    private String orderType;

    public int getPageNo() {
        return pageNo;
    }

    public Page setPageNo(int pageNo) {
        this.pageNo = pageNo;
        return this;
    }

    public int getPageSize() {
        return pageSize;
    }

    public Page setPageSize(int pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    public String getOrderField() {
        return orderField;
    }

    public Page setOrderField(String orderField) {
        this.orderField = orderField;
        return this;
    }

    public String getOrderType() {
        return orderType;
    }

    public Page setOrderType(String orderType) {
        this.orderType = orderType;
        return this;
    }


    public com.github.pagehelper.Page startPage(String orderString) {
        if (StringUtils.isNotBlank(orderString)) {
            return PageHelper.startPage(this.getPageNo(), this.getPageSize(), orderString);
        }

        return PageHelper.startPage(this.getPageNo(), this.getPageSize());
    }

}
