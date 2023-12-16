package oncall.domain;

public enum Constants {
    THIS_YEAR(2023);

    private final int number;

    Constants(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
