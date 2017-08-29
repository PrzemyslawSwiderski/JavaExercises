package com.pswiderski.command;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CreateAuction implements AuctionOperation {

  @Override
  public void execute() {
    log.info("Creating new Auction");
  }
}
