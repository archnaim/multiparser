package com.multiparser.multiparsertest.controller;

import com.multiparser.multiparsertest.utils.ReadXls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.stream.Stream;

/**
 * Created by IT180517 on 7/10/2017.
 */
@RestController
public class controller {

    @Autowired
    private ReadXls readXls;


    @GetMapping("/parse/{filename}/{start}/{stop}")
    public HashMap parse(@PathVariable String filename, @PathVariable String start, @PathVariable String stop) {
        HashMap list = readXls.parse(filename,Integer.parseInt(start),Integer.parseInt(stop));
//        System.out.println(list.entrySet().stream().count());
        return list;
    }
}
