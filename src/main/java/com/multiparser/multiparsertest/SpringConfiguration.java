package com.multiparser.multiparsertest;

import com.multiparser.multiparsertest.utils.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by IT180517 on 7/14/2017.
 */

@Configuration
public class SpringConfiguration {

    @Bean
    public ReadFile readFile(){
        return new ReadFileImpl();
    }

    @Bean
    public ReadExcel readExcel() {
        return new ReadExcel();
    }

    @Bean
    public ReadTextFile readTextFile() {
        return new ReadTextFile();
    }

    @Bean
    public SftpConn sftpConn(){return new SftpConn();}
}
