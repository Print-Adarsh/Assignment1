package org.example.linkedlnsearchassignment.repo;

import org.example.linkedlnsearchassignment.model.AlumniProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumniRepository extends JpaRepository<AlumniProfile, Long> {

}