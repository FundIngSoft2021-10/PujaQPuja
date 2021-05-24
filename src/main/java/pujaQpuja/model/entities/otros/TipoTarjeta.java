package pujaQpuja.model.entities.otros;

public enum TipoTarjeta {
    VISA, MASTERCARD, VISA_NACIONAL, MASTERCARD_NACIONAL;


    public String getVisa() {
        return "Visa";
    }

    public String getMasterCard() {
        return "Master Card";
    }

    public String getVisaNacional() {
        return "Visa (Nacional)";
    }

    public String getMasterCardNacional() {
        return "Master Card (Nacional)";
    }

}
