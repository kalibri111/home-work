package com.sbrf.reboot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response implements Dto{
    private String statusCode;

    public String getStatusCode() {
        return statusCode;
    }
}
