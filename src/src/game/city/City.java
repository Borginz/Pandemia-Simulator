package game.city;

import game.city.institution.InstitutionControl;

public class City {
    InstitutionControl[][] board;
    InstitutionControl[] institutions;
    int sizeX;
    int sizeY;
    int population;
    int deaths;
    int immunized;
    int money;
    double infectedPercentage;
    double mayorApprovalPercentage;
}
