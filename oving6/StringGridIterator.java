package oving6;

import java.util.Iterator;
import oving6.StringGridImpl;

public class StringGridIterator implements Iterator<String>{
	boolean neste, rader;
	int row, col;
	StringGridImpl stringgrid;
	
	StringGridIterator(StringGridImpl grid, boolean rows){
		this.stringgrid = grid;
		this.row = 0;
		this.col = 0;
		this.neste = true;
		this.rader = rows;
	}
	
	@Override
	public boolean hasNext() {
		if(!this.neste){
			this.neste = true;
			return false;
		}
		
		if(this.rader){
			if(this.col < this.stringgrid.getColumnCount()){
				return true;
			}
			else if(this.row < this.stringgrid.getRowCount()){
				return true;
			}
		}
		else{
			if(this.row < this.stringgrid.getRowCount()){
				return true;
			}
			else if(this.col < this.stringgrid.getColumnCount()){
				return true;
			}
		}
		return false;
	}

	@Override
	public String next() {
        String element = stringgrid.getElement(row, col);

        if (this.rader) {
            if (this.col < this.stringgrid.getColumnCount()-1) {
                this.col++;
            }
            else if (this.row < this.stringgrid.getRowCount()-1) {
                this.col = 0;
                this.row++;
            }
            else {
                this.neste = false;
            }
        }
        else {
            if (this.row < this.stringgrid.getRowCount()-1) {
                this.row++;
            }
            else if (this.col < this.stringgrid.getColumnCount()-1) {
                this.row = 0;
                this.col++;
            }
            else {
                this.neste = false;
            }
        }

        return element;
    }

}
