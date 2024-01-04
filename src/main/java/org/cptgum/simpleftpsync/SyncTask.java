package org.cptgum.simpleftpsync;

import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.scheduler.BukkitRunnable;
import java.io.IOException;
import com.jcraft.jsch.*;

public class SyncTask extends BukkitRunnable {
    private final SimpleFTPSync plugin;

    public SyncTask(SimpleFTPSync plugin) {
        this.plugin = plugin;
    }

    @Override
    public void run() {
        String syncType = plugin.getPluginConfig().getString("synctype");

        assert syncType != null;
        if (syncType.equalsIgnoreCase("FTP")) {
            performFTPUpload();
        } else if (syncType.equalsIgnoreCase("SFTP")) {
            performSFTPUpload();
        } else {
            System.out.println("Unrecognized sync type in config.yml");
        }
    }

    private void performFTPUpload() {
        String server = plugin.getPluginConfig().getString("ftp.server");
        int port = plugin.getPluginConfig().getInt("ftp.port");
        String user = plugin.getPluginConfig().getString("ftp.username");
        String pass = plugin.getPluginConfig().getString("ftp.password");

        ConfigurationSection syncFolders = plugin.getPluginConfig().getConfigurationSection("sync-folders");
        if (syncFolders != null) {
            for (String key : syncFolders.getKeys(false)) {
                String localPath = syncFolders.getString(key + ".local-path");
                String remotePath = syncFolders.getString(key + ".remote-path");

                try {
                    FTPUtil.uploadFile(server, port, user, pass, remotePath, localPath);
                } catch (IOException e) {
                    Bukkit.getLogger().warning("Failed to upload file: " + e.getMessage());
                }
            }
        } else {
            System.out.println("No sync-folders configured in config.yml");
        }
    }

    private void performSFTPUpload() {
        String server = plugin.getPluginConfig().getString("sftp.server");
        int port = plugin.getPluginConfig().getInt("sftp.port");
        String user = plugin.getPluginConfig().getString("sftp.username");
        String pass = plugin.getPluginConfig().getString("sftp.password");

        ConfigurationSection syncFolders = plugin.getPluginConfig().getConfigurationSection("sync-folders");
        if (syncFolders != null) {
            for (String key : syncFolders.getKeys(false)) {
                String localPath = syncFolders.getString(key + ".local-path");
                String remotePath = syncFolders.getString(key + ".remote-path");

                try {
                    SFTPUtil.uploadFile(server, port, user, pass, remotePath, localPath);
                } catch (IOException | SftpException | JSchException e) {
                    Bukkit.getLogger().warning("Failed to upload file: " + e.getMessage());
                }
            }
        } else {
            System.out.println("No sync-folders configured in config.yml");
        }
    }
}
