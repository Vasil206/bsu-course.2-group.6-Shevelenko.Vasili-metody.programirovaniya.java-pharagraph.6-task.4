
package building.PublicBuilding;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import building.Building;

/**
 * class that representing a public building
 * 
 * @author Acer
 */
public abstract class PublicBuilding implements Building {
    
    private boolean isBuilt;
    private final LocalTime[] timeOfOpening;         //opening on each day of a week
    private final LocalTime[] timeOfClosing;         //closing on each day of a week
    
    public PublicBuilding(){
        
        isBuilt = false;
        timeOfOpening = new LocalTime[7];
        timeOfClosing = new LocalTime[7];
    }
    
    @Override
    public final String typeOfBuilding(){
        
        return "PublicBuilding";
    }
    
    @Override
    public boolean isBuilt(){
        
        return isBuilt;
    }
    
    @Override
    public boolean build(){
       
        isBuilt = true;
        
        return true;
    }
    
    public void brek(){
       
        isBuilt = false;
    }
    
    /**
     * if building is opened now, returns true, else false.
     * 
     * @return 
     */
    public boolean isOpened(){
        
        var dayOfWeek = LocalDate.now().getDayOfWeek().getValue() - 1;
        
        return (LocalTime.now().compareTo(timeOfOpening[dayOfWeek]) >= 0
                && LocalTime.now().compareTo(timeOfClosing[dayOfWeek]) < 0);
    }
    
    public boolean isOpenedAt(DayOfWeek dayOfWeek, LocalTime time){
        
        var dayOfWeekIndex = dayOfWeek.getValue() - 1;
        
        return (time.compareTo(timeOfOpening[dayOfWeekIndex]) >= 0
                && time.compareTo(timeOfClosing[dayOfWeekIndex]) < 0);
    }
    
    /**
     * returns a list of work schedule.
     * Where first element is the array of time of opening,
     * second element is the array of time of closing
     * 
     * @return
     */
    public List<LocalTime[]> getWorkSchedule(){
        
        var workSchedule = new ArrayList<LocalTime[]>()
        {
            {
                           add(timeOfOpening);
                           add(timeOfClosing);
            }   
        };
        
        return workSchedule;
    }
    
    /**
     * set time of opening on a specific day of week
     * @param dayOfWeek
     * @param newTimeOfOpening 
     */
    public void setTimeOfOpening(DayOfWeek dayOfWeek,
            LocalTime newTimeOfOpening){
        
        timeOfOpening[dayOfWeek.getValue() - 1] = newTimeOfOpening;
    }
    
    /**
     * set time of closing on a specific day of week.
     * 
     * @param dayOfWeek
     * @param newTimeOfClosing 
     */
    public void setTimeOfClosing(DayOfWeek dayOfWeek,
            LocalTime newTimeOfClosing){
        
        timeOfClosing[dayOfWeek.getValue() - 1] = newTimeOfClosing;
    }
}
