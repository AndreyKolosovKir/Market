import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class YongHuman implements PrintText, AddGameInterface, GetGameInterface, RemoveGameInterface, PayForGameInterface {
    protected String name;
    protected String mail;
    protected int age;
    protected String parents;

    protected int cash;
    protected List<Game> listGameForUser = new ArrayList<>();

    public YongHuman(String name, String mail, int age, String parents, int cash) {
        this.name = name;
        this.mail = mail;
        this.age = age;
        this.parents = parents;
        this.cash = cash;
    }

    @Override
    public YongHuman addGame(Game game) {
        listGameForUser.add(game);
        printText();
        return this;
    }

    @Override
    public YongHuman getGames() {
        Sort.sortByTitle(listGameForUser);
        for (int i = 0; i < listGameForUser.size(); i++) {
            System.out.println(listGameForUser.get(i));
        }
        return this;
    }

    @Override
    public YongHuman removeGame(String title) {
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
        return String.format(">>>>>>>>>>>>>>>>Yong>>>>>>>>>>>>>>>\n" +
                "Name: %s, mailParents: %s, age: %d\n" +
                "Parents: %s\n" +
                ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n", name, mail, age, parents);
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
            price = (int) listGameForUser.get(i).price;
            if (price <= cash) {
                countPay++;
                cash -= price;
                removeGame(listGameForUser.get(i).title);
                System.out.format("We sent message to %s for your parent %s, with the amount of payment %d.\n",
                        mail, parents, price);

            } else {
                System.out.format("Not enough money. We sent message to %s for your parent %s.\n",
                        mail, parents);
            }
        }
        return countPay;
    }
}
