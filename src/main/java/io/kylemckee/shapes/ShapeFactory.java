package io.kylemckee.shapes;

import io.kylemckee.shapes.Square;
import io.kylemckee.shapes.Triangle;
import io.kylemckee.shapes.Diamond;
import io.kylemckee.shapes.Rectangle;
import io.kylemckee.shapes.Config;

public class ShapeFactory {
    public Shape makeShape(String type, Config config) {

        type = type.toLowerCase();
        int rows = config.getRows();
        int labelRow = config.getLabelRow();
        String label = config.getLabel();

        if (type.equals("square")) {
            return new Square(rows, labelRow, label);
        }
        if (type.equals("diamond")) {
            return new Diamond(rows, labelRow, label);
        }

        if (type.equals("triangle")) {
            return new Triangle(rows, labelRow, label);
        }

        if (type.equals("rectangle")) {
            return new Rectangle(rows, labelRow, label);
        }

        return new Square(10, 5, "default");
    }
}
