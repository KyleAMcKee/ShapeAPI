package io.kylemckee.springboot.shape;

import org.springframework.data.repository.CrudRepository;

import io.kylemckee.shapes.Shape;

public interface ShapeRepository extends CrudRepository<Shape, Long> {

}
