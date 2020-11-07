package pl.kl.carworkshopapp.model;

public enum EngineType {
    PETROL ("Benzyna"),
    DIESEL ("Diesel");

    private String commonName;

    EngineType(String commonName) {
        this.commonName = commonName;
    }

    public String getCommonName() {
        return commonName;
    }
}
