package com.example.notesapp.core.database;
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
    @ColumnInfo(name = "timestamp")
    private String timestamp;
    @Ignore
    public Note() {
    }
    public Note(String title, String description, String timestamp) {
        this.title = title;
        this.description = description;
        this.timestamp = timestamp;
    }
    public Note(Parcel in) {
        id = in.readInt();
        title = in.readString();
        description = in.readString();
        timestamp = in.readString();
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
    public String getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    @Override
    public boolean equals(@Nullable Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        Note note = (Note) obj;
        return note.id == this.id &&
                java.util.Objects.equals(note.title, this.title) &&
                java.util.Objects.equals(note.description, this.description)&&
                java.util.Objects.equals(note.timestamp, this.timestamp);
    }
    @Override
    public int hashCode() {
        return java.util.Objects.hash(title, description, id, timestamp);
    }
    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description +
                ", timestamp='" + timestamp  +'}';
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
        parcel.writeString(timestamp);
    }
}