package classes;

public class Player {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (this.name.length() >= 3) {
            this.name = name;
        }else
        {
            System.out.printf("%s is not valid!\n", name);
        }
    }
//---------------------------------------------------------CONSTRUCTOR
    public Player(String name) {
        setName(name);
    }
}
