package com.example.temp;


import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
//import javax.websocket.server.PathParam;
import java.util.List;
import java.util.UUID;

@RestController
//@RequestMapping("/pets")
public class PetsController {
    @Autowired
    private PetsRepository repository;
    @Autowired
    private MyRepo myRepo;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Pets> getAllPets() {
        return (List<Pets>) repository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Pets getPetById(@PathVariable("id") ObjectId id) {
        return repository.findBy_id(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public void modifyPetById(@PathParam("id") String id, @Valid @RequestBody Pets pets) {
        pets.set_id(id);
        repository.save(pets);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Pets createPet(  @RequestBody Pets pets) {
//        pets.set_id(UUID.randomUUID());
        repository.save(pets);
        return pets;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deletePet(@PathVariable ObjectId id) {
        repository.delete(repository.findBy_id(id));
    }

    @RequestMapping("/custom/")
    public Pets custom(@PathParam("name")  String name){
        return myRepo.mycustom2(name);
    }

    @RequestMapping("/custom2/")
    public Pets custom2(@PathParam("name")  String name){
        return repository.mycustom(name);
    }
}