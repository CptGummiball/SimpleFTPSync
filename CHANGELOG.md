# Change Log
All notable changes to this project will be documented in this file.
 
The format is based on [Keep a Changelog](http://keepachangelog.com/)
and this project adheres to [Semantic Versioning](http://semver.org/).
 
## [NEXT]
 
### Added
- Option to disable StrictHostKeyChecking

### Changed
 
### Fixed

## [1.1] - 2023-01-05
  
### Added
- FTPS Support
  - This addition enhances your file synchronization capabilities by introducing FTPS as an alternative method alongside SFTP and FTP.
  - FTPS provides an additional layer of security with its support for SSL/TLS encryption, ensuring the confidentiality and integrity of your data during transmission.

 
## FIX
- If you receive the following message in your console, use FTPS instead of SFTP
````
com.jcraft.jsch.JSchException: Algorithm negotiation fail
````
[Problem Description](https://github.com/CptGummiball/SimpleFTPSync/blob/main/Algorithm%20negotiation%20fail.md)
