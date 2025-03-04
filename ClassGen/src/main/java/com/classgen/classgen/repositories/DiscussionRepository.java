package com.classgen.classgen.repositories;

import com.classgen.classgen.models.Discussion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscussionRepository
        extends JpaRepository<Discussion, Long> {}
