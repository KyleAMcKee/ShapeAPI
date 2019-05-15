package io.kylemckee.shapes;

public class Square extends Shape {
	
    public Square(String id, int height, int label_row, String label, String type)
    {
        super(id, height, label_row, label);
        initModel();
        generateModel();
    }

    public Square(String id, int height, int label_row, String type)
    {
        super(id, height, label_row, type);
        initModel();
        generateModel();
    }

    public Square(String id, int height, String label, String type)
    {
        super(id, height, label, type);
        initModel();
        generateModel();
    }

    public Square(String id, int height, String type)
    {
        super(id, height, type);
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