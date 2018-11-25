package app.entities;

public enum Country {
    USA("США"),
    UK("Великобритания"),
    CANADA("Канада"),
    AUSTRALIA("Австралия"),


    RUSSIA("Россия"),
    USSA("СССР");
    private String str;

    public String getStr() {
        return str;
    }

    Country(){}

    Country(String str) {
        this.str = str;
    }
}
