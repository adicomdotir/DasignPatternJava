package ir.adicom.dp.state.sample2;

public class Player {
    private State state;

    public Player(State state) {
        this.state = state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void play() {
        state.pressPlay(this);
    }
}
