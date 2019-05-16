package io.kylemckee.shapes;


import java.util.Arrays;

import javax.persistence.Entity;

@Entity
public class Diamond extends Shape
{
    public Diamond() {
        
    }

    public Diamond(int rows, int labelRow, String label) {
        setType("diamond");
        this.height = rows;
        this.labelRow = labelRow;
        this.label = label.toUpperCase();
        this.columns = rows + 1;

        generateModel();
    }

    public void fillModel()
    {
        for (int i = 0; i <= this.height / 2; i++)
        {
            int k = 0;
            for (int j = (this.columns / 2) - i; k <= i; j += 2)
            {
                model[i][j] = 'X';
                k++;
            }
        }
        int j = (this.height / 2) - 1;
        for (int i = (this.height / 2) + 1; i < this.height; i++)
        {
            model[i] = Arrays.copyOf(model[j], model[j].length);
            j--;
        }
    }

    public void addLabel()
    {
        int startIdx = 0;
        int letterIdx = 0;
        int availableSpots = labelRow <= (height / 2) + 1 ? height / 2 + 1 : height - labelRow + 1;
        System.out.println(availableSpots); 

        while (model[labelRow - 1][startIdx] != 'X')
        {
            startIdx++;
        }
        if (availableSpots > label.length())
        {
            startIdx += availableSpots - label.length();
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