package com.multiparser.multiparsertest.utils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.util.HashMap;

/**
 * Created by IT180517 on 7/13/2017.
 */
@Component
public class ReadXlsx {
    @Autowired
    private RowIterator rowIterator;

    public HashMap iterate(String filename,int startRow, int endRow)
    {
        HashMap hashMap = new HashMap();
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            FileInputStream file = new FileInputStream(classLoader.getResource("excel/" + filename + ".xlsx").getFile());
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(0);
            hashMap = rowIterator.iterate(sheet,startRow,endRow);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return hashMap;
    }
}
