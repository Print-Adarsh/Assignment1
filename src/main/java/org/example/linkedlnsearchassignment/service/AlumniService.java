package org.example.linkedlnsearchassignment.service;

import lombok.*;
import org.example.linkedlnsearchassignment.model.AlumniProfile;
import org.example.linkedlnsearchassignment.repo.AlumniRepository;
import org.springframework.beans.factory.annotation.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.*;




@Service
public class AlumniService {
    @Value("${phantombuster.api.key}") private String apiKey;
    @Value("${phantombuster.agent.id}") private String agentId;
    private final AlumniRepository repo;
    private final RestTemplate rest = new RestTemplate();

    public AlumniService(AlumniRepository repo) { this.repo = repo; }

    public List<AlumniProfile> searchAndSave(String university, String designation, Integer passoutYear) {
        var url = "https://api.phantombuster.com/agent/" + agentId + "/launch";
        var body = Map.of(
                "sessionCookie", apiKey,
                "argument", Map.of("university", university, "designation", designation, "passoutYear", passoutYear)
        );
        var resp = rest.postForEntity(url, body, PhantomResponse.class);
        if (resp.getStatusCode() != HttpStatus.OK || resp.getBody() == null)
            throw new RuntimeException("PhantomBuster error");
        return resp.getBody().data().stream()
                .map(dto -> repo.save(new AlumniProfile(null, dto.name(), dto.currentRole(),
                        dto.university(), dto.location(), dto.linkedinHeadline(), dto.passoutYear())))
                .collect(Collectors.toList());
    }
}
