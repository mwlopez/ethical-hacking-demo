package com.eh.demo.demo.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RequestEntity {
    private String input;
    private String password;
}
