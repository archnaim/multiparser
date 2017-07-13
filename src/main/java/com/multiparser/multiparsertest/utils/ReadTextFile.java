package com.multiparser.multiparsertest.utils;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by IT180517 on 7/13/2017.
 */
@Component
public class ReadTextFile {

    //parse CSV without POJO, automatically make first row of CSV as header
    public List parseCSVWithoutPOJO(String filename){
        List csvData = new ArrayList();
        ClassLoader classLoader = getClass().getClassLoader();
        FileInputStream file = null;
        try {
            file = new FileInputStream(classLoader.getResource("csv/" + filename + ".csv").getFile());
            CsvSchema schema = CsvSchema.emptySchema().withColumnSeparator(';').withHeader();
            ObjectMapper mapper = new CsvMapper();
            MappingIterator<Map<String,String>> csvIterator = mapper.readerFor(Map.class).with(schema).readValues(file);
            csvData = csvIterator.readAll();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return csvData;
    }

    //parse text file without POJO, can be used for *.del and *.txt
    public List parseTextFileWithoutPojo(String filenameWithExtension, Character delimiter)
    {
        List data = new ArrayList();
        ClassLoader classLoader = getClass().getClassLoader();
        FileInputStream file = null;
        try {
            file = new FileInputStream(classLoader.getResource("text/" + filenameWithExtension).getFile());
            CsvSchema schema = CsvSchema.emptySchema().withColumnSeparator(delimiter);
            ObjectMapper mapper = new CsvMapper();
            MappingIterator<Map<String,String>> iterator = mapper.readerFor(Map.class).with(schema).readValues(file);
            data = iterator.readAll();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return data;
    }
}
