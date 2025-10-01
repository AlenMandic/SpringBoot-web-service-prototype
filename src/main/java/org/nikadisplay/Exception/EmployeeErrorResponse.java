package org.nikadisplay.Exception;

import java.time.LocalDateTime;

public class EmployeeErrorResponse {

    private String errorCode;
    private String errorMessage;
    private LocalDateTime errorTimeStamp;

    public EmployeeErrorResponse(String errorCode, String errorMessage, LocalDateTime errorTimeStamp) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.errorTimeStamp = errorTimeStamp;
    }

    public String getErrorCode() { return errorCode; }
    public void setErrorCode(String newErrorCode) { this.errorCode = newErrorCode; }

    public String getErrorMessage() { return errorMessage; }
    public void setErrorMessage(String newErrorMessage ) { this.errorMessage = newErrorMessage; }

    public LocalDateTime geterrorTimeStamp() { return errorTimeStamp; }
    public void seterrorTimeStamp( LocalDateTime newErrorTimeStamp ) { this.errorTimeStamp = newErrorTimeStamp; }

}