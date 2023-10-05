package de.redstoneworld.redutilities.logger;

import de.redstoneworld.redutilities.misc.Formatter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class ActionLogger {

    private static ActionLogger instance;

    // config options
    private boolean logActions;

    // plugin path
    private String workPath;

    // log message prefix
    private String serverName;

    public ActionLogger() {
        instance = this;

        // initialize config options
        // ...
    }

    public void setLogActions(boolean logActions) {
        this.logActions = logActions;
    }

    public void setWorkPath(String workPath) {
        this.workPath = workPath;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public static ActionLogger getInstance() {
        return instance;
    }

    // source: https://wiki.byte-welt.net/wiki/Text_in_eine_Datei_schreiben_(Java)

    public void log(String modul, String message) {
        if (logActions) {
            File file = getFile("action.log");

            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
                writer.write(getDateAndTime() + " [" + serverName + " | " + modul + "]: " + message);
                writer.newLine();
                writer.close();
            }
            catch(IOException ioe) {
                // https://www.tutorialspoint.com/Different-ways-to-print-exception-messages-in-Java
                ioe.printStackTrace();
            }

        }
    }

    public void log(String message) {
        if (logActions) {
            File file = getFile("action.log");

            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
                writer.write(message);
                writer.newLine();
                writer.close();
            }
            catch(IOException ioe) {
                // https://www.tutorialspoint.com/Different-ways-to-print-exception-messages-in-Java
                ioe.printStackTrace();
            }

        }
    }

    /**
     * This methode create get the file of defined path. If no
     * file exist, he creates a new one.
     *
     * @param filename the name of the file
     * @return the file
     */
    private File getFile(String filename) {
        File file = null;

        try {
            file = new File(workPath + "/" + filename);
        }
        catch (Exception e) {
            System.err.println(e);
        }

        return file;
    }

    /**
     * This methode get the formatted timestamp with date and time.
     *
     * @return String with the current time info
     */
    private static String getDateAndTime() {
        Date timestamp = new Date();

        return Formatter.getTimeString(timestamp, "dd.MM.yyyy, HH:mm");
    }

}
