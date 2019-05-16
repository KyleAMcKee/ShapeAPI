package io.kylemckee.springboot.shape;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.kylemckee.shapes.Config;
import io.kylemckee.shapes.Shape;
import io.kylemckee.shapes.ShapeFactory;


@Service
public class ShapeService {
	
	@Autowired
	private ShapeRepository shapeRepository;

	ShapeFactory shapeFactory = new ShapeFactory();
	
	public List<Shape> getAllShapes() {
		List<Shape> shapes = new ArrayList<>();
		shapeRepository.findAll()
			.forEach(shapes::add);
		return shapes;
	}
	
	public Optional<Shape> getShape(long id) {
		return shapeRepository.findById(id);
	}
	
	public void addShape(Config config) {
		String type = config.getType();
		Shape newShape = shapeFactory.makeShape(type, config);
		shapeRepository.save(newShape);
	}
	
	public void updateShape(long id, Config config) {
		String type = config.getType();
		Shape newShape = shapeFactory.makeShape(type, config);
		newShape.setId(id);
		shapeRepository.save(newShape);
	}
	
	public void deleteShape(long id) {
		shapeRepository.deleteById(id);
	}
}
