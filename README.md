# SimpleFTPSync Plugin
## Overview
SimpleFTPSync is a Bukkit/Spigot plugin designed for easy and flexible synchronization of folders using either FTP, SFTP or FTPS protocols. This plugin allows you to synchronize specific folders on your server with remote servers, providing a convenient way to manage and update content.

## USAGE

### Installation

1.  Download the latest release JAR file from the [Releases page](https://github.com/CptGummiball/SimpleFTPSync/releases).
2.  Place the downloaded JAR file in the `plugins` folder of your Bukkit/Spigot server.
3.  Start or restart your server.

### Configuration

1.  Navigate to the `plugins` folder and find the `SimpleFTPSync` folder.
2.  Open the `config.yml` file to configure synchronization settings.

#### Configuration Options

-   `sync-interval`: Synchronization interval in seconds.
-   `local-path`: Path to the local folder you want to synchronize.
-   `sync-type`: Synchronization type (FTP, SFTP or FTPS).
##### FTP Server Configuration
````
ftp:
  server: "ftp.example.com"
  port: 21
  username: "your-ftp-username"
  password: "your-ftp-password"
  remote-path: "/path/on/ftp/server"
````
##### SFTP Server Configuration
````
sftp:
  server: "sftp.example.com"
  port: 22
  username: "your-sftp-username"
  password: "your-sftp-password"
  remote-path: "/path/on/sftp/server"
  StrictHostKeyChecking: "yes" # Set to "yes" or "no" to enable or disable strict host key checking (not recommended)

````
##### FTPS Server Configuration
````
ftps:
  server: "ftps.example.com"
  port: 21
  username: "your-ftps-username"
  password: "your-ftps-password"
  remote-path: "/path/on/ftps/server"
````
##### List of Folders to Synchronize
````
sync-folders:
  - local-path: "plugins/YourPluginName/folder1"
    remote-path: "/remote/folder1"
  - local-path: "world"
    remote-path: "/remote/folder2"
    # Add more folders as needed
````

### Commands

-   `/sfs reload`: Reloads the configuration. (Permission: `syncfolder.reload`)

## FAQ
#### How do I troubleshoot synchronization issues?
*Check the server logs for error messages. Ensure that the server and FTP/SFTP/FTPS configurations are accurate.*

#### I get the error `com.jcraft.jsch.JSchException: Algorithm negotiation fail` in the console
*Please see [here](https://github.com/CptGummiball/SimpleFTPSync/blob/main/Algorithm%20negotiation%20fail.md) for more information and use FTPS instead of SFTP*

#### I get the error `org.apache.commons.net.MalformedServerReplyException: Could not parse response code Reply: SSH-2.0-Go` in the console
*Ensure that you're connecting to the correct type of server. For example, if you're expecting an FTP server, make sure you are connecting to an FTP server and not an SSH server.*

## Issues
If you encounter any issues or have suggestions, please [create a new issue](https://github.com/CptGummiball/SimpleFTPSync/issuess).

## Credits
Author: CptGummiball

[![MIT License](https://img.shields.io/badge/License-MIT-green.svg)]([https://choosealicense.com/licenses/mit/](https://github.com/CptGummiball/SimpleFTPSync/blob/main/LICENSE))
