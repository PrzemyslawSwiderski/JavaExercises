package com.pswiderski.command;

import java.util.ArrayList;
import java.util.List;

public class Auctioneer {

  List<AuctionOperation> auctionOperations = new ArrayList<>();

  public void addAuctionOperation(AuctionOperation auctionOperation) {
    auctionOperations.add(auctionOperation);
  }

  public void executeOperations() {

    for (AuctionOperation auctionOperation : auctionOperations) {
      auctionOperation.execute();
    }

    auctionOperations.clear();
  }

}
