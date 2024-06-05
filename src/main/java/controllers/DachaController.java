package controllers;

import com.example.dacha.model.Parcel;
import com.example.dacha.model.ParcelRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DachaController {

    private ParcelRepository parcelRepository;

    // Рекомендуемый вариант внедрения зависимости:
    // внедрение зависимости в класс через конструктор
    public DachaController(ParcelRepository parcelRepository) {
        this.parcelRepository = parcelRepository;
    }

    @GetMapping("/parcels/")
    public List<Parcel> list() {
        Iterable<Parcel> parcelIterable = parcelRepository.findAll();

        List<Parcel> parcels = new ArrayList<>();
        for (Parcel parcel : parcelIterable) {
            parcels.add(parcel);
        }
        return parcels;
    }

    @PostMapping("/parcels/")
    public void add(Parcel parcel) {
        Parcel newParcel = parcelRepository.save(parcel);
        //return newParcel.getId();
    }
/*
    @GetMapping("/books/{id}")
    public ResponseEntity<?> get(@PathVariable int id) {
        Optional<Parcel> optionalBook = parcelRepository.findById(id);

        if (!optionalBook.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        return new ResponseEntity<>(optionalBook.get(), HttpStatus.OK);
    }

 */
}