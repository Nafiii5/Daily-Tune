package Model;

import java.time.LocalDate;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class DailyTuneEntry {

    
    private final StringProperty title;
    private final StringProperty artist;
    private final ObjectProperty<LocalDate> date;

    
    public DailyTuneEntry(String title, String artist, LocalDate date) {
        this.title = new SimpleStringProperty(title);
        this.artist = new SimpleStringProperty(artist);
        this.date = new SimpleObjectProperty<>(date);
    }

    
    public String getTitle() {
        return title.get();
    }
    public StringProperty titleProperty() {
        return title;
    }

    public String getArtist() {
        return artist.get();
    }
    public StringProperty artistProperty() {
        return artist;
    }

    public LocalDate getDate() {
        return date.get();
    }
    public ObjectProperty<LocalDate> dateProperty() {
        return date;
    }
}