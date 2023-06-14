public class Main {
    public static void main(String[] args) {
        /**
         *  НАДЕЮСЬ, ЧТО ВЫПОЛНЕННОЙ РАБОТЫ ДОСТАТОЧНО ДЛЯ ДЕМОНСТРАЦИИ ПРИНЦИПОВ. я к сожалению не знаю, что еще
         *  придумать, чтобы вписать их в код)) старался как мог)
         *
         *
         *
         *
         * 2 принципе solid : Добавил как пример Open-closed principle, что код изменился, но по сути структура та же
         * не смог уже ничего лучше придумать, когда нет конкретнрого задания и српоки ограничены
         *
         * 4 принцип solid : максимально использовал интерфейс PrintText не только для печати привет и пока,
         * но и для печати уведомлений об добавлении игр в классах AddGames, OldHuman, YongHuman
         */
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
        /**
         *1 принцип solid, класс который добавляет новые игры в магазин
         **/
        AddGames addGames = new AddGames()
                .addGame(game1)
                .addGame(game2)
                .addGame(game3);

        printInfo(addGames);

        /**
         * 3 принцип solid, сделал двух людей старого и молождого, отличий там немного, но это принципе Liskov substitution principle
         * так как это люди независимо от возраста и статуса
         */

        OldHuman people1 = new OldHuman("Alex", "ttt@mail.com", 20);
        System.out.println(people1);
        people1.addGame(game1).addGame(game2).getGames();
        people1.removeGame("Prince of Persia");

        YongHuman people2 = new YongHuman("Anton", "taatt@mail.com", 10, "Anna Viktorovna");
        System.out.println(people2);
        people2.addGame(game1).addGame(game2).getGames();
        people2.removeGame("BioShock");


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