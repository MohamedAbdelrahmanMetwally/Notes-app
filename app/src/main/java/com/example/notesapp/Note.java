package com.example.notesapp;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
@Entity(tableName = "note")
public class Note implements Parcelable {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "title")
    private String title;
    @ColumnInfo(name = "description")
    private String description;
    @Ignore
    public Note() {}
    public Note(String title, String description) {
        this.title = title;
        this.description = description;
    }
    public Note(Parcel in) {
        id = in.readInt();
        title = in.readString();
        description = in.readString();
    }
    public static final Creator<Note> CREATOR = new Creator<Note>() {
        @Override
        public Note createFromParcel(Parcel in) {
            return new Note(in);
        }
        @Override
        public Note[] newArray(int size) {
            return new Note[size];
        }
    };
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    @Override
    public boolean equals(@Nullable Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        Note note = (Note) obj;
        return note.id == this.id &&
                java.util.Objects.equals(note.title, this.title) &&
                java.util.Objects.equals(note.description, this.description);
    }
    @Override
    public int hashCode() {
        return java.util.Objects.hash(title, description, id);
    }
    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description +
                '}';
    }
    @Override
    public int describeContents() {
        return 0;
    }
    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(title);
        parcel.writeString(description);
    }
}