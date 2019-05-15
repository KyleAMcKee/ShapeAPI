package io.kylemckee.springboot.shape;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.kylemckee.shapes.Shape;
import io.kylemckee.shapes.Square;

@RestController
public class ShapeController {
	
	@RequestMapping("/shapes")
	public List<Shape> getAllShapes() {
		return Arrays.asList(
					new Square("1", 6, "HEY"),
					new Square("2", 5, 3, "HI"),
					new Square("3", 9, 4, "HELLO")				
				);
	}
}
