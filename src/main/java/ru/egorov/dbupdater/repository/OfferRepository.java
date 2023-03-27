package ru.egorov.dbupdater.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.egorov.dbupdater.model.Offer;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Integer> {
}
