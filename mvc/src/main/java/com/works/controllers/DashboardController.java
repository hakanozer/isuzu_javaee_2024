
package com.works.controllers;

import com.works.entities.Note;
import com.works.services.NoteService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class DashboardController {
    
    final NoteService noteService;
    
    @GetMapping("dashboard")
    public String dashboard(Model model) {
        
        List<Note> notes = noteService.allNote();
        model.addAttribute("notes", notes);
        return "dashboard";
    }
    
    
    @PostMapping("noteAdd")
    public String noteAdd( Note note ) {
        noteService.save(note);
        return "redirect:/dashboard";
    }
    
    
    
}
