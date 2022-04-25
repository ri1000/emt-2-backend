package com.emt.lab2.service.impl;

import com.emt.lab2.model.Country;
import com.emt.lab2.repository.CountryRepository;
import com.emt.lab2.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> findAll() {
        return this.countryRepository.findAll();
    }

    @Override
    public Optional<Country> findById(Long id) {
        return this.countryRepository.findById(id);
    }

    @Override
    public Optional<Country> save(String name, String continent) {
        Country country = new Country();
        country.setName(name);
        country.setContinent(continent);
        this.countryRepository.save(country);
        return Optional.of(country);
    }

    @Override
    public Optional<Country> edit(Long id, String name, String continent) {
        Country country = this.findById(id).orElseThrow(() -> new RuntimeException("Country not found -country service edit()"));
        country.setContinent(continent);
        country.setName(name);
        this.countryRepository.save(country);
        return Optional.of(country);
    }

    @Override
    public void deleteById(Long id) {
        this.countryRepository.deleteById(id);
    }

    @Override
    public Long findCountryIdByName(String name) {
        return this.countryRepository.findCountryIdByName(name);
    }
}
