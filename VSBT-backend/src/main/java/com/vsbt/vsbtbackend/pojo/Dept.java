package com.vsbt.vsbtbackend.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor

@TableName("dept")
public class Dept {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String name;
    private LocalDateTime createTime;

    private LocalDateTime updateTime;

}
