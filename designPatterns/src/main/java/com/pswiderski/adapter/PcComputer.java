package com.pswiderski.adapter;

import lombok.extern.slf4j.Slf4j;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

@Slf4j
public class PcComputer implements SourceInterface{

  @Override
  public void playPlayStationGame(Game game) {
    throw new NotImplementedException();
  }

  public void playPCGame(Game game) {
    log.info("Playing game:" + game + " on PC.");
  }

  @Override
  public void playXboxGame(Game game) {
    throw new NotImplementedException();
  }


}
