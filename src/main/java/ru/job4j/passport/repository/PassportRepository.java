package ru.job4j.passport.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.job4j.passport.model.Passport;

import java.util.List;

public interface PassportRepository extends JpaRepository<Passport, Integer> {

    Passport findBySerial(int serial);

    @Query(value = "select distinct p from Passport p where p.validityDate < current_date")
    List<Passport> findAllByNotValid();

    @Query(value = "select * from passport p where p.validity_date between current_date"
            + " and date(current_date + interval '3 month')", nativeQuery = true)
    List<Passport> findAllByReplaceable();

    }
