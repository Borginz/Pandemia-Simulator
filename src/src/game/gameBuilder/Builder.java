package game.gameBuilder;

import game.city.*;
import game.city.institution.*;
import game.gameControl.IConnectComponents;
import game.gameControl.IGame;
import game.gameControl.IPauseTimer;
import game.mayor.*;
import game.view.*;
import game.view.institutionview.*;

public class Builder implements IBuilder {
    char[][] matrix;
    City city;
    View view;
    Mayor mayor;
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

    public void buildGame(String directory){
        int mayorX = 0;
        int mayorY = 0;
        city = new City();
        view = new View();
        mayor = new Mayor();

        city.connect(view);
        city.connect((IPauseTimer) game);
        city.setPopulation(population);

        mayor.connect(view);
        view.setPopulation(population);

        view.setDirectory(directory);

        city.buildMatrix(sizeX, sizeY);
        view.getCityView().buildMatrix(sizeX, sizeY);
        for(int y = 0; y < sizeY; y++){
            for(int x = 0; x < sizeX; x++){
                if(matrix[y][x] != '-' && matrix[y][x] != 'P'){
                    InstitutionControl institutionControl = city.insert(x, y, matrix[y][x]);
                    InstitutionView institutionView = view.getCityView().insert(x, y, matrix[y][x]);
                    institutionControl.connect(city);
                    institutionControl.connect(institutionView);
                    institutionView.getInstitutionPanel().connect(institutionControl);
                } else if(matrix[y][x] == 'P'){
                    mayorX = x;
                    mayorY = y;
                }
            }
        }
        mayor.setPos(mayorX, mayorY);
        view.getCityView().setMayor(mayorX, mayorY, directory);
    }

    public void connect(IConnectComponents game){
        this.game = game;
    }

}
