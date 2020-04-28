package util.model;

public enum TestResultsStatus {

    SUBMITTED("submitted"), CANCELED("cancelled"), INVALID("invalid");

    private String status;

    TestResultsStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

}
