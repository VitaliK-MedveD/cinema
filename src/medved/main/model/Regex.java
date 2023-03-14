package medved.main.model;

public enum Regex {

    REGEX_LOGIN ("^[A-Za-z]\\w{3,29}$"),
    REGEX_PASWORD ("^[a-zA-Z0-9]{4,20}$"),
    REGEX_EMAIL ("^[-\\w.]+@([A-z0-9][-A-z0-9]+\\.)+[A-z]{2,4}$"),
    REGEX_DATE ("[0-9]{4}-(0[1-9]|1[012])-(0[1-9]|1[0-9]|2[0-9]|3[01])");

    String regex;

    Regex(String regex) {
        this.regex = regex;
    }

    public String getRegex() {
        return regex;
    }
}
