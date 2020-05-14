package data;

public class Command {

    private final String text;

    public Command(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public boolean isEnd() {
        return "ende".equalsIgnoreCase(text);
    }

    public boolean isNew() {
        return "neu".equalsIgnoreCase(text);
    }

    public boolean isTurn() {
        return !isEnd() && !isNew();
    }

}
