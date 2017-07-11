package com.multiparser.multiparsertest.controller;

import com.multiparser.multiparsertest.domain.File1;
import com.multiparser.multiparsertest.service.ReadExcel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by IT180517 on 7/10/2017.
 */
@RestController
public class controller {
    private final ReadExcel readExcel;

    @Autowired
    public controller(ReadExcel readExcel){
        this.readExcel = readExcel;
    }

    @GetMapping("/file1")
    public List<File1> file1()
    {
        List list = readExcel.parse("file1");

        return list;
    }
}
