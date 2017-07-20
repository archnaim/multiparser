package com.multiparser.multiparsertest.utils;

import com.jcraft.jsch.ChannelSftp;

import java.io.*;

/**
 * Created by IT180517 on 7/14/2017.
 */


public class ReadFileImpl implements ReadFile {
    /**
     *
     * @param fileNameWithExtension
     * @return
     * @throws IOException
     */
    @Override
    public FileInputStream asFileInputStream(String fileNameWithExtension) throws IOException{
        FileInputStream file = null;
        try {
            ClassLoader classLoader = getClass().getClassLoader();
             file = new FileInputStream(classLoader.getResource("file/" + fileNameWithExtension).getFile());
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return file;
    }


    /**
     *
     * @param filename
     * @return
     * @throws IOException
     */
    @Override
    public File asFile(String filename) throws IOException {
        File file = null;
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            file = new File(classLoader.getResource("file/" + filename).getFile());
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return file;
    }

    /**
     *
     * @param filename
     * @return
     * @throws IOException
     */
    @Override
    public BufferedInputStream bufferedInputStream(InputStream filename) throws IOException {
        return new BufferedInputStream(filename);
    }
}
