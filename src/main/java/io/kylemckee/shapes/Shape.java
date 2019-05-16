package io.kylemckee.shapes;

import java.util.Arrays;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public abstract class Shape {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    protected long Id;
    protected int height = 6;
    protected int columns = 11;
    protected int labelRow = 4;
    protected String label = "HI";
    protected String type;
    @Column(length = 8192)
    protected char[][] model;

    public int getHeight() { return height; }
    public void setHeight(int height) { this.height = height; }

    public String getLabel() { return label; }
    public void setLabel(String label) { this.label = label; }
    
    public long getId() { return Id; }
    public void setId(long id) { this.Id = id; }

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
        for (int i = 0; i < this.height; i++)
        {
            Arrays.fill(model[i], ' ');
        }
    }

    public void printModel()
    {
        for (int i = 0; i < this.height; i++)
        {
            for (int j = 0; j < this.columns; j++)
            {
                System.out.print(this.model[i][j]);
            }
            System.out.println();
        }
    }
}
