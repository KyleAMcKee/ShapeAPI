package io.kylemckee.shapes;

public class Config {
    private int rows = 6;
    private String label = "HI";
    private int labelRow = 4;
    private String type = "square";

    public Config() {

    }

    public Config(int rows) {
        this.rows = rows;
    }

    public Config(String label) {
        this.label = label;
    }

    public Config(int rows, int labelRow) {
        this.rows = rows;
        this.labelRow = labelRow;
    }

    public Config(int rows, String label) {
        this.rows = rows;
        this.label = label;
    }

    public Config(int rows, int labelRow, String label) {
        this.rows = rows;
        this.labelRow = labelRow;
        this.label = label;
    }

    public int getRows() { return rows; }
    public void setRows(int rows) { this.rows = rows; }

    public String getLabel() { return label; }
    public void setLabel(String label) { this.label = label; }

    public int getLabelRow() { return labelRow; }
    public void setLabelRow(int labelRow) { this.labelRow = labelRow; }
    
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

}
