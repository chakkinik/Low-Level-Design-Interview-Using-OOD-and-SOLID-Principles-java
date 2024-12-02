package TicToe;

public class Square {

    private String symbol;

    Square(int i, int j){
    this.symbol =i+""+j;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}
