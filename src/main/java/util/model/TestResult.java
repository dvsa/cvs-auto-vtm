package util.model;

public enum TestResult {

    PASS("pass"), FAIL("fail"), PRS("prs");

    private String result;

    TestResult(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }

}

