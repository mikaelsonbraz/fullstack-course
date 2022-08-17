package com.mikaelsonbraz.serviceOrder.domain.enums;

public enum PriorityLevel {

    LOW(0, "Low priority"),
    MEDIUM(1, "Medium priorrity"),
    HIGH(2, "High priority");

    private int code;
    private String description;

    PriorityLevel() {
    }

    PriorityLevel(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public static PriorityLevel toEnum(Integer code){

        if(code == null){
            throw new IllegalArgumentException("Invalid code: " + code + " _ Available codes: 0- Low, 1- Medium, 2- High");
        }

        for (PriorityLevel x : PriorityLevel.values()){
            if(code.equals(x.getCode())){
                return x;
            }
        }

        throw new IllegalArgumentException("Invalid code: " + code + " _ Available codes: 0- Low, 1- Medium, 2- High");
    }
}
