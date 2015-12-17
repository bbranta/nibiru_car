package com.motorola.carroagora;

/**
 * Created by rbresil on 12/17/15.
 */
public class MessageResponse {
    private String status;
    private String message;


    public void setStatus(String status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {

        return status;
    }

    public String getMessage() {
        return message;
    }
}
