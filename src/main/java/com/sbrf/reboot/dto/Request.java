package com.sbrf.reboot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Request {
    public String atmNumber;

    public String getAtmNumber() {
        return atmNumber;
    }
}
