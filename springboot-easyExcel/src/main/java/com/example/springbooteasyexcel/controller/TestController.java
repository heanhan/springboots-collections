package com.example.springbooteasyexcel.controller;


import com.example.springbooteasyexcel.utils.EasyExcelUtil;
import com.example.springbooteasyexcel.utils.UserVoDataListener;
import com.example.springbooteasyexcel.vo.UserVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class TestController {

    /**
     * 异步的读取Excel数据文件
     * @param file 文件
     * @throws IOException io异常
     */
    @PostMapping("read")
    public void read(MultipartFile file) throws IOException {
        EasyExcelUtil.read(file.getInputStream(), UserVo.class, new UserVoDataListener());

    }

    /**
     * 同步的读取Excel数据文件
     * @param file 文件
     * @return 读取的数据
     * @throws IOException io异常
     */
    @PostMapping("read/sync")
    public List<UserVo> readSync(@RequestParam("file") MultipartFile file) throws IOException {
        return EasyExcelUtil.readSync(file.getInputStream(), UserVo.class);
    }

    /**
     * 导出Excel文件
     * @param response response
     * @throws IOException io异常
     */
    @GetMapping("export")
    public void write(HttpServletResponse response) throws IOException {
        EasyExcelUtil.write(response, UserVo.class, data(), "模板数据-userVo", "导出数据");
    }

    /**
     * 导出Excel文件-多Sheet
     * @param response response
     * @throws IOException io异常
     */
    @GetMapping("export/sheet")
    public void write2(HttpServletResponse response) throws IOException {
        EasyExcelUtil.write(response, Arrays.asList(UserVo.class, UserVo.class), Arrays.asList(data(), data2()), Arrays.asList("sheet1", "sheet2"), "导出数据2");
    }

    /**
     * 模拟生成UserVo数据
     * @return 数据
     */
    private List<UserVo> data() {
        List<UserVo> list = new ArrayList<>();
        for (int i = 0; i < 67; i++) {
            UserVo UserVo = new UserVo();
            list.add(UserVo);
        }
        return list;
    }

    /**
     * 模拟生成UserVo2数据
     * @return 数据
     */
    private List<UserVo> data2() {
        List<UserVo> list = new ArrayList<>();
        for (int i = 0; i < 67; i++) {
            UserVo UserVo = new UserVo();

            list.add(UserVo);
        }
        return list;
    }
}
