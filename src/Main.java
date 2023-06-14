public class Main {
    public static void main(String[] args) {
        /**
         *  НАДЕЮСЬ, ЧТО ВЫПОЛНЕННОЙ РАБОТЫ ДОСТАТОЧНО ДЛЯ ДЕМОНСТРАЦИИ ПРИНЦИПОВ. я к сожалению не знаю, что еще
         *  придумать, чтобы вписать их в код)) старался как мог)
         *
         *
         *
         */

        /**
         * 4 принцип solid : максимально использовал интерфейс PrintText не только для печати привет и пока,
         * но и для печати уведомлений об добавлении игр в классах AddGames, OldHuman, YongHuman
         */
        Calculator calcGame = new Calculator();
        PrintHi printHi = new PrintHi();
        PrintBy printBy = new PrintBy();
        printHi.printText();

        /**
         * 2 принцип(возможно как еще один пример) solid, если я введу дополнительные игры с параметрами
         * которые не обязательны, могу сделать это не влияя
         * сильнео на код или не влдияя вовсе
         **/
        Game game1 = new GameBuilder()
                .setTitle("Prince of Persia")
                .setPrice(1500)
                .setGanre("RPG")
                .setAgeRestriction(18)
                .setSystemRequirements("GTX 960")
                .setPlatformType("PC")
                .setCountGamers(1)
                .build();

        Game game2 = new GameBuilder()
                .setTitle("BioShock")
                .setPrice(2000)
                .setGanre("приключения")
                .setAgeRestriction(18)
                .setCountGamers(1)
                .build();

        Game game3 = new GameBuilder()
                .setTitle("Overwatch")
                .setPrice(900)
                .setGanre("шутер")
                .build();

        //TODO 1 принцип solid,
        // наверно тогда должно подойти то,
        // что Sort выполняет только сортировку,
        // принты только печатают,
        // Calculator только количество проданных игр
        // (его метод вызываю ниже, когда user делает оплату, строка 74, 75, 81, 82 )

        AddGames addGames = new AddGames()
                .addGame(game1)
                .addGame(game2)
                .addGame(game3);

        calcGame.printText();
        printInfo(addGames);

        //TODO 2 принцип - Open-closed principle - я сделал калькулятор, который будет работать при оплате,
        // таким образом можно посчитать количество проданных игр или переделать под расчет других единиц

        //TODO 3 принцип - Liskov substitution principle - я сделал например интерфейс AddGameInterface,
        // через него я добавляю игры в список магазина и список пользователя,
        // таким образом я не наслудуюсь например пользователем от магазина,
        // так как в магазине я еще и соритрую игры,считаю их колдичество, считает количество игр с возрастным ограничением,
        // а пользователю в данном случае это не важно, так как он не будет например добавлять игры по 100 и более штук,
        // а игры для взрослых в моем случае купить можно, но родители будут знать, так как они получают уведомление,
        // т.е. логика метода изменилась, значит наследование отного классса от другого уже нельзя, для этого сделан интерфейс.
        // Надеюсь я верно понял принципы)


        OldHuman people1 = new OldHuman("Alex", "ttt@mail.com", 20, 100000);
        System.out.println(people1);
        people1.addGame(game1).addGame(game2).getGames();
        people1.removeGame("Prince of Persia");
        calcGame.calc(people1);

        YongHuman people2 = new YongHuman("Anton", "taatt@mail.com", 10, "Anna Viktorovna", 2000);
        System.out.println(people2);
        people2.addGame(game1).addGame(game2).getGames();
        people2.removeGame("BioShock");
        calcGame.calc(people2);

        calcGame.printText();
        printBy.printText();
    }

    /**
     * пример отсутствия магических чисел
     **/
    public static void printInfo(AddGames addGames) {
        /**
         * список из addGames сортируется используя класс Sort -  как пример DRY
         */
        for (int i = 0; i < addGames.gameArrayList.size(); i++) {
            System.out.println(addGames.gameArrayList.get(i));
        }
    }
}