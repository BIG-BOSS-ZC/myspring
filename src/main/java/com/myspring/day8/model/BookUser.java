package com.myspring.day8.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookUser {
    private int id;
    private String username;
    private Double money;
}
