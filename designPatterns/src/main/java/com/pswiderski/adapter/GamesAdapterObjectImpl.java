package com.pswiderski.adapter;

public class GamesAdapterObjectImpl implements GamesAdapter {

  private SourceInterface sourceInterface = new SourceInterfaceImpl();

  @Override
  public void playGame(Game game) {

    switch (game.getConsoleType()) {
      case "PC":
        sourceInterface.playPCGame(game);
        break;
      case "PLAYSTATION":
        sourceInterface.playPlayStationGame(game);
        break;
      case "XBOX":
        sourceInterface.playXboxGame(game);
        break;
      default:
        throw new IllegalArgumentException("Console type not supported");
    }

  }
}
