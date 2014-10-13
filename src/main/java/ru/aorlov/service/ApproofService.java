package ru.aorlov.service;

import org.springframework.stereotype.Service;
import ru.aorlov.model.Approof;

import java.util.List;

/**
 * Created by anton on 11.10.14.
 */
@Service
public interface ApproofService {

    public Approof create(Approof userApproof);

    public List<Approof> findAll();

    public  Approof findByName(String name);

}
