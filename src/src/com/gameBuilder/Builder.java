package com.gameBuilder;

import com.city.*;
import com.city.institution.*;
import com.exceptions.RepeatedComponentsException;
import com.gameControl.IConnectComponents;
import com.gameControl.IPauseTimer;
import com.view.*;
import com.view.institutionview.*;

import java.io.IOException;

public class Builder implements IBuilder {
    char[][] matrix;
    City city;
    View view;
    IConnectComponents game;
    int sizeX;
    int sizeY;
    int population;

    public Builder(){
        matrix = new char[][]{ {'P', '-','-','H','-','-','-','B'},
                               {'-', '-','-','-','-','-','-','-'},
                               {'-', '-','S','-','-','-','-','-'},
                               {'I', '-','-','-','C','C','C','C'}};
        sizeX = 8;
        sizeY = 4;
        population = 10000;
    }

    public Level[] createLevels() throws IOException, RepeatedComponentsException {
        Level[] levels = new Level[3];

        CSVReader csv = new CSVReader();
        for(int j = 1; j <= 3; j++) {
            csv.setDataSource(Builder.class.getResourceAsStream("/levels/level" + j + ".csv"));
            String[][] commands = csv.requestCommands();
            int sizeY = Character.getNumericValue(commands[0][0].charAt(0));
            int sizeX = Character.getNumericValue(commands[0][0].charAt(2));
            int population = Integer.parseInt(commands[0][1]);
            char[][] matrix = new char[sizeY][sizeX];

            for (int i = 1; i <= (sizeX*sizeY); i++) {
                if(Character.getNumericValue(commands[i][0].charAt(0)) <= sizeY && Character.getNumericValue(commands[i][0].charAt(0)) >= 1 &&
                        Character.getNumericValue(commands[i][0].charAt(2)) <= sizeX && Character.getNumericValue(commands[i][0].charAt(2)) >= 1) {

                    if(matrix[Character.getNumericValue(commands[i][0].charAt(0))-1][Character.getNumericValue(commands[i][0].charAt(2))-1] == '\u0000'){
                        matrix[Character.getNumericValue(commands[i][0].charAt(0))-1][Character.getNumericValue(commands[i][0].charAt(2))-1] = commands[i][1].charAt(0);
                    } else {
                        throw new RepeatedComponentsException();
                    }
                }
            }
            levels[j-1] = new Level(j, matrix, population, sizeX, sizeY);
        }

        return levels;
    }


    public void buildGame(Level level){
        matrix = level.getMatrix();
        population = level.getPopulation();
        sizeX = level.getSizeX();
        sizeY = level.getSizeY();

        int mayorX = 0;
        int mayorY = 0;
        city = new City();
        view = new View();

        city.connect(view);
        city.setPopulation(population);
        view.setPopulation(population);
        city.buildMatrix(sizeX, sizeY);
        view.setCitySize(sizeX, sizeY);
        for(int y = 0; y < sizeY; y++){
            for(int x = 0; x < sizeX; x++){
                if(matrix[y][x] != '-' && matrix[y][x] != 'P'){
                    InstitutionControl institutionControl = city.insert(x, y, matrix[y][x]);
                    InstitutionView institutionView = view.insert(x, y, matrix[y][x]);
                    institutionControl.connect(city);
                    institutionControl.connect(institutionView.getInstitutionIcon());
                    institutionView.getInstitutionPanel().connect((IPauseTimer) game);
                    institutionView.getInstitutionPanel().connect(institutionControl);
                } else if(matrix[y][x] == 'P'){
                    mayorX = x;
                    mayorY = y;
                }
            }
        }
        city.connectTimer((IPauseTimer)game);
        view.getWarnPanel().connect((IPauseTimer) game);
        view.setMayor(mayorX, mayorY);
        game.connectComponents(city, view);
        city.startUpdate();
    }

    public void connect(IConnectComponents game){
        this.game = game;
    }


}
