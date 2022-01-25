package com.sbrf.reboot.repository.impl;

import com.sbrf.reboot.repository.AccountRepository;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class FileAccountRepository implements AccountRepository {
    private String _filePath;
    private final String CLIENT_ID_STRING = new String("clientId");

    public FileAccountRepository(String filePath) {
        _filePath = filePath;
    }

    @Override
    public Set<Long> getAllAccountsByClientId(long clientId) throws FileNotFoundException {

        File file = new File(_filePath);
        if (! file.exists()) {
            throw new FileNotFoundException(String.format("File: %s does not exists", _filePath));
        }

        InputStream inputStream = new FileInputStream(file);
        Reader reader = null;
        try {
            reader = new InputStreamReader(inputStream, "UTF-8");
        } catch (UnsupportedEncodingException ueex) {
            ueex.printStackTrace();
        }

        assert reader != null;

        BufferedReader bufferedReader = new BufferedReader(reader);

        String line = null;
        try {
            line = bufferedReader.readLine();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        Set<Long> toReturn = new HashSet<>();

        while (line != null) {
            if (line.contains(CLIENT_ID_STRING)) {
                if (line.contains(Long.toString(clientId))) {
                    String numberLine = null;
                    try {
                        numberLine = bufferedReader.readLine();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }

                    numberLine = numberLine.replaceAll("[^0-9]", "");
                    toReturn.add(Long.parseLong(numberLine));
                }
            }


            try {
                line = bufferedReader.readLine();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }

        return toReturn;
    }

    @Override
    public boolean isAccountActiveByAccountId(long accId) {
        return false;
    }
}
