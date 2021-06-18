package game.mayor;


import game.view.IMayorAction;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Mayor implements IMayor, IKeyboard {
    IMayorAction viewAction;
    int x;
    int y;

    public void connect(IMayorAction viewAction){
        this.viewAction = viewAction;
    }
    public void moveMayor(char command){

    }

    public void setPos(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void changePos(int x, int y){
        this.x = x;
        this.y = y;
        viewAction.moveMayor(x, y);
    }

    public void keyPress(char key){
        switch(key){
            case('w'):
                changePos(x, y+1);
                break;
            case('a'):
                changePos(x-1, y);
                break;
            case('s'):
                changePos(x, y-1);
                break;
            case('d'):
                changePos(x+1, y);
                break;
            case(' '):
                viewAction.openPanel();
                break;
            default:
                break;
        }
    }

}
