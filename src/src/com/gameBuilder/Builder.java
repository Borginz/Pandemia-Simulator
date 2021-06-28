package com.gameBuilder;

import com.city.*;
import com.city.institution.*;
import com.exceptions.InvalidPositionException;
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

    public Level[] createLevels() throws IOException, RepeatedComponentsException, InvalidPositionException {
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
                } else {
                    throw new InvalidPositionException();
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

        city.connect(view); // Conecta a interface IUpdateBar para a atualização das barras de progresso
        city.connectTimer((IPauseTimer)game); // Conecta o timer para o controle do tempo pela cidade
        city.setPopulation(population);
        city.buildMatrix(sizeX, sizeY);

        view.setPopulation(population);
        view.setCitySize(sizeX, sizeY);
        view.getWarnPanel().connect((IPauseTimer) game); // Conecta o timer ao painel de avisos, para que o jogo pause a execução caso haja algum aviso.

        for(int y = 0; y < sizeY; y++){
            for(int x = 0; x < sizeX; x++){
                if(matrix[y][x] != '-' && matrix[y][x] != 'P'){
                    InstitutionControl institutionControl = city.insert(x, y, matrix[y][x]);
                    institutionControl.connect(city); // Conecta a interface IUpdateParameters ao Control para que este possa atualizar métodos da cidade.

                    InstitutionView institutionView = view.insert(x, y, matrix[y][x]);
                    institutionView.getInstitutionPanel().connect((IPauseTimer) game); // Conecta o timer ao painel para que o jogo não continue quando o usuário queira mexer em um parâmetro.
                    institutionView.getInstitutionPanel().connect(institutionControl); // Conecta o Control ao painel para permitir que o usuário mude parâmetros através do painel da instituição.

                    institutionControl.connect(institutionView.getInstitutionIcon()); // Conecta o icon ao Control para que o icon seja atualizado caso o control mande.
                } else if(matrix[y][x] == 'P'){
                    mayorX = x;
                    mayorY = y;
                }
            }
        }
        view.setMayor(mayorX, mayorY);
        game.connectComponents(city, view); // conecta o city e o view gerados pelo Builder ao game para a execução.

        city.startUpdate();
    }

    public void connect(IConnectComponents game){
        this.game = game;
    }


}
