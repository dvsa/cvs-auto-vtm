package util.model;

import java.util.Arrays;
import java.util.List;

public enum VehicleClass {
    TWO("2", "motorbikes over 200cc or with a sidecar"),
    N("n", "not applicable"),
    S("s", "small psv (ie: less than or equal to 22 seats)"),
    ONE("1", "motorbikes up to 200cc"),
    T("t", "trailer"),
    L("l", "large psv(ie: greater than 23 seats)"),
    THREE("3", "3 wheelers"),
    V("v", "heavy goods vehicle"),
    FOUR("4", "MOT class 4"),
    SEVEN("7", "MOT class 7"),
    FIVE("5", "MOT class 7"),
    P("p", "PSV of unknown or unspecified size"),
    U("u", "Not Known");

    private final String code;
    private final String description;

    VehicleClass(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return this.code;
    }

    public String getDescription() {
        return this.description;
    }

    public String getDescription(String code) {
        String description = null;
        if (this.getCode().contentEquals(code)) {
            description = this.getDescription();
        }
        return description;
    }
}
