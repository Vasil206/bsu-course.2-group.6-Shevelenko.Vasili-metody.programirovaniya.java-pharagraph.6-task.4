
package building.PublicBuilding;

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
        build();
        
        /* set default time of working */
        for(var i = 1; i <= 7; i++){
            
            this.setTimeOfOpening(DayOfWeek.of(i), LocalTime.parse("16:00:00"));
            this.setTimeOfClosing(DayOfWeek.of(i), LocalTime.parse("23:59:59"));
        }
    }
}
