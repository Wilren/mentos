package com.wilren.mentos.common.utils;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

import java.util.List;

/**
 * @author Wilren Chan
 * @version 1.0
 * @since 2018/10/26/026
 */
@Data
public class Pagination {
    long total = 0;
    long per_page = 0;
    long current_page = 0;
    long last_page = 0;
    String next_page_url;
    String prev_page_url;
    long from = 0;
    long to = 0;
    List data;

    public Pagination(IPage page) {
        long current = page.getCurrent();
        this.total = page.getTotal();
        this.data = page.getRecords();
        if (current == 1) {
            this.from = 1;
        } else {
            this.from = (current - 1) * page.getSize() + 1;
        }
        if (current < page.getPages()) {
            this.to = (current - 1) * page.getSize() + page.getSize();
        } else {
            this.to = page.getTotal();
        }
        Float size = Float.valueOf(page.getSize());
        Float lastPage = page.getTotal() / size;

        this.per_page = page.getCurrent();
        this.last_page = (long) Math.ceil(lastPage);
        this.current_page = page.getCurrent();
    }
}
