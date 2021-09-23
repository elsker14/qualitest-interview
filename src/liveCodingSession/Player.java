package liveCodingSession;

public class Player {
    private Integer lives;
    private String name;

    public Player(String name) {
        this.name = name;
        this.lives = 3;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLives() {
        return lives;
    }

    public void setLives(Integer lives) {
        this.lives = lives;
    }
}
