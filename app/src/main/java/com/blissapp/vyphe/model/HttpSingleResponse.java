package com.blissapp.vyphe.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created by Shanthakumar on 24-02-2017.
 */

@Data
@EqualsAndHashCode(callSuper = false)
public class HttpSingleResponse {

    int code;
    int serviceIdentifier;
    String content;
    Object responseJson;
}
