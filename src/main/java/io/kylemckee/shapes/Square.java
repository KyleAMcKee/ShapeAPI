package io.kylemckee.shapes;

public class Square extends Shape {
	
    public Square(String id, int height, int label_row, String label)
    {
        super(id, height, label_row, label);
        initModel();
        generateModel();
        System.out.println(model[0]);
    }

    public Square(String id, int height, int label_row)
    {
        super(id, height, label_row);
        initModel();
        generateModel();
    }

    public Square(String id, int height, String label)
    {
        super(id, height, label);
        initModel();
        generateModel();
    }

    public Square(String id, int height)
    {
        super(id, height);
        initModel();
        generateModel();
    }

    private void generateModel()
    {
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < columns; j++)
            {
                model[i][j] = j % 2 == 0 ? 'X' : ' ';
            }
        }
    }

    private void initModel()
    {
        model = new char[this.rows][this.columns];
        this.clearModel();
    }
}