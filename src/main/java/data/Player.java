package data;

public enum Player {

    P1,
    P2;

    public Player next() {
        switch (this) {
            case P1 -> {
                return P2;
            }
            case P2 -> {
                return P1;
            }
            default -> throw new IllegalArgumentException();
        }
    }

}
