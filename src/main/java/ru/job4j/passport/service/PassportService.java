package ru.job4j.passport.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.passport.model.Passport;
import ru.job4j.passport.repository.PassportRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PassportService {

    private final PassportRepository passportRepository;

    public boolean validate(Passport passport) {
        Passport rsl = passportRepository.findBySerial(passport.getSerial());
        return rsl == null;
    }

    public boolean create(Passport passport) {
        if (validate(passport)) {
            passportRepository.save(passport);
            return true;
        }
        return false;
    }

    public void update(int id, Passport oldPassport) {
        Passport newPassport = passportRepository.findById(id).get();
        newPassport.setNumber(oldPassport.getNumber());
        newPassport.setSerial(oldPassport.getSerial());
        newPassport.setName(oldPassport.getName());
        newPassport.setValidityDate(oldPassport.getValidityDate());
        passportRepository.save(newPassport);
    }

    public void delete(int id) {
        Passport passport = new Passport();
        passport.setId(id);
        passportRepository.delete(passport);
    }

    public List<Passport> findAll() {
        return passportRepository.findAll();
    }

    public Passport findBySerial(int serial) {
        return passportRepository.findBySerial(serial);
    }

    public List<Passport> findByNotValid() {
        return passportRepository.findAllByNotValid();
    }

    public List<Passport> findAllByReplaceable() {
        return passportRepository.findAllByReplaceable();
    }
}
