package backend.assignment.transaction;

import backend.assignment.Market;
import backend.assignment.logging.LogBack;

public class BuyTransaction implements Transaction {
    private String type;
    private String coinName;
    private long quantity;
    private String traderWalletNumber;

    public BuyTransaction(long quantity,String traderWalletNumber){
        this.quantity = quantity;
        this.traderWalletNumber = traderWalletNumber;
    }

    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String getCoinName() {
        return this.coinName;
    }

    @Override
    public void setCoinName(String coinName) {
         this.coinName = coinName;
    }

    @Override
    public boolean executeTransaction() {
        boolean isSuccessful = false;
        try {
            isSuccessful = Market.getMarket_instance().buyCoin(traderWalletNumber,coinName,quantity);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        if(isSuccessful)
        {
            LogBack.infoLogger("Coin Bought Successfully!");}
        else {
            LogBack.debugLogger("Coin coundn't be Bought");
        }
        return isSuccessful;
    }
}
