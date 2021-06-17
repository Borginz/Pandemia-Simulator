package game.mayor;


import game.view.IMayorAction;

public class Mayor implements IMayor{
    IMayorAction viewAction;

    public void connect(IMayorAction viewAction){
        this.viewAction = viewAction;
    }
    public void move(char command){

    }
}
