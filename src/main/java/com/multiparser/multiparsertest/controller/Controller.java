package com.multiparser.multiparsertest.controller;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.jcraft.jsch.*;
import com.multiparser.multiparsertest.utils.ReadExcel;
import com.multiparser.multiparsertest.utils.ReadTextFile;
import com.multiparser.multiparsertest.utils.SftpConn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.util.*;

/**
 * Created by IT180517 on 7/10/2017.
 */
@RestController
public class Controller {

    @Autowired
    private SftpConn sftpConn;

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
//    @GetMapping("/parsecsv/{filename:.+}")
//    public List<Map<String, String>> parseCsv(@PathVariable String filename) throws IOException {
//        return readTextFile.parseCSVWithoutPOJO(filename);
//    }

    @GetMapping("/parsetext/{filename:.+}")
    public List parseText(@PathVariable String filename) throws IOException{
        return readTextFile.parseTextFileWithoutPojo(filename,'|');
    }

    @GetMapping("/test")
    public List<Map<String, String>> checkConn() {
        Session session = sftpConn.createSession("tes1", "tes", "10.5.43.73",22);
        ChannelSftp sftpChannel = null;
        List<Map<String, String>> list = new LinkedList<>();
        String filename = "test.csv";
        /* create connection */
        try {
            session.connect();
            Channel channel = session.openChannel("sftp");
            channel.connect();
            sftpChannel = (ChannelSftp) channel;

            list = readTextFile.parseCSVWithoutPOJO(sftpChannel.get(filename));



        } catch (JSchException | SftpException | IOException e) {
            e.printStackTrace();
        }

        /* Disconnect from sftp */
        session.disconnect();
        if (sftpChannel != null) {
            sftpChannel.exit();
        }

        return list;
    }


}
