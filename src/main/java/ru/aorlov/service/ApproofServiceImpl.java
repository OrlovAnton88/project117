package ru.aorlov.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.aorlov.model.Approof;
import ru.aorlov.repository.ApproofRepository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by anton on 11.10.14.
 */
@Service
@Transactional
public class ApproofServiceImpl implements ApproofService {

    private final static Logger LOGGER = LoggerFactory
            .getLogger(ApproofServiceImpl.class);

    @Resource
    ApproofRepository approofRepository;

    @Override
    public Approof create(Approof approof) {

        Approof fromDb = approofRepository.findByName(approof.getApproofName());

        if (fromDb == null) {

            LOGGER.debug("Creating a new approof with information: " + approof);
            return approofRepository.save(approof);
        }

        LOGGER.debug("Such approof is already exists " + fromDb);

        return fromDb;
    }

    @Override
    public List<Approof> findAll() {
        return approofRepository.findAll();
    }


    @Override
    public Approof findByName(String name) {
        return approofRepository.findByName(name);

    }
}
