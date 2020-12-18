package com.web.app.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@Service
public class InputStreamMapper {

    private final InputStream inputStream;

    @Autowired
    public InputStreamMapper(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public String mapInputStreamToString() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        StringBuilder result = new StringBuilder();

        String line;
        while ((line = reader.readLine()) != null) {
            result.append(line);
        }

        reader.close();

        return result.toString();
    }
}
