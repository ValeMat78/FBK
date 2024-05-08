package com.corsoaltaformazione.demorubrica.services; // Declares the package for the RubricaService class.

import java.util.ArrayList; // Imports the ArrayList class from the java.util package.
import java.util.List; // Imports the List interface from the java.util package.
import java.util.StringJoiner; // Imports the StringJoiner class from the java.util package.

import com.corsoaltaformazione.demorubrica.models.Tag; // Imports the Tag class from the models package.
import org.springframework.beans.factory.annotation.Autowired; // Imports the Autowired annotation from the Spring framework.
import org.springframework.stereotype.Service; // Imports the Service annotation from the Spring framework.

import com.corsoaltaformazione.demorubrica.models.Persona; // Imports the Persona class from the models package.
import com.corsoaltaformazione.demorubrica.repository.Db; // Imports the Db class from the repository package.

@Service // Indicates that the RubricaService class is a service component.

public class RubricaService { // Declares the RubricaService class.

    @Autowired // Marks the db field for automatic dependency injection.
    private Db db; // Declares a private field db of type Db.

    public void addPersona(Persona persona){ // Declares a method to add a person to the address book.
        db.getDb().put(persona.getEmail(), persona); // Adds the person to the database.
    }

    public void addTag(String email,Persona persona, List<Tag> tags){ // Declares a method to add tags to a person.
        if(persona.getTags() == null){ // Checks if the person has no tags.
            persona.setTags(new ArrayList<>()); // Creates a new list for tags if none exists.
            persona.getTags().addAll(tags); // Adds the new tags to the person.
        }
        else { // If the person has existing tags.
            persona.getTags().addAll(tags); // Adds the new tags to the person.
        }
        db.getDb().put(email, persona); // Updates the person in the database.
    }

    public Persona getPersona(String email){ // Declares a method to get a person by email.
        return db.getDb().get(email); // Retrieves the person from the database by email.
    }

    public void deletePersona(String email){ // Declares a method to delete a person by email.
        db.getDb().remove(email); // Removes the person from the database.
    }

    public List<Persona> findAll(){ // Declares a method to find all persons in the address book.
        return db.getDb().values().stream().toList(); // Returns a list of all persons in the database.
    }

}