package ru.aorlov.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.aorlov.model.Approof;

/**
 * Created by anton on 11.10.14.
 */

public interface ApproofRepository extends JpaRepository<Approof, Long> {


    @Query("SELECT a FROM Approof a WHERE a.approofName = ?1")
    public Approof findByName(String name);
}
