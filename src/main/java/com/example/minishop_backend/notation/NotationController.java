package com.example.minishop_backend.notation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping
@RequiredArgsConstructor
public class NotationController {
    private final NotationService notationService;
    @PostMapping("rate")
    public void addNotation(@RequestBody Notation notation) {
        notationService.addNotation(notation);
    }
    @PutMapping("update/{notationId}")
    public void updateNotation(
            @PathVariable("notationId") Long id,
            @RequestParam(required = false) Integer etoiles
    ) {
        if (etoiles == null) {
            etoiles = 0;
        }
        notationService.updateNotation(id, etoiles);
    }
}
