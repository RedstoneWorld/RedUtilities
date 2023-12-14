package de.redstoneworld.redutilities.files;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileManager {

    // https://mkyong.com/java/how-do-convert-byte-array-to-string-in-java/

    private final File baseDir;
    private Logger logger;
    
    public FileManager(File baseDir) {
        this.baseDir = baseDir;
    }

    public File createFolder(String subFolder) {
        return createFolder(baseDir, subFolder);
    }

    public File createFolder(File dir, String newFolderName) {

        File folder = new File(dir, newFolderName);

        // Create folder if it doesn't exist
        if (!folder.exists()) {
            logger.log(Level.INFO, "Creating the folder: '" + newFolderName + "'");

            folder.mkdirs();
        }

        return folder;
    }

    public File copyDefaultFile(InputStream pluginResource, String resourceFileName) {
        return copyDefaultFile(pluginResource, baseDir, resourceFileName);
    }
    
    public File copyDefaultFile(InputStream pluginResource, File dir, String resourceFileName) {

        File file = new File(dir, resourceFileName);
        
        try {

            // Create default file if it doesn't exist
            if (!file.exists()) {
                logger.log(Level.INFO, "Creating the default file: '" + resourceFileName + "'");
                
                FileOutputStream outputStream = new FileOutputStream(file);
                pluginResource.transferTo(outputStream);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return file;
    }

    public String getFileContent(String fileName) {
        return getFileContent(baseDir, fileName);
    }

    public String getFileContent(File dir, String fileName) {
        
        File file = new File(dir, fileName);
        return getFileContent(file);
    }
    
    public String getFileContent(File file) {
        
        String content = "";

        try {
            InputStream in = new FileInputStream(file);
            byte[] rawContent = in.readAllBytes();
            content = new String(rawContent, StandardCharsets.UTF_8);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return content;
    }

    public File saveNewFile(String newFileName, String content) {
        return saveNewFile(baseDir, newFileName, content);
    }
    
    public File saveNewFile(File dir, String newFileName, String content) {
        
        File newFile = new File(dir, newFileName);

        try {
            if (!newFile.exists()) {
                logger.log(Level.INFO, "Creating the file: '" + newFileName + "'");
                
                FileOutputStream outputStream = new FileOutputStream(newFile);
                if (!content.isBlank()) outputStream.write(content.getBytes());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return newFile;
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    public Logger getLogger() {
        return logger;
    }
    
}
