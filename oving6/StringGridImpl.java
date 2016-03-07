package oving6;

import oving6.StringGrid;

public class StringGridImpl implements StringGrid {
	
	String[][] griden;
	int rows, columns;
	StringGridImpl(int rows, int columnCount){
		griden = new String[rows][columnCount];
		this.rows = rows;
		this.columns = columnCount;
	}

	@Override
	public int getRowCount() {
		return this.rows;
	}

	@Override
	public int getColumnCount() {
		return this.columns;
	}

	@Override
	public String getElement(int row, int column) {
		return griden[row][column];
	}

	@Override
	public void setElement(int row, int column, String element) {
		this.griden[row][column] = element;
	}

}
