package game.city.institution;

public interface IActionPanel {
    void invest(int quantity);
    void limitOccupation(int percentage);
    void stopAgglomeration();
    int getParameter(char type);
}