public class GameBuilder {
    protected String title;
    protected String ganre;
    protected double price;
    protected int ageRestriction;
    protected int countGamers;
    protected String platformType;
    protected String systemRequirements;

    public GameBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public GameBuilder setGanre(String ganre) {
        this.ganre = ganre;
        return this;
    }

    public GameBuilder setPrice(double price) {
        this.price = price;
        return this;
    }

    public GameBuilder setAgeRestriction(int ageRestriction) {
        this.ageRestriction = ageRestriction;
        return this;
    }

    protected GameBuilder setCountGamers(int countGamers) {
        this.countGamers = countGamers;
        return this;
    }

    public GameBuilder setPlatformType(String platformType) {
        this.platformType = platformType;
        return this;
    }

    public GameBuilder setSystemRequirements(String systemRequirements) {
        this.systemRequirements = systemRequirements;
        return this;
    }

    Game build() {
        if (title == null || ganre == null || price == 0) {
            throw new IllegalStateException("Title, ganre and price must be specified");
        }
        return new Game(this);
    }
}
