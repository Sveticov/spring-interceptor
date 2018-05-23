package com.sveticov.sveticovinterseptor.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
    private long id;
    private String name;
    private String password;

    public User() {
    }
}
