package io.kylemckee.springboot.shape;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import io.kylemckee.shapes.Diamond;
import io.kylemckee.shapes.Rectangle;
import io.kylemckee.shapes.Shape;
import io.kylemckee.shapes.Square;
import io.kylemckee.shapes.Triangle;

@Service
public class ShapeService {
	List<Shape> shapes = new ArrayList<>(Arrays.asList(
			new Square("1", 6, "HEY", "Square"),
			new Rectangle("2", 5, 3, "HI", "Rectangle"),
			new Diamond("3", 9, 4, "HELLO", "Diamond"),
			new Triangle("4", 9, 4, "HOLA", "Triangle")	
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
	
	public void addShape(Shape shape) {
		
		String id = shape.getId();
		int rows = shape.getRows();
		int label_row = shape.getLabel_row();
		String label = shape.getLabel();
		String type = shape.getType();
		
		switch (type) {
			case "square": 		shapes.add(new Square(id, rows, label_row, label, type));
								break;
			case "rectangle": 	shapes.add(new Rectangle(id, rows, label_row, label, type));
								break;
			case "diamond": 	shapes.add(new Diamond(id, rows, label_row, label, type));
								break;
			case "triangle": 	shapes.add(new Triangle(id, rows, label_row, label, type));
								break;
			default:			shapes.add(new Square(id, 4, 3, "NONE", "square"));
								break;
		}
	}
	//TODO Combine logic
	public void updateShape(String id, Shape shape) {
		for(int i = 0; i < shapes.size(); i++) {
			Shape s = shapes.get(i);
			if (s.getId().equals(id)) {
				int rows = shape.getRows();
				int label_row = shape.getLabel_row();
				String label = shape.getLabel();
				String type = shape.getType();
				switch (type) {
					case "square": 		shapes.set(i, new Square(id, rows, label_row, label, type));
										break;
					case "rectangle": 	shapes.set(i, new Rectangle(id, rows, label_row, label, type));
										break;
					case "diamond": 	shapes.set(i, new Diamond(id, rows, label_row, label, type));
										break;
					case "triangle": 	shapes.set(i, new Triangle(id, rows, label_row, label, type));
										break;
					default:			shapes.set(i, new Square(id, 4, 3, "NONE", "square"));
										break;
				}
			}
		}
	}

	public void deleteShape(String id) {
		shapes.removeIf(s -> s.getId().equals(id));
	}
}
