package com.example.vyphe.listeners;

import com.example.vyphe.model.HttpSingleResponse;

/**
 * Created by Shanthakumar on 24-02-2017.
 */

public interface HttpResponseListener {

    void showSuccessResponse(HttpSingleResponse successResponse);

    void showErrorResponse(HttpSingleResponse errorResponse);
}
