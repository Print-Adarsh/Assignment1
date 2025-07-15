package org.example.linkedlnsearchassignment.service;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public record PhantomResponse(List<PhantomAlumni> data) {
    public record PhantomAlumni(String name, String currentRole, String university,
                                String location, String linkedinHeadline, Integer passoutYear) {}
}
