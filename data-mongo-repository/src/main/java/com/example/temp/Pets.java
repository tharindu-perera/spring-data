package com.example.temp;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Pets {
    @Id
    public String _id;

    public String name;
    public String species;
    public int breed;

    // Constructors
    public Pets() {}

    public Pets(String _id, String name, String species, int breed) {
        this._id = _id;
        this.name = name;
        this.species = species;
        this.breed = breed;
    }

    // ObjectId needs to be converted to string
    public String get_id() { return _id; }
    public void set_id(String _id) { this._id = _id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSpecies() { return species; }
    public void setSpecies(String species) { this.species = species; }

    public int getBreed() { return breed; }
    public void setBreed(int breed) { this.breed = breed; }
}