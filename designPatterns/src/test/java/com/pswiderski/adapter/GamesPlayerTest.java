package com.pswiderski.adapter;

import org.junit.Test;

public class GamesPlayerTest {

  @Test
  public void play() throws Exception {
    GamesAdapterImpl gamesPlayer = new GamesAdapterImpl();

    Game pcGame = new Game();
    pcGame.setConsoleType("PC");
    pcGame.setTitle("Rome: Total War");

    Game xBoxGame = new Game();
    xBoxGame.setConsoleType("XBOX");
    xBoxGame.setTitle("Minecraft");

    Game playStationGame = new Game();
    playStationGame.setConsoleType("PLAYSTATION");
    playStationGame.setTitle("The Legend of Zelda");

    gamesPlayer.playGame(pcGame);
    gamesPlayer.playGame(xBoxGame);
    gamesPlayer.playGame(playStationGame);

  }

}