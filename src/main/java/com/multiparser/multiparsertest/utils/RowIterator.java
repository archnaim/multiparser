package com.multiparser.multiparsertest.utils;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;

/**
 * Created by IT180517 on 7/13/2017.
 */
@Component
@SuppressWarnings("deprecation")
public class RowIterator {
    public HashMap iterate(Sheet sheet, int startRow, int endRow)
    {
        HashMap hashMap = new HashMap();
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
                hashMap.put(row.getRowNum(),mapRow);

            }
            else if (row.getRowNum()>endRow)
            {
                break;
            }

        }
        return hashMap;
    }
}
