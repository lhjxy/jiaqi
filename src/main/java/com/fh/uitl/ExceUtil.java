package com.fh.uitl;


import com.fh.common.Excel;
import com.fh.common.ExcelHide;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class ExceUtil {


    public static void exceleUtil(List list, HttpServletResponse response) {
        //处理标题
        Object o = list.get(0);//得到要下载的对象
        Class aClass1 = o.getClass();//得到要下载的类对象
        //获取标题名，  标题名在注解上
        ExcelHide annotation = (ExcelHide) aClass1.getAnnotation(ExcelHide.class);
        String title = annotation.title();//获取title名
        XSSFWorkbook book=new XSSFWorkbook();
        XSSFSheet sheet = book.createSheet(title);
        XSSFRow row2 = sheet.createRow(0);
        //处理列头   得到类的所有属性
        Field[] declaredFields = aClass1.getDeclaredFields();
        int celNum=0;
        for (int i = 0; i <declaredFields.length ; i++) {
            //具体到每一个属性
            Field field=declaredFields[i];
            //判断此属性是否是要到出的属性
            Excel annotation1 = field.getAnnotation(Excel.class);
            if(annotation1!=null){
                String name = annotation1.name();
                //将列名放在具体的列中
                XSSFCell cell = row2.createCell(celNum);
                cell.setCellValue(name);
                celNum++;
            }
        }
        //处理数据
        for (int i = 0; i <list.size() ; i++) {
            //获取具体的数据
            Object o1 = list.get(i);
            XSSFRow row = sheet.createRow(i + 1);
            int celln=0;
            for (int j = 0; j < declaredFields.length; j++) {
                //具体的每一个属性
                Field field=declaredFields[j];
                boolean annotationPresent = field.isAnnotationPresent(Excel.class);
                if(annotationPresent==true){
                    XSSFCell cell = row.createCell(celln);
                    //获取属性的值  在反射中   对类对象来说
                    field.setAccessible(true);
                    try {
                        Object o2 = field.get(o1);
                        if(o2!=null){
                            //判断属性的类型
                            Class type = field.getType();
                            if(type==Date.class){
                                //格式化日期
                                SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
                                Date date= (Date) o2;
                                String format = sdf.format(date);
                                cell.setCellValue(format);
                            }else {
                                cell.setCellValue(o2.toString());
                            }
                        }else {
                            cell.setCellValue("");
                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    celln++;
                }
            }
        }
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/octet-stream");
        response.addHeader("Content-Disposition", "attachment; filename=\""+ UUID.randomUUID().toString()+".xlsx\"");

        ServletOutputStream outputStream = null;
        try {
            outputStream = response.getOutputStream();
            book.write(outputStream);
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    }

