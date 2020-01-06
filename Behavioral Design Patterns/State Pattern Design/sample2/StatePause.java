package ir.adicom.dp.state.sample2;

public class StatePause extends State {
    @Override
    public void pressPlay(Player player) {
        System.out.println("Pause");
        player.setState(new StatePlay());
    }
}
