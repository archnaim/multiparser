package com.multiparser.multiparsertest.utils;

import com.jcraft.jsch.*;

/**
 * Created by IT180517 on 7/20/2017.
 */

public class SftpConn {


    public Session createSession(String username, String password, String host, int port){
        JSch jSch = new JSch();
        Session session = null;
        try {
            session = jSch.getSession(username,host, port);
            session.setPassword(password);
            session.setConfig("StrictHostKeyChecking", "no");
        } catch (JSchException e) {
            e.printStackTrace();
        }
        return session;
    }


}
