package game.city;

public interface IUpdateParameters {
    void updateMoney(int quantityDelta);
    void updateApproval(int quantityDelta);
    void updateInfected(int quantityDelta);
    void updateImmunized(int quantityDelta);
    void updateDeaths(int quantityDelta);
    int getPopulationActive();
}
