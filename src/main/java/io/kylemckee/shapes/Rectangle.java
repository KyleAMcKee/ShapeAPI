package io.kylemckee.shapes;

import java.lang.Math;

public class Rectangle extends Shape
{
    public int width;
    private static final double WIDTH_FACTOR = 1.618;

    public Rectangle (String id, int height, int label_row, String label)
    {
        super(id, height, label_row, label);
        this.columns = (int) (Math.round(height * WIDTH_FACTOR) * 2) - 1;
        model = new char[this.rows][this.columns];
        this.clearModel();
        generateModel();
    }

    public void generateModel()
    {
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < columns; j++)
            {
                model[i][j] = j % 2 == 0 ? 'X' : ' ';
            }
        }
    }
}