package io.kylemckee.springboot.shape;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import io.kylemckee.shapes.Config;
import io.kylemckee.shapes.Shape;
import io.kylemckee.shapes.ShapeFactory;


@Service
public class ShapeService {

	ShapeFactory shapeFactory = new ShapeFactory();
	
	Config squareConfig = new Config(8, 8, "hello");
	Config triangleConfig = new Config(10, 6, "hola");
	Config diamondConfig = new Config(3, 2);
	Config rectangleConfig = new Config(7, 4, "bonjour");
	List<Shape> shapes = new ArrayList<>(Arrays.asList(
			shapeFactory.makeShape("square", squareConfig),
			shapeFactory.makeShape("triangle", triangleConfig),
			shapeFactory.makeShape("diamond", diamondConfig),
			shapeFactory.makeShape("rectangle", rectangleConfig)
		));
	
	
	
	public List<Shape> getAllShapes() {
		return shapes;
	}
	
	public Shape getShape(String id) {
		return shapes.stream()
			.filter(s -> s.getId().equals(id))
			.findFirst()
			.get();
	}
	
	public void addShape(Config config) {
		String type = config.getType();
		Shape newShape = shapeFactory.makeShape(type, config);
		shapes.add(newShape);
	}
	
	public void updateShape(String id, Config config) {
		for(int i = 0; i < shapes.size(); i++) {
			Shape s = shapes.get(i);
			if (s.getId().equals(id)) {
				shapes.set(i, shapeFactory.makeShape(config.getType(), config));
			}
		}
	}
	
	//set(i, new shape)

	public void deleteShape(String id) {
		shapes.removeIf(s -> s.getId().equals(id));
	}
}
