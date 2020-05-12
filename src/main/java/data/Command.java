package data;

public class Command {

    private final String text;

    public Command(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public boolean isEnd(){
        return false;
    }

    public boolean isNew(){
        return false;
    }

    public boolean isTurn(){
        return false;
    }

}
