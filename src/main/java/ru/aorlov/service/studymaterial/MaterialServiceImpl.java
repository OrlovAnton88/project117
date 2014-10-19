package ru.aorlov.service.studymaterial;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.aorlov.dto.MaterialDTO;
import ru.aorlov.model.studymaterial.Material;
import ru.aorlov.repository.studymaterial.MaterialRepository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by anton on 18.10.14.
 */
@Service
public class MaterialServiceImpl implements MaterialService {

    private final static Logger LOGGER = LoggerFactory
            .getLogger(MaterialServiceImpl.class);
    protected static final int NUMBER_OF_MATERIALS_PER_PAGE = 10;

    @Resource
    MaterialRepository materialRepository;

    @Override
    public Material create(MaterialDTO created) {

        LOGGER.debug("Creating material " + created.toString());

        Material material = Material.getBuilder(created.getName(),
                created.getCategory(), created.getHtmlText()).build();

        return materialRepository.save(material);
    }


    @Transactional(rollbackFor = MaterialNotFoundException.class)
    @Override
    public Material update(MaterialDTO updated) throws MaterialNotFoundException {
        LOGGER.debug("Updating material " + updated.toString());

        Material material = materialRepository.findOne(updated.getId());
        if (material == null) {
            LOGGER.debug("No material found with id: " + updated.getId());
            throw new MaterialNotFoundException();
        }

        material.update(updated.getName(), updated.getCategory(), updated.getHtmlText());

        return material;

    }

    @Transactional(rollbackFor = MaterialNotFoundException.class)
    @Override
    public Material delete(Long materialId) throws MaterialNotFoundException {
        LOGGER.debug("Deleting material with id: " + materialId);

        Material deleted = materialRepository.findOne(materialId);

        if (deleted == null) {
            LOGGER.debug("No material found with id: " + materialId);
            throw new MaterialNotFoundException();
        }

        materialRepository.delete(deleted);
        return deleted;
    }

    @Override
    public List<Material> findAll() {
        return materialRepository.findAll();
    }

    @Override
    public Material find(String name) {
        throw new UnsupportedOperationException("not implemented yet");
    }

    @Override
    public Material find(Long id) {
        return materialRepository.findOne(id);
    }
}
