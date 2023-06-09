package ru.egorov.dbupdater.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.egorov.dbupdater.client.StoreCrawlerClient;
import ru.egorov.dbupdater.dto.ProductDto;
import ru.egorov.dbupdater.mapper.ItemMapper;
import ru.egorov.dbupdater.mapper.OfferMapper;
import ru.egorov.dbupdater.model.Item;
import ru.egorov.dbupdater.model.Offer;
import ru.egorov.dbupdater.model.StoreType;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DbUpdater {
    private final ItemService itemService;
    private final StoreCrawlerClient crawlerClient;
    private final ItemMapper itemMapper;
    private final OfferMapper offerMapper;
    private final List<StoreType> stores = List.of(StoreType.footbox, StoreType.sneakerhead);

    @Scheduled(cron = "0 0 6 * * ?")
    public void update() {
        List<Item> items = new ArrayList<>();

        stores.stream()
                .flatMap(store -> crawlerClient.getMany(store, Pageable.ofSize(Integer.MAX_VALUE))
                        .getContent()
                        .stream())
                .forEach(productDto -> addItem(items, productDto));

        itemService.updateAll(items);
    }

    private void addItem(List<Item> items, ProductDto productDto) {
        Item item = prepareItem(items, productDto);
        Offer offer = offerMapper.toEntity(productDto);

        offer.setItem(item);
        item.getOffers()
                .add(offer);

        items.add(item);
    }

    private Item prepareItem(List<Item> items, ProductDto productDto) {
        return items.stream()
                .filter(item -> item.getSku()
                        .equals(productDto.getSku()))
                .findFirst()
                .orElse(itemMapper
                        .toEntity(productDto));
    }
}
