package com.imse.team015.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  DataRepository extends JpaRepository<String, Long> {

}
