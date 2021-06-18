package game.view;

import game.view.institutionview.InstitutionView;
import game.view.institutionview.butantan.ButantanView;
import game.view.institutionview.hospital.HospitalView;
import game.view.institutionview.house.HouseView;
import game.view.institutionview.industry.IndustryView;
import game.view.institutionview.shop.ShopView;

import javax.swing.*;
import java.awt.*;

public class CityView extends JLayeredPane {
    private int sizeX;
    private int sizeY;
    private MayorIcon mayorIcon;
    private String directory;
    private InstitutionView[][] board;
    JPanel[][] panelHolder;
    JPanel[][] panelHolderMayor;

    public CityView(){
        super();
    }

    public void assembleView(){
        panelHolder = new JPanel[sizeY][sizeX];
        panelHolderMayor = new JPanel[sizeY][sizeX];
        setLayout(new GridLayout(sizeX,sizeY,10,10));

        for(int y = 0; y < sizeY; y++){
            for(int x = 0; x < sizeX; x++){
                panelHolder[y][x] = new JPanel();
                panelHolderMayor[y][x] = new JPanel();
                add(panelHolder[y][x],0);
                add(panelHolderMayor[y][x], 1);
                if(board[y][x] != null){
                    panelHolder[y][x].add(board[y][x].getInstitutionIcon());
                }
            }
        }
        panelHolderMayor[mayorIcon.getY()][mayorIcon.getX()].add(mayorIcon);

    }

    public void setMayor(int x, int y, String directory){
        mayorIcon = new MayorIcon(x, y, directory);
    }

    public void setMayorPos(int x, int y, boolean occupied){
        mayorIcon.setOccupied(occupied);
        panelHolderMayor[mayorIcon.getY()][mayorIcon.getX()].removeAll();
        mayorIcon.setX(x);
        mayorIcon.setY(y);
        panelHolderMayor[mayorIcon.getY()][mayorIcon.getX()].add(mayorIcon);
    }

    public void buildMatrix(int sizeX, int sizeY){
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        board = new InstitutionView[sizeY][sizeX];
    }

    public void openPanel(){
        board[mayorIcon.getY()][mayorIcon.getX()].getInstitutionPanel().openPanel();
    }

    public void setDirectory(String directory){
        this.directory = directory;
    }

    public boolean isOccupied(int x, int y){
        return board[y][x] != null;
    }

    public InstitutionView insert(int x, int y, char id){
        InstitutionView institution = switch (id) {
            case ('H') -> new HospitalView();
            case ('S') -> new ShopView();
            case ('I') -> new IndustryView();
            case ('B') -> new ButantanView();
            case ('C') -> new HouseView();
            default -> null; // TODO: THROW ERROR
        };

        institution.createObjects(directory); // TODO: TREAT NULL POINTER

        if(board[y][x] == null){
            board[y][x] = institution; // TODO: THROW ERROR IF ITS ALREADY OCCUPIED
        }
        return(institution);
    }
}
