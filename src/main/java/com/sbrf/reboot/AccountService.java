package com.sbrf.reboot;

import com.sbrf.reboot.repository.AccountRepository;
import lombok.NonNull;

import java.io.FileNotFoundException;
import java.util.Set;

public class AccountService {
    private AccountRepository repository_;

    public AccountService(AccountRepository repository) {
        this.repository_ = repository;
    }


    public boolean isClientHasContract(@NonNull long clientId, @NonNull long contractNumber) throws FileNotFoundException {
        Set<Long> repo_set = repository_.getAllAccountsByClientId(clientId);
        return repo_set.stream().anyMatch((cNum) ->  cNum == contractNumber);
    }


    public boolean isAccountAllowed(long accId) {
        return repository_.isAccountActiveByAccountId(accId);
    }
}
