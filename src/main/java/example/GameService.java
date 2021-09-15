package example;

import io.reactivex.Observable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class GameService {
    private static final List<Game> GAMES = Collections.unmodifiableList(Arrays.asList(
            new Game("Game 1", 99.0, 10),
            new Game("Game 2", 45.0, 4),
            new Game("Game 3", 4234.0, 6),
            new Game("Game 4", 544.0, 6),
            new Game("Game 5", 78.0, 9),
            new Game("Game 6", 965.0, 11)
    ));

    public Observable<Game> gamesForSale() {
        return Observable.create(observableEmitter -> {
            int i = 0;
            System.out.println("Start sending games");
            while (!observableEmitter.isDisposed() && i < GAMES.size()) {
                Game game = GAMES.get(i);
                if(game.getStorage() == 0) {
                    observableEmitter.onError(new RuntimeException("Oppsss... the game is not on stck. " + game));
                }

                observableEmitter.onNext(game);
                i++;
            }

            System.out.println("Done sending games");
            observableEmitter.onComplete();
        });
    }
}
