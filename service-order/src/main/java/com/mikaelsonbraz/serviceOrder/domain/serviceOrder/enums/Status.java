package com.mikaelsonbraz.serviceOrder.domain.serviceOrder.enums;

public enum Status {

    TO_DO(0, "Open service order"),
    IN_PROGRESS(1, "Service order in progress"),
    DONE(2, "Finished service order");

    private int code;
    private String description;

    Status() {
    }

    Status(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public static Status toEnum(Integer code){

        if(code == null){
            throw new IllegalArgumentException("Invalid code: " + code + " _ Available codes: 0- To do service order, 1- Order in progress, 2- Service order finished");
        }

        for(Status x : Status.values()){
            if(code.equals(x.getCode())){
                return x;
            }
        }

        throw new IllegalArgumentException("Invalid code: " + code + " _ Available codes: 0- To do service order, 1- Order in progress, 2- Service order finished");
    }
}
