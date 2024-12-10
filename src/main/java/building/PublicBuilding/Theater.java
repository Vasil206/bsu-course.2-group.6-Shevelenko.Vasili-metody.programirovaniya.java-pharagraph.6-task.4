/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package building.PublicBuilding;

import building.IBuilding;
import java.lang.annotation.Annotation;
import java.time.DayOfWeek;
import java.time.LocalTime;

/**
 *
 * @author Acer
 */
public class Theater extends PublicBuilding {
    
    /**
     * create a default instance of Theater
     */
    public Theater(){
        
        super();
        
        /* set default time of working */
        for(var i = 1; i <= 7; i++){
            
            this.setTimeOfOpening(DayOfWeek.of(i), LocalTime.parse("16:00:00"));
            this.setTimeOfOpening(DayOfWeek.of(i), LocalTime.parse("23:59:59"));
        }
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        
        
        return IBuilding.class;     // am i right?
    }
}
