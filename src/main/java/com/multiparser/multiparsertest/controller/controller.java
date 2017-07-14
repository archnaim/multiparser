package com.multiparser.multiparsertest.controller;

import com.multiparser.multiparsertest.utils.ReadExcel;
import com.multiparser.multiparsertest.utils.ReadTextFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by IT180517 on 7/10/2017.
 */
@RestController
public class controller {

    @Autowired
    private ReadExcel readExcel;

    @Autowired
    private ReadTextFile readTextFile;


    /**
     *
     * @param filename
     * @param start
     * @param stop
     * @return
     * @throws IOException
     */
    @GetMapping("/parseexcel/{filename:.+}/{start}/{stop}")
    public List parseExcel(@PathVariable String filename, @PathVariable String start, @PathVariable String stop) throws IOException {
        if (filename.contains("xlsx"))
        {
            return readExcel.parseXlsx(filename,Integer.parseInt(start),Integer.parseInt(stop));
        }
        else return readExcel.parseXls(filename,Integer.parseInt(start),Integer.parseInt(stop));
    }

    /**
     *
     * @param filename
     * @return
     * @throws IOException
     */
    @GetMapping("/parsecsv/{filename:.+}")
    public List<Map<String, String>> parseCsv(@PathVariable String filename) throws IOException {
        return readTextFile.parseCSVWithoutPOJO(filename);
    }

    @GetMapping("/parsetext/{filename:.+}")
    public List parseText(@PathVariable String filename) throws IOException{
        return readTextFile.parseTextFileWithoutPojo(filename,'|');
    }
}
