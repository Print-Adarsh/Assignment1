package org.example.linkedlnsearchassignment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.linkedlnsearchassignment.model.AlumniProfile;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchResponse {
    private String status;
    private List<AlumniProfile> data;
}
