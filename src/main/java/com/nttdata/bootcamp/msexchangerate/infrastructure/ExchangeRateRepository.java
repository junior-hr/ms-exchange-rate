package com.nttdata.bootcamp.msexchangerate.infrastructure;

import com.nttdata.bootcamp.msexchangerate.dto.ExchangeRatetDto;
import com.nttdata.bootcamp.msexchangerate.model.ExchangeRate;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Repository
public interface ExchangeRateRepository extends ReactiveMongoRepository<ExchangeRate, String> {
    @Query(value = "{'client.cellphone' : ?0 }")
    Flux<ExchangeRatetDto> findAllByCellphone(String cellphone);

    @Query(value = "{'currencyType.currencyType' : ?0 }")
    Mono<ExchangeRatetDto> findByCurrencyType(String currencyType);
}
