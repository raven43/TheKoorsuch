package app.entities;

public enum Genre {
    ROMANCE("Мелодрамма"),
    COMEDY("Комедия"),
    SCIFI("Фантастика"),
    FANTASY("Фэнтези"),
    ADVENTURE("Приключения"),
    HORROR("Ужастик"),
    DOCUMENTARY("Документальный"),
    ANIMATION("Мультфильм"),
    TRILLER("Триллер"),
    DRAMA("Драмма"),
    ACTION("Боевик"),
    DETECTIVE("Детектив");
    String str;

    public String getStr() {
        return str;
    }

    Genre(){}
    Genre(String s){
        this.str = s;
    }
}