package game.city.institution;

public interface IActionPanel {
    void invest(int quantity);
    void limitOccupation(double percentage);
    void stopAgglomeration();
}