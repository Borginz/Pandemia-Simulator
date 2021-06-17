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

    public Builder(){
        matrix = new char[][]{ {'P', '-','-','H','-','-','-','B'},
                               {'-', '-','-','-','-','-','-','-'},
                               {'-', '-','S','-','-','-','-','-'},
                               {'I', '-','-','-','C','C','C','C'}};
        sizeX = 8;
        sizeY = 4;
    }

    public void buildGame(){
        city = new City();
        view = new View();
        mayor = new Mayor();

        city.connect(view);
        city.connect((IPauseTimer) game);

        mayor.connect(view);

        city.buildMatrix(sizeX, sizeY);
        view.getCityView().buildMatrix(sizeX, sizeY);
        for(int y = 0; y < sizeY; y++){
            for(int x = 0; x < sizeX; x++){
                if(matrix[y][x] != '-'){
                    InstitutionControl institutionControl = city.insert(x, y, matrix[y][x]);
                    InstitutionView institutionView = view.insert(x, y, matrix[y][x]);
                    institutionControl.connect(city);
                    institutionControl.connect(institutionView);
                    institutionView.getInstitutionPanel().connect(institutionControl);
                }
            }
        }
    }

    public void connect(IConnectComponents game){
        this.game = game;
    }

}
