package com.pswiderski.adapter;

public class GamesAdapterClassImpl implements SourceInterface, GamesAdapter {

    @Override
    public void playGame(Game game) {

        switch (game.getConsoleType()) {
            case "PC":
                playPCGame(game);
                break;
            case "PLAYSTATION":
                playPlayStationGame(game);
                break;
            case "XBOX":
                playXboxGame(game);
                break;
            default:
                throw new IllegalArgumentException("Console type not supported");
        }

    }

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
