package com.pswiderski.adapter;

public class GamesAdapterImpl implements GamesAdapter {

  private PcComputer pcComputer = new PcComputer();

  private PlayStation playStation = new PlayStation();

  private Xbox xbox = new Xbox();

  @Override
  public void playGame(Game game) {

    switch (game.getConsoleType()) {
      case "PC":
        pcComputer.playPCGame(game);
        break;
      case "PLAYSTATION":
        playStation.playPlayStationGame(game);
        break;
      case "XBOX":
        xbox.playXboxGame(game);
        break;
      default:
        throw new IllegalArgumentException("Console type not supported");
    }

  }

}
