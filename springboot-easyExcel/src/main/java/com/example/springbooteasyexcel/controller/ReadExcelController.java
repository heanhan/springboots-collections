package com.example.springbooteasyexcel.controller;


import com.example.springbooteasyexcel.vo.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
public class ReadExcelController {

    @GetMapping(value = "/downTemplate")
    public void downTemplate(HttpServletResponse response) {

    }

    private List<UserVo> data() {
        List<UserVo> list = new ArrayList<UserVo>();
        for (int i = 0; i < 10; i++) {
            UserVo data = new UserVo();
            list.add(data);
        }
        return list;
    }

    //读取模板的excel

    /**
     * excelReader  excel读取reader
     * clazz 读取模板
     * headRowNumber  读取行数
     * 读取的sheetNo
     */
    @PostMapping(value = "readTempleExcel")
    public List<UserVo> readTempleExcel(@RequestParam(name = "file") MultipartFile file) {
        return null;
    }
}
