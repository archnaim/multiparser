package com.multiparser.multiparsertest.utils;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by IT180517 on 7/13/2017.
 */

@SuppressWarnings("deprecation")
public class ReadExcel {

    @Autowired
    private ReadFile readFile;

    public List parseXls(String filename, int startRow, int endRow) throws IOException {
        FileInputStream file = readFile.asFileInputStream(filename);
        HSSFWorkbook workbook = new HSSFWorkbook(file);
        HSSFSheet sheet = workbook.getSheetAt(0);
        List list = iterate(sheet,startRow,endRow);
        return list;
    }

    public List parseXlsx(String filename, int startRow, int endRow) throws IOException{
        FileInputStream file = readFile.asFileInputStream(filename);
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheetAt(0);
        List list = iterate(sheet,startRow,endRow);
        return list;
    }

    public List iterate(Sheet sheet, int startRow, int endRow)
    {
        List list = new ArrayList();
        for (Row row: sheet) {
            if(row.getRowNum()>startRow && row.getRowNum()<=endRow)
            {
                HashMap mapRow = new HashMap();
                for (Cell cell:row) {
                    switch (cell.getCellType())
                    {
                        case Cell.CELL_TYPE_STRING:
                            mapRow.put(cell.getColumnIndex(),cell.getStringCellValue());
                            break;

                        case Cell.CELL_TYPE_NUMERIC:
                            if(HSSFDateUtil.isCellDateFormatted(cell))
                            {
                                DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
                                mapRow.put(cell.getColumnIndex(),df.format(cell.getDateCellValue()));
                                break;
                            }
                            else
                            {
                                mapRow.put(cell.getColumnIndex(),cell.getNumericCellValue());
                                break;
                            }

                        case Cell.CELL_TYPE_FORMULA:
                            mapRow.put(cell.getColumnIndex(),cell.getNumericCellValue());
                            break;

                        case Cell.CELL_TYPE_BLANK:
                            mapRow.put(cell.getColumnIndex(),cell.getStringCellValue());
                    }
                }
                list.add(mapRow);

            }
            else if (row.getRowNum()>endRow)
            {
                break;
            }

        }
        return list;
    }
}
