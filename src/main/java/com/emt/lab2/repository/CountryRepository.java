package com.emt.lab2.repository;

import com.emt.lab2.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country,Long> {
    Long findCountryIdByName(String name);
}
