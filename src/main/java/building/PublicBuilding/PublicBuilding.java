/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package building.PublicBuilding;

import building.IBuilding;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 * class represents a public building
 * 
 * @author Acer
 */
public abstract class PublicBuilding implements IBuilding {
    
    private boolean _isBuilt;
    private LocalTime[] _timeOfOpening;         //opening on each day of a week
    private LocalTime[] _timeOfClosing;         //closing on each day of a week
    
    public PublicBuilding(){
        
        _isBuilt = false;
        _timeOfOpening = new LocalTime[7];
        _timeOfClosing = new LocalTime[7];
    }
    
    @Override
    public final String typeOfBuilding(){
        
        return "PublicBuilding";
    }
    
    @Override
    public boolean isBuilt(){
        
        return _isBuilt;
    }
    
    @Override
    public boolean build(){
       
        _isBuilt = true;
        
        return true;
    }
    
    /**
     * if building is opened now, returns true, else false.
     * 
     * @return 
     */
    public boolean isOpened(){
        
        var dayOfWeek = LocalDate.now().getDayOfWeek().getValue();
        
        return (LocalTime.now().isAfter(_timeOfOpening[dayOfWeek - 1])
                && LocalTime.now().isBefore(_timeOfClosing[dayOfWeek - 1]));
    }
    
    /**
     * returns a list of work schedule.
     * Where first element is the array of time of opening,
     * second element is the array of time of closing
     * 
     * @return
     */
    public ArrayList<LocalTime[]> getWorkSchedule(){
        
        var workSchedule = new ArrayList<LocalTime[]>()
        {
            {
                           add(_timeOfOpening);
                           add(_timeOfClosing);
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
        
        _timeOfOpening[dayOfWeek.getValue() - 1] = newTimeOfOpening;
    }
    
    /**
     * set time of closing on a specific day of week.
     * 
     * @param dayOfWeek
     * @param newTimeOfClosing 
     */
    public void setTimeOfClosing(DayOfWeek dayOfWeek,
            LocalTime newTimeOfClosing){
        
        _timeOfClosing[dayOfWeek.getValue() - 1] = newTimeOfClosing;
    }
}
