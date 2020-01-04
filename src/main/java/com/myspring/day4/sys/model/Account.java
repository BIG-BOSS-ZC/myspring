package com.myspring.day4.sys.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Account {

    private int id;
    private String username;
    private String password;
    private BigDecimal money;
    private String role;
}
