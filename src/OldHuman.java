import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class OldHuman implements PrintText, AddGameInterface, GetGameInterface, RemoveGameInterface, PayForGameInterface {
    protected String name;
    protected String mail;
    protected int age;
    protected int cash;
    protected List<Game> listGameForUser = new ArrayList<>();

    public OldHuman(String name, String mail, int age, int cash) {
        this.name = name;
        this.mail = mail;
        this.age = age;
        this.cash = cash;
    }

    @Override
    public OldHuman addGame(Game game) {
        listGameForUser.add(game);
        printText();
        return this;
    }

    @Override
    public OldHuman getGames() {
        Sort.sortByTitle(listGameForUser);
        for (int i = 0; i < listGameForUser.size(); i++) {
            System.out.println(listGameForUser.get(i));
        }
        return this;
    }

    @Override
    public OldHuman removeGame(String title) {
        int sizeBefore = listGameForUser.size();

        for (int i = 0; i < listGameForUser.size(); i++) {
            if (Objects.equals(listGameForUser.get(i).title, title)) {
                listGameForUser.remove(i);
            }
        }
        int sizeAfter = listGameForUser.size();
        if (sizeBefore == sizeAfter) {
            System.out.println("Don't make it\n");
        } else {
            System.out.format("Game %s remove!!!\n", title);
        }
        return this;
    }

    @Override
    public String toString() {
        return String.format("<<<<<<<<<<<<<<<<Old<<<<<<<<<<<<<<<<\n" +
                "Name: %s, mail: %s age: %d\n" +
                "<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<\n", name, mail, age);
    }

    @Override
    public void printText() {
        System.out.println("The game has been added to the user's shopping cart!");
    }

    @Override
    public int pay() {
        int price = 0;
        int countPay = 0;
        for (int i = 0; i < listGameForUser.size(); i++) {
            price += listGameForUser.get(i).price;
            if (price <= cash) {
                countPay++;
                cash -= price;
                removeGame(listGameForUser.get(i).title);
            } else {
                System.out.println("Not enough money");
            }
        }
        return countPay;
    }
}
