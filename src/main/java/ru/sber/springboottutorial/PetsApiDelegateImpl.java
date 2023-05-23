package ru.sber.springboottutorial;

import org.openapitools.api.PetsApiDelegate;
import org.openapitools.model.Pet;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Component
public class PetsApiDelegateImpl implements PetsApiDelegate {
    @Override
    public ResponseEntity<List<Pet>> listPets(Integer limit) {
        Pet pet1 = new Pet(1L, "PetName1");
        Pet pet2 = new Pet(2L, "PetName2");
        List<Pet> pets = new ArrayList<>();
        pets.add(pet1); pets.add(pet2);

        return ResponseEntity.ok(pets);
    }
}
