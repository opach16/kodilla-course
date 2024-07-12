package com.kodilla.testing.shape;

import java.util.ArrayList;
import java.util.List;

public class ShapeCollector {

    List<Shape> shapes = new ArrayList<>();

    public int getNumberOfFigures() {
        return shapes.size();
    }

    public void addFigure(Shape shape) {
        shapes.add(shape);
    }

    public boolean removeFigure(Shape shape) {
        if (shapes.contains(shape)) {
            shapes.remove(shape);
            return true;
        }
        return false;
    }

    public Shape getFigure(int n) {
        if (shapes.size() > 0 && n < shapes.size()) {
            return shapes.get(n);
        }
        return null;
    }

    public String showFigures() {
        if (shapes.size() > 0) {
            String result = "";
            for (Shape shape : shapes) {
                result += shape.getShapeName();
                if (shape != shapes.getLast()) {
                    result += ", ";
                }
            }
            return result;
        }
        return null;
    }
}