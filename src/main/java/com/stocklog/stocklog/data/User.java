package com.stocklog.stocklog.data;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class User {
    private long id;
    private String name;
    private String username;
    private String passwordHash;
    private String passwordSalt;
    private Date lastLoginAt;
    private Date createdAt;
}
