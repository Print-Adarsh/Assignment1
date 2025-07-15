package org.example.linkedlnsearchassignment.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Entity@AllArgsConstructor@Data@NoArgsConstructor
@Getter
@Setter
public class AlumniProfile {
    @Id
    @GeneratedValue Long id;
    String name, currentRole, university, location, linkedinHeadline;
    Integer passoutYear;
}
