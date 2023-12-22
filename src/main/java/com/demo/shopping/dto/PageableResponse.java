package com.demo.shopping.dto;

import lombok.Data;

import java.util.List;
@Data
public class PageableResponse <T>{
    private List<T> content;
    private int pageNumber;
    private int pageSize;
    private long totalElements;
    private long totalPages;
    private boolean lastPage;
}
