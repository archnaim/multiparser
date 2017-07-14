package com.multiparser.multiparsertest.utils;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvParser;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.*;
import java.util.List;
import java.util.Map;

/**
 * Created by IT180517 on 7/13/2017.
 */


public class ReadTextFile {

    @Autowired
    private ReadFile readFile;

    /**
     *
     * @param filename
     * @return
     * @throws IOException
     */
    //parse CSV without POJO, automatically make first row of CSV as header
    public List<Map<String, String>> parseCSVWithoutPOJO(String filename) throws IOException {
        FileInputStream file = readFile.asFileInputStream(filename);
        CsvMapper mapper = new CsvMapper();
        CsvSchema schema = CsvSchema.emptySchema().withHeader(); // use first row as header; otherwise defaults are fine
        MappingIterator<Map<String, String>> csvIterator = mapper.readerFor(Map.class)
                .with(schema)
                .readValues(file);
        return csvIterator.readAll();
    }

    /**
     *
     * @param filename
     * @param delimiter
     * @return
     * @throws IOException
     */
    //parse text file without POJO, can be used for *.del and *.txt
    public List parseTextFileWithoutPojo(String filename, Character delimiter) throws IOException {
        FileInputStream file = readFile.asFileInputStream(filename);
        CsvSchema schema = CsvSchema.emptySchema().withColumnSeparator(delimiter);

        CsvMapper mapper = new CsvMapper();
        mapper.enable(CsvParser.Feature.WRAP_AS_ARRAY);
        MappingIterator<String[]> iterator = mapper.readerFor(String[].class).with(schema).readValues(file);
        return iterator.readAll();
    }
}
