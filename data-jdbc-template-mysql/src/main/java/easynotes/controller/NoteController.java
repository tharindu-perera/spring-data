package easynotes.controller;

import easynotes.model.Employee;
import easynotes.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by rajeevkumarsingh on 27/06/17.
 */
@RestController
@RequestMapping("/api")
public class NoteController {

    @Autowired
    NoteRepository noteRepository;

    @GetMapping("/notes")
    public List<Employee> getAllNotes() {
        return noteRepository.findAll();
    }

    @GetMapping("/notes/{id}")
    public ResponseEntity<Employee> getNoteById(@PathVariable(value = "id") Long noteId) {
        Employee note = noteRepository.getById(noteId);
        if(note == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(note);
    }

    @PostMapping("/notes")
    public Employee createNote(@Valid @RequestBody Employee note) {
          noteRepository.save(note);
          return note;
    }

//    @PutMapping("/notes/{id}")
//    public ResponseEntity<Note> updateNote(@PathVariable(value = "id") Long noteId,
//                                           @Valid @RequestBody Note noteDetails) {
//        Note note = noteRepository.findOne(noteId);
//        if(note == null) {
//            return ResponseEntity.notFound().build();
//        }
//        note.setTitle(noteDetails.getTitle());
//        note.setContent(noteDetails.getContent());
//
//        Note updatedNote = noteRepository.save(note);
//        return ResponseEntity.ok(updatedNote);
//    }
//
//    @DeleteMapping("/notes/{id}")
//    public ResponseEntity<Note> deleteNote(@PathVariable(value = "id") Long noteId) {
//        Note note = noteRepository.findOne(noteId);
//        if(note == null) {
//            return ResponseEntity.notFound().build();
//        }
//
//        noteRepository.delete(note);
//        return ResponseEntity.ok().build();
//    }
}
