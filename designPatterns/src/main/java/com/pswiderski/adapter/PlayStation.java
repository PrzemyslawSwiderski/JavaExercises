package com.pswiderski.adapter;

import lombok.extern.slf4j.Slf4j;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

@Slf4j
public class PlayStation implements SourceInterface {

    public void playPlayStationGame(Game game) {
        log.info("Playing game: " + game + " on PlayStation console.");
    }

    @Override
    public void playPCGame(Game game) {
        throw new NotImplementedException();
    }

    @Override
    public void playXboxGame(Game game) {
        throw new NotImplementedException();
    }

}
