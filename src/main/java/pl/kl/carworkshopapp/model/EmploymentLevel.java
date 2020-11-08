package pl.kl.carworkshopapp.model;

public enum EmploymentLevel {
    JUNIOR ("Uczeń mechanik"),
    MID ("Mechanik"),
    SENIOR ("Starszy mechanik");

    private String commonName;

    EmploymentLevel(String commonName) {
        this.commonName = commonName;
    }

    public String getCommonName() {
        return commonName;
    }
}
