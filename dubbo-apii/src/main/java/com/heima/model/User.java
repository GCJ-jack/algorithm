package com.heima.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private final static long serialVersionID = 1L;

    private long id;
    private String name;
    private int age;

}
