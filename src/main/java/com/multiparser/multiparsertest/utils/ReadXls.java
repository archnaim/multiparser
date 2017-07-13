package com.multiparser.multiparsertest.utils;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.util.HashMap;

/**
 * Created by IT180517 on 7/13/2017.
 */
@Component
public class ReadXls {
    @Autowired
    private RowIterator rowIterator;

    public HashMap parse(String filename, int startRow, int endRow)
    {
        HashMap hashMap = new HashMap();
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            FileInputStream file = new FileInputStream(classLoader.getResource("excel/" + filename + ".xls").getFile());
            HSSFWorkbook workbook = new HSSFWorkbook(file);
            HSSFSheet sheet = workbook.getSheetAt(0);
            hashMap = rowIterator.iterate(sheet,startRow,endRow);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return hashMap;
    }
}
