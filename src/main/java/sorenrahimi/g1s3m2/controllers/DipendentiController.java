package sorenrahimi.g1s3m2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sorenrahimi.g1s3m2.entities.Dipendente;
import sorenrahimi.g1s3m2.exceptions.BadRequestException;
import sorenrahimi.g1s3m2.payloads.dipendenti.NewDipendenteDTO;
import sorenrahimi.g1s3m2.payloads.dipendenti.NewDipendenteResponseDTO;
import sorenrahimi.g1s3m2.services.DipendentiService;

import java.io.IOException;

@RestController
@RequestMapping("/dipendenti")
public class DipendentiController {
    @Autowired
    private DipendentiService dipendentiService;

    @GetMapping
    public Page<Dipendente> getDipendenti(@RequestParam(defaultValue = "0") int page,
                                   @RequestParam(defaultValue = "10") int size,
                                   @RequestParam(defaultValue = "id") String sortBy) {
        return this.dipendentiService.getDipendenti(page, size, sortBy);
    }

    @GetMapping("/{dipendenteId}")
    public Dipendente findById(@PathVariable int dipendenteId){
        return this.dipendentiService.findById(dipendenteId);
    }

    @PutMapping("/{dipendenteId}")
    private Dipendente findUserByIdAndUpdate(@PathVariable int dipendenteId, @RequestBody Dipendente body){
        return this.dipendentiService.findByIdAndUpdate(dipendenteId, body);
    }

    @DeleteMapping("/{dipendenteId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void findByIdAndDelete(@PathVariable int dipendenteId){
        this.dipendentiService.findByIdAndDelete(dipendenteId);
    }
}


