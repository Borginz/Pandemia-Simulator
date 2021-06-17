package game.gameBuilder;

import game.city.*;
import game.city.institution.*;
import game.gameControl.IConnectComponents;
import game.gameControl.IPauseTimer;
import game.mayor.*;
import game.view.*;
import game.view.institutionview.*;

public class Builder implements IRConnectComponents {
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

    public void buildGame(IPauseTimer timerControl){
        city = new City();
        view = new View();
        mayor = new Mayor();
        city.buildMatrix(sizeX, sizeY);
        for(int y = 0; y < sizeY; y++){
            for(int x = 0; x < sizeX; x++){
                if(matrix[y][x] != '-'){
                    InstitutionControl institControl = city.insert(x, y, matrix[y][x]);
                    InstitutionView institView = view.insert(x, y, matrix[y][x]);
                    institControl.connect((IUpdateParameters) city);
                    institControl.connect((IUpdateView) institView);
                }
            }
        }
    }

    public void connect(IConnectComponents game){
        this.game = game;
    }

}
