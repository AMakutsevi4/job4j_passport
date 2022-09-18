package ru.job4j.passport.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.job4j.passport.model.Passport;
import ru.job4j.passport.service.PassportService;

import java.util.List;

@RestController
@RequestMapping("/passport")
public class PassportController {

    private final PassportService passportService;

    public PassportController(PassportService passportService) {
        this.passportService = passportService;
    }

    @PostMapping("/save")
    public ResponseEntity<String> savePassport(@RequestBody Passport passport) {
        if (passportService.create(passport)) {
            return ResponseEntity.ok("Паспорт усешно добавлен");
        }
        return ResponseEntity.badRequest().body("Паспорт с серией: " + passport.getSerial() + " существует");
    }

    @GetMapping("/findAll")
    public List<Passport> findAllPassport() {
        return passportService.findAll();
    }

    @GetMapping("/findByNumber/{serial}")
    public Passport findPassportByNumber(@PathVariable int serial) {
        return passportService.findBySerial(serial);
    }

    @PutMapping("/update/{id}")
    public void updatePassport(@PathVariable int id, @RequestBody Passport passport) {
        passportService.update(id, passport);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePassport(@PathVariable int id) {
        passportService.delete(id);
    }

    @GetMapping("/unavaliabe")
    public List<Passport> findByNotValid() {
        return passportService.findByNotValid();
    }

    @GetMapping("/find-replaceable")
    public List<Passport> findAllByReplaceable() {
        return passportService.findAllByReplaceable();
    }
}
