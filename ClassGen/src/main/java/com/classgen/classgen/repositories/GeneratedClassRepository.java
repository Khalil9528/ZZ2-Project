package com.classgen.classgen.repositories;

import com.classgen.classgen.models.GeneratedClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GeneratedClassRepository extends JpaRepository<GeneratedClass, Long> {}

