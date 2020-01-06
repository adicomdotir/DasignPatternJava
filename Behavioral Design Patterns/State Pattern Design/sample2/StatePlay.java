package ir.adicom.dp.state.sample2;

public class StatePlay extends State {
    @Override
    public void pressPlay(Player player) {
        System.out.println("Play");
        player.setState(new StatePause());
    }
}
