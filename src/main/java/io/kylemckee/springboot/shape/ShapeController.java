package io.kylemckee.springboot.shape;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.kylemckee.shapes.Shape;
import io.kylemckee.shapes.Square;
import io.kylemckee.shapes.Triangle;
import io.kylemckee.shapes.Diamond;
import io.kylemckee.shapes.Rectangle;

@RestController
public class ShapeController {
	
	@RequestMapping("/shapes")
	public List<Shape> getAllShapes() {
		return Arrays.asList(
					new Square("1", 6, "HEY"),
					new Rectangle("2", 5, 3, "HI"),
					new Diamond("3", 9, 4, "HELLO"),
					new Triangle("4", 9, 4, "HOLA")	
				);
	}
}
