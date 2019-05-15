package io.kylemckee.springboot.shape;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.kylemckee.shapes.Shape;

@RestController
public class ShapeController {
	
	@Autowired
	private ShapeService shapeService;
	
	@RequestMapping("/shapes")
	public List<Shape> getAllShapes() {
		return shapeService.getAllShapes();
	}
	
	@RequestMapping("/shapes/{id}")
	public Shape getShape(@PathVariable String id) {
		return shapeService.getShape(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/shapes")
	public void addShape(@RequestBody Shape shape) {
		shapeService.addShape(shape);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/shapes/{id}")
	public void updateShape(@RequestBody Shape shape, @PathVariable String id) {
		shapeService.updateShape(id, shape);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/shapes/{id}")
	public void deleteShape(@PathVariable String id) {
		shapeService.deleteShape(id);
	}
}
