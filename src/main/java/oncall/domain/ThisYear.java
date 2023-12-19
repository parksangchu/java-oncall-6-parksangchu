package oncall.domain;

public enum ThisYear {
    THIS_YEAR(2023);

    private final int number;

    ThisYear(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
