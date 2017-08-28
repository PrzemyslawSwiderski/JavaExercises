package com.pswiderski.adapter;

public class SourceInterfaceImpl implements SourceInterface{

  @Override
  public void playPlayStationGame(Game game) {
    new PlayStation().playPlayStationGame(game);
  }

  @Override
  public void playPCGame(Game game) {
    new PcComputer().playPCGame(game);
  }

  @Override
  public void playXboxGame(Game game) {
    new Xbox().playXboxGame(game);
  }
}
