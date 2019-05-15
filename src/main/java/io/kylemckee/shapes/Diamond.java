package io.kylemckee.shapes;


import java.util.Arrays;

public class Diamond extends Shape
{
    public Diamond(String id, int height, int label_row, String label, String type)
    {
        super(id, height, label_row, label, type);
        model = new char[this.rows][this.columns];
        this.clearModel();
        generateModel();
    }

    public void generateModel()
    {
        for (int i = 0; i <= this.rows / 2; i++)
        {
            int k = 0;
            for (int j = (this.columns / 2) - i; k <= i; j += 2)
            {
                model[i][j] = 'X';
                k++;
            }
        }
        int j = (this.rows / 2) - 1;
        for (int i = (this.rows / 2) + 1; i < this.rows; i++)
        {
            model[i] = Arrays.copyOf(model[j], model[j].length);
            j--;
        }
    }
}