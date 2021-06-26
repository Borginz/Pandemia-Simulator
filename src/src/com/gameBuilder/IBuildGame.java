package com.gameBuilder;

import com.exceptions.RepeatedComponentsException;

import java.io.IOException;

public interface IBuildGame {
    Level[] createLevels() throws IOException, RepeatedComponentsException;
    void buildGame(Level level) throws IOException;
}
