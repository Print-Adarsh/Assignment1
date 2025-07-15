package org.example.linkedlnsearchassignment.controller;

import lombok.Getter;
import lombok.Setter;
import org.example.linkedlnsearchassignment.dto.SearchResponse;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Setter
@Getter

@RestController
@RequestMapping("/api/alumni")
public class AlumniController {
    private final AlumniService svc;
    public AlumniController(AlumniService svc) { this.svc = svc; }

    @PostMapping("/search")
    public ResponseEntity<SearchResponse> search(@RequestBody SearchRequest req) {
        if (req.getUniversity() == null || req.getDesignation() == null) {
            return ResponseEntity.badRequest().body(new SearchResponse("error", null));
        }
        List<AlumniProfile> result = svc.searchAndSave(req.getUniversity(), req.getDesignation(), req.getPassoutYear());
        return ResponseEntity.ok(new SearchResponse("success", result));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<SearchResponse> handle(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new SearchResponse("failure: " + ex.getMessage(), null));
    }
}
