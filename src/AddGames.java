import java.util.ArrayList;
import java.util.List;

public class AddGames implements PrintText {
    protected List<Game> gameArrayList = new ArrayList<>();

    public AddGames addGame(Game game) {
        gameArrayList.add(game);
        printText();
        Sort.sortByTitle(gameArrayList);
        return this;
    }


    @Override
    public void printText() {
        System.out.format("Game added in market - %s!\n" +
                        "+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-\n"
                , gameArrayList.get(gameArrayList.size() - 1).title);
    }
}
