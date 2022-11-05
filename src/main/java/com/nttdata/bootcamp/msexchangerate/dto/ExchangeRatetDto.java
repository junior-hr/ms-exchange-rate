package com.nttdata.bootcamp.msexchangerate.dto;

import com.nttdata.bootcamp.msexchangerate.model.CurrencyType;
import com.nttdata.bootcamp.msexchangerate.model.ExchangeRate;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.annotation.Id;
import reactor.core.publisher.Mono;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Slf4j
public class ExchangeRatetDto {
    @Id
    private String idExchangeRate;
    private Double exchange;
    private String currency;
    private CurrencyType currencyType;

    public Mono<ExchangeRate> MapperToExchangeRate() {
        log.info("ini MapperToExchangeRate-------: ");


        CurrencyType currencyType = CurrencyType.builder()
                .currencyType(this.getCurrency())
                .build();

        ExchangeRate exchangeRate = ExchangeRate.builder()
                .idExchangeRate(this.getIdExchangeRate())
                .currencyType(currencyType)
                .exchange(this.getExchange())
                .build();
        log.info("fn MapperToExchangeRate-------: ");
        return Mono.just(exchangeRate);
    }
}