package ru.egorov.dbupdater.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.egorov.dbupdater.model.Item;
import ru.egorov.dbupdater.repository.ItemRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ItemService {
    private final ItemRepository itemRepository;
    private final OfferService offerService;

    @Transactional
    public List<Item> updateAll(List<Item> items) {
        offerService.deleteAll();
        itemRepository.deleteAll();

        itemRepository.flush();

        return itemRepository.saveAll(items);
    }
}
