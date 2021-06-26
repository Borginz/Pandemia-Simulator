package com.gameBuilder;

import java.io.*;
import java.util.ArrayList;

public class CSVReader {
    private InputStream dataSource;
    private String[][] commands;

    public CSVReader() {
        this.commands = null;
        this.dataSource = null;
    }
    public void setDataSource(InputStream dataSource) throws IOException {
        this.dataSource = dataSource;
        if (dataSource == null) {
            commands = null;
        } else
            readCSV();
    }

    public String[][] requestCommands() {
        return commands;
    }

    private void readCSV() throws IOException {
        BufferedReader file = new BufferedReader(new InputStreamReader(dataSource));

        String line = file.readLine();
        ArrayList<String[]> commandsList = new ArrayList<>();
        while (line != null) {
            commandsList.add(line.split(","));
            line = file.readLine();
        }
        commands = new String[commandsList.size()][];
        for (int i = 0; i < commandsList.size(); i++) {
            commands[i] = commandsList.get(i);
        }
        file.close();
    }
}
