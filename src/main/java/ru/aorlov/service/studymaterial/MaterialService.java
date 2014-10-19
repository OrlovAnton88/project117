package ru.aorlov.service.studymaterial;

import ru.aorlov.dto.MaterialDTO;
import ru.aorlov.model.studymaterial.Material;

import java.util.List;

/**
 * Created by anton on 18.10.14.
 */

public interface MaterialService {

    public Material create(MaterialDTO material);

    public Material update(MaterialDTO material) throws MaterialNotFoundException;

    public Material delete(Long materialId) throws MaterialNotFoundException;

    public List<Material> findAll();

    public Material find(String name);

    public Material find(Long id);
}
