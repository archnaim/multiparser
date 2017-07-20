package com.multiparser.multiparsertest.utils;

import java.io.*;

/**
 * Created by IT180517 on 7/14/2017.
 */

public interface ReadFile {
    /**
     *
     * @param fileNameWithExtension
     * @return
     * @throws IOException
     */
    FileInputStream asFileInputStream(String fileNameWithExtension) throws IOException;

    /**
     * 
     * @param filename
     * @return
     * @throws IOException
     */
    File asFile(String filename) throws IOException;

    /**
     *
     * @param filename
     * @return
     * @throws IOException
     */
    BufferedInputStream bufferedInputStream(InputStream filename) throws IOException;
}