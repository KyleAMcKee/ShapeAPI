package io.kylemckee.shapes;

import java.util.Arrays;
import java.util.UUID;

//import javax.persistence.Entity;
//import javax.persistence.Id;

//@Entity
public class Shape {
	
	//@Id
    protected String Id = UUID.randomUUID().toString();
    protected int rows = 6;
    protected int columns = 11;
    protected int labelRow = 4;
    protected String label = "HI";
    protected String type;
    protected char[][] model;

    public int getRows() { return rows; }
    public void setRows(int rows) { this.rows = rows; }

    public String getLabel() { return label; }
    public void setLabel(String label) { this.label = label; }
    
    public String getId() { return Id; }

	public int getColumns() { return columns; }
	public void setColumns(int columns) { this.columns = columns; }

	public int getLabelRow() { return labelRow; }
	public void setLabelRow(int labelRow) { this.labelRow = labelRow; }

	public char[][] getModel() { return model; }
	public void setModel(char[][] model) { this.model = model; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    protected void clearModel()
    {
        for (int i = 0; i < this.rows; i++)
        {
            Arrays.fill(model[i], ' ');
        }
    }

    public void printModel()
    {
        for (int i = 0; i < this.rows; i++)
        {
            for (int j = 0; j < this.columns; j++)
            {
                System.out.print(this.model[i][j]);
            }
            System.out.println();
        }
    }
}
