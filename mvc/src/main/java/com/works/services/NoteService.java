
package com.works.services;

import com.works.entities.Note;
import com.works.repositories.NoteRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class NoteService {
    
    
    final NoteRepository noteRepository;
    
    public Note save(Note note) {
        noteRepository.save(note);
        return note;
    }
    
    public List<Note> allNote() {
        return noteRepository.findAll();
    }
    
    public boolean noteDelete( Long nid ) {
        try {
            noteRepository.deleteById(nid);
            return true;
        } catch (Exception e) {
            return false;
        }
        
    }
    
    
}
