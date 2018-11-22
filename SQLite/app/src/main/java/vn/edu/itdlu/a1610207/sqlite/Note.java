package vn.edu.itdlu.a1610207.sqlite;

import java.io.Serializable;

public class Note implements Serializable {

    int nodeID;
    String noteTitle;
    String noteContent;

    public Note() {

    }

    public Note(String noteTitle, String noteContent) {
        this.noteTitle = noteTitle;
        this.noteContent = noteContent;
    }

    public Note(int noteID, String noteTitle, String noteContent) {
        this.nodeID = noteID;
        this.noteTitle = noteTitle;
        this.noteContent = noteContent;
    }

    public int getNodeID() {
        return nodeID;
    }

    public void setNodeID(int nodeID) {
        this.nodeID = nodeID;
    }

    public String getNoteTitle() {
        return noteTitle;
    }

    public void setNoteTitle(String noteTitle) {
        this.noteTitle = noteTitle;
    }

    public String getNoteContent() {
        return noteContent;
    }

    public void setNoteContent(String noteContent) {
        this.noteContent = noteContent;
    }

    @Override
    public String toString(){
        return this.noteTitle;
    }
}
