package com.multiparser.multiparsertest.utils;

import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by IT180517 on 7/20/2017.
 */

public class SftpConnTest {

    private Session session;

    @Before
    public void setUp() throws Exception{
        SftpConn sftpConn = new SftpConn();
        session = sftpConn.createSession("tes1", "tes", "10.5.43.189",22);
        try {
            session.connect();
        } catch (JSchException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testConn(){
        assertThat(session.isConnected(),is(true));
    }

}