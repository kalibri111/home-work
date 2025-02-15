package com.sbrf.reboot.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.sbrf.reboot.dto.Request;
import com.sbrf.reboot.dto.Response;


public class XMLUtils {
    public static String toXML(Object dto) throws JsonProcessingException {
        XmlMapper mapper = new XmlMapper();
        return mapper.writeValueAsString(dto);
    }

    public static Request XMLtoRequest(String s) throws JsonProcessingException {
        XmlMapper mapper = new XmlMapper();
        return mapper.readValue(s, Request.class);
    }

    public static Response XMLtoResponse(String s) throws JsonProcessingException {
        XmlMapper mapper = new XmlMapper();
        return mapper.readValue(s, Response.class);
    }
}
