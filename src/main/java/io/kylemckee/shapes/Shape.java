package io.kylemckee.shapes;

import java.util.Arrays;

public class Shape {
	protected String id;
    protected int rows;
    protected int columns;
    protected int label_row;
    protected String label;
    protected char model[][];
	protected String type;
    
    public Shape () {
    	
    }
    
    public Shape(String id, int height, int label_row, String label, String type)
    {
    	this.id = id;
        this.rows = height;
        this.columns = (height * 2) - 1;
        this.label_row = label_row;
        this.label = label;
        this.type = type;
    }

    public char[][] getModel() {
		return model;
	}

	public void setModel(char[][] model) {
		this.model = model;
	}

	public Shape(String id, int height, String label, String type)
    {
        this(id, height, 4, label, type);
        this.columns = (height * 2) - 1;
    }
    
    
    public Shape(String id, int height, int label_row, String type)
    {
        this(id, height, label_row, "HI", type);
        this.columns = (height * 2) - 1;
    }
    
    public Shape(String id, int height, String type)
    {
        this(id, height, 4, "HI", type);
        this.columns = (height * 2) - 1;
    }

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getColumns() {
		return columns;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}

	public int getLabel_row() {
		return label_row;
	}

	public void setLabel_row(int label_row) {
		this.label_row = label_row;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
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
    
    protected void clearModel()
    {
        for (int i = 0; i < this.rows; i++)
        {
            Arrays.fill(model[i], ' ');
        }
    }
}
