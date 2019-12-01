package ir.adicom.dp.state.sample2;

public class Main {
    public static void main(String[] args) {
        Player player = new Player(new StatePlay());
        player.play();
        player.play();
        player.play();
    }
}
