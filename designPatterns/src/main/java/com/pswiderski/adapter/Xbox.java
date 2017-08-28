package com.pswiderski.adapter;

import lombok.extern.slf4j.Slf4j;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

@Slf4j
public class Xbox implements SourceInterface {

  @Override
  public void playPlayStationGame(Game game) {
    throw new NotImplementedException();
  }

  @Override
  public void playPCGame(Game game) {
    throw new NotImplementedException();
  }

  public void playXboxGame(Game game) {
    log.info("Playing game:" + game + " on Xbox console.");
  }

}
