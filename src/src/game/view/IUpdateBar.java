package game.view;

public interface IUpdateBar {
    void setMoney(int quantity);
    void setApproval(int percentage);
    void setDeaths(int quantity);
    void setInfected(int quantity);
    void setImmunized(int quantity);
    void setPopulation(int quantity);
}
