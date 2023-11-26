package br.com.devDojo.awesome.error;

import org.springframework.http.HttpStatusCode;

public class CustomErrorType  {
    public String errorMessage;


    public CustomErrorType(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }


    public int value() {
        return 0;
    }


    public boolean is1xxInformational() {
        return false;
    }


    public boolean is2xxSuccessful() {
        return false;
    }


    public boolean is3xxRedirection() {
        return false;
    }


    public boolean is4xxClientError() {
        return false;
    }


    public boolean is5xxServerError() {
        return false;
    }


    public boolean isError() {
        return false;
    }

    public Object getMessage() {
        return errorMessage;
    }
}
