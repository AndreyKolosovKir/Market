import java.util.ArrayList;
import java.util.List;

public class AddGames implements PrintText, AddGameInterface {

    protected int countGames = 0;
    protected int countGamesForOld = 0;
    protected List<Game> gameArrayList = new ArrayList<>();

    @Override
    public AddGames addGame(Game game) {
        gameArrayList.add(game);
        countGames = gameArrayList.size();
        if (game.getAgeRestriction() >= 18) {
            countGamesForOld++;
        }
        printText();
        Sort.sortByTitle(gameArrayList);

        return this;
    }


    @Override
    public void printText() {
        System.out.format("Game added in market - %s!\n" +
                        "in market %d games\n" +
                        "adult game %d\n" +
                        "+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-\n"
                , gameArrayList.get(gameArrayList.size() - 1).title, countGames, countGamesForOld);
    }
}
