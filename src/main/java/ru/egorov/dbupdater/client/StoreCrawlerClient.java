package ru.egorov.dbupdater.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.egorov.dbupdater.config.FeignClientConfiguration;
import ru.egorov.dbupdater.dto.ProductResponse;
import ru.egorov.dbupdater.model.StoreType;

@FeignClient(name = "store-crawler", configuration = FeignClientConfiguration.class)
public interface StoreCrawlerClient {

    @GetMapping("api/products")
    ProductResponse getMany(@RequestParam(name = "store") StoreType store,
                            @RequestParam(name = "page") Integer page,
                            @RequestParam(name = "size") Integer size);
}

