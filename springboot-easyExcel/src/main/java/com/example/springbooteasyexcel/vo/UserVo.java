package com.example.springbooteasyexcel.vo;


import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;

import java.io.Serializable;

@Data
public class UserVo extends BaseRowModel implements Serializable {

    @ExcelProperty(value = "用户账号",index = 0)
    private String userId;

    @ExcelProperty(value = "用户名称",index = 1)
    private String userName;

    @ExcelProperty(value = "用户名称",index = 2)
    private String userPhone;

    @ExcelProperty(value = "性别",index = 3)
    private String sex;

    @ExcelProperty(value = "住址",index = 4)
    private String adress;

    @ExcelIgnore
    private String info;
}
