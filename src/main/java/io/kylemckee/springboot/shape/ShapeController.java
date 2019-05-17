package io.kylemckee.springboot.shape;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.kylemckee.shapes.Config;
import io.kylemckee.shapes.Shape;

@RestController
public class ShapeController {
	
	@Autowired
	private ShapeService shapeService;
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping("/shapes")
	public List<Shape> getAllShapes() {
		return shapeService.getAllShapes();
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping("/shapes/{id}")
	public Optional<Shape> getShape(@PathVariable Long id) {
		return shapeService.getShape(id);
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(method=RequestMethod.POST, value="/shapes")
	public void addShape(@RequestBody Config config) {
		shapeService.addShape(config);
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(method=RequestMethod.PUT, value="/shapes/{id}")
	public void updateShape(@RequestBody Config config, @PathVariable Long id) {
		shapeService.updateShape(id, config);
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(method=RequestMethod.DELETE, value="/shapes/{id}")
	public void deleteShape(@PathVariable Long id) {
		shapeService.deleteShape(id);
	}
}
