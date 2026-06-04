package com.vsbt.vsbtbackend.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginInfo {
    private Integer id; // 员工ID
    private String name; // 用户名
    private String username; // 姓名
    private String token; //令牌
}
