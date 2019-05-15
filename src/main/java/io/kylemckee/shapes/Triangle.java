package io.kylemckee.shapes;

import java.util.Arrays;

public class Triangle extends Shape
{
    public Triangle(String id, int height, int label_row, String label)
    {
        super(id, height, label_row, label);
        model = new char[this.rows][this.columns];
        this.clearModel();
        generateModel();
    }

    public void generateModel()
    {
        for (int i = 0; i < this.rows; i++)
        {
            int k = 0;
            for (int j = (this.columns / 2) - i; k <= i; j += 2)
            {
                model[i][j] = 'X';
                k++;
            }
        }
    }
}