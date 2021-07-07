package com.example.security.common.utils;

import com.example.security.common.constants.Constants;
import lombok.Data;

/**
 * 分页查询对象
 */
@Data
public class PageQuery {
    public static final PageQuery INSTANCE = new PageQuery();

    /**
     * 分页页码
     */
    private Integer page;

    /**
     * 分页大小
     */
    private Integer size;


    public PageQuery() {
        this.page = Constants.DEFAULT_CURRENT_PAGE;
        this.size = Constants.DEFAULT_PAGE_SIZE;
    }
}
