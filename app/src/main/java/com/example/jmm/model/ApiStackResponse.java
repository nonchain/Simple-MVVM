package com.example.jmm.model;

import java.util.List;

public class ApiStackResponse {

    List<ItemsList> items;
    boolean has_more;
    int backoff, quota_max, quota_remaining;
}
