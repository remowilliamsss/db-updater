package ru.egorov.dbupdater.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.egorov.dbupdater.config.FeignClientConfiguration;
import ru.egorov.dbupdater.dto.ProductDto;
import ru.egorov.dbupdater.model.StoreType;

@FeignClient(name = "store-crawler", configuration = FeignClientConfiguration.class)
public interface StoreCrawlerClient {

    @GetMapping("api/products")
    Page<ProductDto> getMany(@RequestParam(name = "store") StoreType store, Pageable pageable);
}

