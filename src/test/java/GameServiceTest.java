import example.Game;
import example.GameService;
import io.reactivex.Observable;
import io.reactivex.Observer;
import org.junit.Test;

public class GameServiceTest {
    @Test
    public void gameForSale() {
        GameService gameService = new GameService();

        Observable<Game> gameObservable = gameService.gamesForSale();
        gameObservable.subscribe(
                data -> System.out.println("We got some data: " + data),
                error -> System.out.println("Have error.." + error),
                () -> System.out.println("We are done!")
        );
    }

    @Test
    public void observableVariable() {
        Observable observable = Observable.create(observableEmitter -> {

        });
    }
}
