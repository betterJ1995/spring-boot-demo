package cn.j.sbdemo.common;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 分页工具类
 * created on 2018/11/23.
 *
 * @author J
 **/
public class PageUtils {

    /**
     * 页码
     */
    public static final String PAGE_NO = "pageNo";
    /**
     * 页大小
     */
    public static final String PAGE_SIZE = "pageSize";
    /**
     * 排序字段
     */
    public static final String ORDER_FIELD = "orderField";
    /**
     * 排序类型  asc  desc
     */
    public static final String ORDER_TYPE = "orderType";

    public static final String ORDER_TYPE_ASC = "ASC";
    public static final String ORDER_TYPE_DESC = "DESC";

    public static Integer getPageNo() {
        return getPageNo(getRequest());
    }

    public static Integer getPageNo(HttpServletRequest request) {
        String pNo = request.getParameter(PAGE_NO);
        if (pNo == null) {
            return 1;
        }
        return toInt(pNo, 1);
    }

    public static Integer getPageSize() {
        return getPageSize(getRequest());
    }

    public static Integer getPageSize(HttpServletRequest request) {
        return getPageSize(request, 10);
    }

    public static Integer getPageSize(HttpServletRequest request, int defaultVal) {
        String pageSize = request.getParameter(PAGE_SIZE);
        if (pageSize == null) {
            return defaultVal;
        }

        return toInt(pageSize, defaultVal);
    }

    public static String getOrderFiled() {
        return getOrderFiled(getRequest());
    }

    public static String getOrderFiled(HttpServletRequest request) {
        return request.getParameter(ORDER_FIELD);
    }

    public static String getOrderType() {
        return getOrderType(getRequest());
    }

    public static String getOrderType(HttpServletRequest request) {
        String orderType = request.getParameter(ORDER_TYPE);
        if (orderType == null) {
            return ORDER_TYPE_ASC;
        }

        if (ORDER_TYPE_ASC.equalsIgnoreCase(orderType)) {
            return ORDER_TYPE_ASC;
        }

        return ORDER_TYPE_DESC;
    }


    public static Boolean getIsASC() {
        return getIsASC(getRequest());
    }

    public static Boolean getIsASC(HttpServletRequest request) {
        String orderType = request.getParameter(ORDER_TYPE);
        if (orderType != null) {
            return ORDER_TYPE_ASC.equalsIgnoreCase(orderType);
        } else {
            return true;
        }
    }

    public static Page page() {
        return page(getRequest());
    }

    public static Page page(HttpServletRequest request) {
        return new Page()
                .setPageNo(getPageNo(request))
                .setPageSize(getPageSize(request))
                .setOrderField(getOrderFiled(request))
                .setOrderType(getOrderType(request));
    }


    /**
     * based on spring-web
     */
    private static HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
    }

    /**
     * copy from org.apache.commons.lang3.math.NumberUtils
     */
    private static int toInt(String str, int defaultValue) {
        if (str == null) {
            return defaultValue;
        }

        try {
            return Integer.parseInt(str);
        } catch (final NumberFormatException nfe) {
            return defaultValue;
        }
    }
}
