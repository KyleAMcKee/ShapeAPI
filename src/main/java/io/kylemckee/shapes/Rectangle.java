package io.kylemckee.shapes;

import java.lang.Math;

import javax.persistence.Entity;

@Entity
public class Rectangle extends Shape
{
    private static final double WIDTH_FACTOR = 1.618;
    
    public Rectangle() {
    	
    }

    public Rectangle (int rows, int labelRow, String label)
    {
        setType("rectangle");
        this.height = rows;
        this.labelRow = labelRow;
        this.label = label.toUpperCase();
        this.columns = (int) (Math.round(height * WIDTH_FACTOR) * 2) - 1;

        generateModel();
    }

    public void fillModel()
    {
        for (int i = 0; i < height; i++)
        {
            for (int j = 0; j < columns; j++)
            {
                model[i][j] = j % 2 == 0 ? 'X' : ' ';
            }
        }
    }

    public void addLabel()
    {
        int startIdx = 0;
        int letterIdx = 0;

        if (label.length() < this.columns / 2) {
            startIdx = (this.columns / 2 - label.length()) - 1;
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