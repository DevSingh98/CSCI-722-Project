public class Transition {
    public char writeSymbol;
    public char moveDirection; // 'L' or 'R' doesnt need to be case sensitive
    public int nextState;

    public Transition(char writeSymbol, char moveDirection, int nextState) {
        this.writeSymbol = writeSymbol;
        this.moveDirection = moveDirection;
        this.nextState = nextState;
    }
}
