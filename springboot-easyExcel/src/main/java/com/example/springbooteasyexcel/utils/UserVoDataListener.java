package com.example.springbooteasyexcel.utils;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.exception.ExcelDataConvertException;
import com.example.springbooteasyexcel.vo.UserVo;

import java.util.ArrayList;
import java.util.List;


public class UserVoDataListener  extends AnalysisEventListener<UserVo> {


    /**
     * 每读取300条数据执行一次存储数据库，然后清理list
     */
    private static final int BATCH_COUNT = 300;

    /**
     * 数据临时存储
     */
    private List<UserVo> list = new ArrayList<>();

    /**
     * 每读取一条数据会调用该方法
     * @param data 数据
     * @param context 上下文
     */
    @Override
    public void invoke(UserVo data, AnalysisContext context) {
        System.out.println("读取到1条数据");
        list.add(data);
        if (list.size() >= BATCH_COUNT) {
            // 保存数据到数据库
            list.clear();
        }
    }

    /**
     * 数据全部读取完成会调用该方法
     * @param context 上下文
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        if (list.size() > 0) {
            // 保存数据到数据库
            list.clear();
        }
        System.out.println("数据读取完成");
    }

    /**
     * 在转换异常 获取其他异常下会调用本接口。抛出异常则停止读取。如果这里不抛出异常则 继续读取下一行。
     * @param exception 异常信息
     * @param context 上下文
     * @throws Exception 异常
     */
    @Override
    public void onException(Exception exception, AnalysisContext context) throws Exception {
        System.out.print("读取数据发生异常:");
        if (exception instanceof ExcelDataConvertException) {
            ExcelDataConvertException excelDataConvertException = (ExcelDataConvertException) exception;
            System.out.println(String.format("第%s行，第%s列解析异常，异常数据:%s", excelDataConvertException.getRowIndex(),
                    excelDataConvertException.getColumnIndex(), excelDataConvertException.getCellData()));
        }
    }
}
