package game.city;

public interface IUpdateParameters {
    void updateMoney(int quantityDelta);
    void updateApproval(int quantityDelta);
    void updateInfected(int quantityDelta);
    void updateImmunized(int quantityDelta);
    void updateDeaths(int quantityDelta);
    void updatePopulationWorking(int percentage, char type);
    int getPopulationActive();
}
