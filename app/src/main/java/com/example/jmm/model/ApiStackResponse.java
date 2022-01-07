package com.example.jmm.model;

import java.util.List;

public class ApiStackResponse {

    public List<ItemsList> items;
    public boolean has_more;
    public int backoff, quota_max, quota_remaining;
}
