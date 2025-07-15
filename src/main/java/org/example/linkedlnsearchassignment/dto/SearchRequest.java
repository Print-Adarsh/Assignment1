package org.example.linkedlnsearchassignment.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class SearchRequest {
    private String university, designation;
    private Integer passoutYear;
}
