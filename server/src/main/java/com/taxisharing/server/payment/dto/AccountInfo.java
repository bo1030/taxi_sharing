package com.taxisharing.server.payment.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class AccountInfo {
    private String bank_holder;

    public AccountInfo(String bank_holder) {
        this.bank_holder = bank_holder;
    }
}
