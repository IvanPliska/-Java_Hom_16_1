import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class GameTest {

    Game game = new Game();
    Player p1 = new Player(1, "Ivan", 15);
    Player p2 = new Player(2, "Lida", 25);
    Player p3 = new Player(3, "Egor", 10);
    Player p4 = new Player(4, "Oleg", 25);

    @Test
    public void unknownAllPlayers() {
        assertThrows(NotRegisteredException.class, () -> {
            game.round("unknown1", "unknown2");
        });
    }

    @Test
    public void unknownFirstPlayers() {
        game.register(p1);
        game.register(p2);
        game.register(p3);
        game.register(p4);

        assertThrows(NotRegisteredException.class, () -> {
            game.round(p1.getName(), "unknown2");
        });
    }

    @Test
    public void unknownSecondPlayers() {
        game.register(p1);
        game.register(p2);
        game.register(p3);
        game.register(p4);

        assertThrows(NotRegisteredException.class, () -> {
            game.round("unknown1", p3.getName());
        });
    }

    @Test
    public void strengthSecondPlayers() {
        game.register(p1);
        game.register(p2);
        game.register(p3);
        game.register(p4);

        int actual = game.round(p1.getName(), p2.getName());
        int expected= 2;
        assertEquals(expected,actual);
    }

    @Test
    public void strengthFirstPlayers() {
        game.register(p1);
        game.register(p2);
        game.register(p3);
        game.register(p4);

        int actual = game.round(p1.getName(), p3.getName());
        int expected= 1;
        assertEquals(expected,actual);
    }

    @Test
    public void strengthEqualPlayers() {
        game.register(p1);
        game.register(p2);
        game.register(p3);
        game.register(p4);

        int actual = game.round(p2.getName(), p4.getName());
        int expected= 0;
        assertEquals(expected,actual);
    }
}
