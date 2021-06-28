package com.gameBuilder;

import com.exceptions.InvalidPositionException;
import com.exceptions.RepeatedComponentsException;

import java.io.IOException;

public interface IBuildGame {
    Level[] createLevels() throws IOException, RepeatedComponentsException, InvalidPositionException;
    void buildGame(Level level) throws IOException;
}
