import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sort {
    /**
     * Пример DRY, использую этот класс для сортировки игр в магазине и у пользователя
     */
    public static List<Game> sortByTitle(List<Game> games) {
        Collections.sort(games, Comparator.comparing(Game::getTitle));
        return games;
    }
}
