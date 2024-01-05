package org.cptgum.simpleftpsync;
import com.jcraft.jsch.*;

import java.io.IOException;

public class SFTPUtil {

    public static void uploadFile(String host, int port, String user, String pass, String shkc, String remotePath, String localPath) throws IOException, SftpException, JSchException {
        JSch jsch = new JSch();
        Session session = jsch.getSession(user, host, port);
        session.setPassword(pass);
        session.setConfig("StrictHostKeyChecking", shkc);
        session.connect();

        ChannelSftp channelSftp = (ChannelSftp) session.openChannel("sftp");
        channelSftp.connect();

        channelSftp.put(localPath, remotePath);

        channelSftp.disconnect();
        session.disconnect();
    }
}
