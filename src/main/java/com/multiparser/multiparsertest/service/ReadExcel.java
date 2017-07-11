package com.multiparser.multiparsertest.service;


import com.multiparser.multiparsertest.domain.File1;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.context.annotation.Configuration;

import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IT180517 on 7/10/2017.
 */
@Configuration
@SuppressWarnings("deprecation")
public class ReadExcel {
    public List<File1> parse(String filename){
        List<File1> data = new ArrayList<>();
        try {
            ClassLoader classLoader = getClass().getClassLoader();

            FileInputStream file = new FileInputStream(classLoader.getResource("excel/"+filename+".xls").getFile());
            HSSFWorkbook workbook = new HSSFWorkbook(file);
            HSSFSheet sheet = workbook.getSheetAt(0);
            File1 file1 = new File1();
            for(Row row:sheet)
            {
                if(row.getRowNum()>4)
                {
                    for (Cell cell:row) {
                        switch (cell.getColumnIndex())
                        {
                            case 0:
                                file1.setDate(cellToString(cell));
                                break;

                            case 1:
                                file1.setRef1(cellToString(cell));
                                break;

                            case 3:
                                file1.setRef2(cellToString(cell));
                                break;

                            case 4:
                                file1.setProject_task(cellToString(cell));

                            case 7:
                                file1.setHours(cellToString(cell));
                                break;

                            case 8:
                                file1.setDays(cellToString(cell));
                                break;
                        }
                    }
                    data.add(file1);
                    file1 = new File1();
                }
            }
            file.close();


        }catch (Exception e){
            e.printStackTrace();
        }
        return data;
    }

    private String cellToString(Cell cell)
    {
        switch (cell.getCellType()){
            case Cell.CELL_TYPE_STRING:
                return cell.getStringCellValue();


            case Cell.CELL_TYPE_NUMERIC:
                if(HSSFDateUtil.isCellDateFormatted(cell))
                {
                    DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
                    return df.format(cell.getDateCellValue());
                }
                else
                {
                    return String.valueOf(cell.getNumericCellValue());
                }

            case Cell.CELL_TYPE_FORMULA:
                return String.valueOf(cell.getNumericCellValue());
        }
        return null;
    }
}