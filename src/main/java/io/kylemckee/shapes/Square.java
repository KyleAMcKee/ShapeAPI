package io.kylemckee.shapes;

public class Square extends Shape {
	
    public Square() {} ;

    public Square(int rows, int labelRow, String label) {
        setType("square");
        this.rows = rows;
        this.labelRow = labelRow;
        this.label = label.toUpperCase();
        this.columns = (rows * 2) - 1;

        generateModel();
    }

    public void fillModel()
    {
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < columns; j++)
            {
                model[i][j] = j % 2 == 0 ? 'X' : ' ';
            }
        }
    }

    public void initModel()
    {
        model = new char[this.rows][this.columns];
        this.clearModel();
    }

    public void addLabel()
    {
        int startIdx = 0;
        int letterIdx = 0;

        if (label.length() < this.rows) {
            startIdx = (this.rows - label.length()) - 1;
        }
        for (int i = startIdx; i < this.columns; i++)
        {
            if (letterIdx >= label.length())
            {
                break;
            }
            if (model[labelRow - 1][i] == 'X')
            {
                model[labelRow - 1][i] = label.charAt(letterIdx++);
            }
        }
    }

    public void generateModel() {
        initModel();
        fillModel();
        if (labelRow <= rows)
        {
            addLabel();
        }
    }
}