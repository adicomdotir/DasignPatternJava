public class BitcoinAdapter implements IranianBank {
    private BitcoinPayment bitcoinPayment;
    public BitcoinAdapter(BitcoinPayment bitcoinPayment) {
        this.bitcoinPayment = bitcoinPayment;
    }

    public void Payment(int price) {
        int convertedPrice = price / 1000;
        bitcoinPayment.DoTransaction(convertedPrice);
    }
}
