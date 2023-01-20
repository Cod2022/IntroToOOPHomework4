import java.time.LocalDate;
import java.time.LocalTime;

public class DairyData {
    private int id;
    private String fullName;
    private LocalDate date;
    private LocalTime time;
    private Priority priority;

    public DairyData(int id, String fullName, Priority priority) {
        this.id = id;
        this.fullName = fullName;
        this.date = LocalDate.now();
        this.time = LocalTime.now();
        this.priority = priority;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    

    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public LocalTime getTime() {
        return time;
    }
    public void setTime(LocalTime time) {
        this.time = time;
    }

    
    @Override
    public String toString() {
        return String.format("ID: %d Name: %s Date: %s Time: %s", id, fullName, date, time);
    }
    public Priority getPriority() {
        return priority;
    }
    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    
}
