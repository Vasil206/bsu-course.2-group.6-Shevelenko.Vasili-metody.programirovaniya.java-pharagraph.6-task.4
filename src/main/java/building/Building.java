/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package building;

/**
 *
 * @author Acer
 */
public interface Building {

    /**
     *returns the type of building
     * @return
     */
    String typeOfBuilding();
    
    /**
     * returns build a building or not
     * @return
     */
    boolean isBuilt();
    
    /**
     * build a building.
     * if successful. returns true, else false 
     * @return
     */
    boolean build();
    
    
}
