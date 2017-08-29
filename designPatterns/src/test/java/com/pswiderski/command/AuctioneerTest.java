package com.pswiderski.command;

import org.junit.Test;

public class AuctioneerTest {

  @Test
  public void executeOperations() {
    Auctioneer auctioneer = new Auctioneer();

    auctioneer.addAuctionOperation(new CreateAuction());
    auctioneer.addAuctionOperation(new CreateAuction());
    auctioneer.addAuctionOperation(new BidAuction());
    auctioneer.addAuctionOperation(new CreateAuction());
    auctioneer.addAuctionOperation(new DeleteAuction());
    auctioneer.addAuctionOperation(new BidAuction());
    auctioneer.addAuctionOperation(new DeleteAuction());
    auctioneer.addAuctionOperation(new BidAuction());
    auctioneer.addAuctionOperation(new DeleteAuction());
    auctioneer.addAuctionOperation(new DeleteAuction());

    auctioneer.executeOperations();

    auctioneer.executeOperations();
  }

}