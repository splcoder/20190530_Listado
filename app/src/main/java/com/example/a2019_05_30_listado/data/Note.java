package com.example.a2019_05_30_listado.data;

import com.example.a2019_05_30_listado.helpers.DateHelper;
import com.example.a2019_05_30_listado.helpers.IdGenerator;

import java.io.Serializable;

public class Note implements Comparable<Note>, Serializable {
	private static final long serialVersionUID = 1L;

	//-------------------------------------------------------------
	private static IdGenerator idGenerator = new IdGenerator();
	public static long getLastId(){
		return idGenerator.getLastId();
	}
	public static void setLastId( long id ){	// <<< to be managed only by the NotesManager
		idGenerator.setLastId( id );
	}
	//-------------------------------------------------------------

	private long id;
	private long creationDate;
	private long modificationDate;
	private long forWhenDate;
	private String text;
	private Priority priority;
	/*public final int getElapsedYearsTillOpeningDate() {
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis( openingDate );
		return Calendar.getInstance().get( Calendar.YEAR ) - c.get( Calendar.YEAR );
	}*/
	public Note() {
		id = idGenerator.getNewId();
		this.creationDate = DateHelper.getTimeMilis();
		this.modificationDate = DateHelper.getTimeMilis();
	}
	public Note( String text, Priority priority ) {
		this();
		this.text = text;
		this.priority = priority;
	}
	public long getId() {
		return id;
	}
	public long getCreationDate() {
		return creationDate;
	}
	public long getModificationDate() {
		return modificationDate;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
		this.modificationDate = DateHelper.getTimeMilis();
	}
	public Priority getPriority() {
		return priority;
	}
	public void setPriority(Priority priority) {
		this.priority = priority;
		this.modificationDate = DateHelper.getTimeMilis();
	}
	@Override
	public Note clone() {
		return new Note( text, priority );
	}
	@Override
	public String toString() {
		return "Note [id=" + id + ", creationDate=" + DateHelper.getDate( creationDate, true ) + ", modificationDate=" + DateHelper.getDate( modificationDate, true )
				+ ", text=" + text + ", priority=" + priority + "]";
	}
	@Override
	public int compareTo( Note note ) {
		return (int)(creationDate - note.creationDate);		// UPS long to int !!!
	}
	@Override
	public boolean equals( Object obj ){
		if( this == obj )	return true;
		if( obj == null || getClass() != obj.getClass() )	return false;

		Note other = (Note) obj;
		if( text == null ){
			if( other.text != null )	return false;
		} else if( ! text.equals( other.text ) )
			return false;
		return true;
	}
}