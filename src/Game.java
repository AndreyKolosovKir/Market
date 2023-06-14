public class Game {

    protected final String title;
    protected final String ganre;
    protected final double price;
    protected int ageRestriction;
    protected int countGamers;
    protected String platformType;
    protected String systemRequirements;


    public Game(final GameBuilder gameBuilder) {
        this.title = gameBuilder.title;
        this.ganre = gameBuilder.ganre;
        this.price = gameBuilder.price;
        setAgeRestriction(gameBuilder.ageRestriction);
        setCountGamers(gameBuilder.countGamers);
        setPlatformType(gameBuilder.platformType);
        setSystemRequirements(gameBuilder.systemRequirements);
    }

    public String getTitle() {
        return title;
    }

    public String getGanre() {
        return ganre;
    }

    public double getPrice() {
        return price;
    }

    public int getAgeRestriction() {
        return Math.max(ageRestriction, 0);
    }

    public String getPlatformType() throws NullPointerException {
        if (platformType != null && !platformType.isEmpty()) {
            return platformType;
        } else {
            return "MultiPlatform";
        }
    }

    public String getSystemRequirements() throws NullPointerException {
        if (systemRequirements != null && !systemRequirements.isEmpty()) {
            return systemRequirements;
        } else {
            return "Not system requirements";
        }
    }

    public int getCountGamers() {
        if (countGamers == 0) {
            return 1;
        } else {
            return countGamers;
        }
    }

    public void setAgeRestriction(int ageRestriction) {
        this.ageRestriction = ageRestriction;
    }

    public void setCountGamers(int countGamers) {
        this.countGamers = countGamers;
    }

    public void setPlatformType(String platformType) {
        this.platformType = platformType;
    }

    public void setSystemRequirements(String systemRequirements) {
        this.systemRequirements = systemRequirements;
    }

    @Override
    public String toString() {
        return String.format("Title: %s,\n " +
                        "Ganre: %s,\n " +
                        "Price: %.2f rub,\n " +
                        "AgeRestriction: %d+,\n " +
                        "CountGamers: %d,\n " +
                        "PlatformType: %s,\n " +
                        "SystemRequirements: %s.\n" +
                        "--------------------------------------------------\n",
                getTitle(),
                getGanre(),
                getPrice(),
                getAgeRestriction(),
                getCountGamers(),
                getPlatformType(),
                getSystemRequirements());
    }
}
