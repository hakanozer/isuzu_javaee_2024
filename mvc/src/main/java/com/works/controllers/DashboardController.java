
package com.works.controllers;

import com.works.entities.Note;
import com.works.services.NoteService;
import jakarta.servlet.http.HttpServletRequest;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class DashboardController {
    
    final HttpServletRequest req;
    final NoteService noteService;
    
    @GetMapping("dashboard")
    public String dashboard(Model model) {
        boolean status = req.getSession().getAttribute("customer") == null;
        if (status) {
            return "redirect:/";
        }
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
