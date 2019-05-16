package io.kylemckee.shapes;

import javax.persistence.Entity;

@Entity
public class Triangle extends Shape
{
    public Triangle() {
        
    }

    public Triangle(int rows, int labelRow, String label) {
        setType("triangle");
        this.height = rows;
        this.labelRow = labelRow;
        this.label = label.toUpperCase();
        this.columns = (height * 2) - 1;

        generateModel();
    }

    public void fillModel()
    {
        for (int i = 0; i < this.height; i++)
        {
            int k = 0;
            for (int j = (this.columns / 2) - i; k <= i; j += 2)
            {
                model[i][j] = 'X';
                k++;
            }
        }
    }

    public void addLabel()
    {
        int startIdx = 0;
        int letterIdx = 0;

        while (model[labelRow - 1][startIdx] != 'X')
        {
            startIdx++;
        }
        if (labelRow > label.length())
        {
            startIdx += labelRow - label.length();
        }
        if (startIdx > 0) 
        {
            startIdx--;
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

    public void initModel()
    {
        model = new char[this.height][this.columns];
        this.clearModel();
    }

    public void generateModel() {
        initModel();
        fillModel();
        if (labelRow <= height)
        {
            addLabel();
        }
    }
}