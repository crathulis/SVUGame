package svugame.model.entity;

import java.util.ArrayList;
import java.util.Iterator;
import svugame.model.Thing;

/**
 * A party is a group of entities that travel and fight together.
 *
 * @author alan.whitehurst
 */
public class Party extends Thing {

    private ArrayList<Entity> members;

    /**
     * Creates an empty party.
     */
    public Party() {
        members = new ArrayList();
    }

    /**
     * Add an entity to a party.
     */
    public void add(Entity entity) {
        members.add(entity);
    }
    
    /**
     * Gets the entities that make up a party.
     * @return an ArrayList of party members.
     */
    public ArrayList<Entity> getMembers(){
        return members;
    }
    
    /**
     * Returns an interator over the members of the party;
     * @return an iterator over the members of the party.
     */
    public Iterator<Entity> iterator(){
        return members.iterator();
    }
    
    /**
     * Get the total health of all party members.
     *
     * @return the total health of all party members.
     */
    public int getHealth() {
        int healthTotal = 0;
        for (Entity entity : members) {
            healthTotal += entity.getHealth();
        }
        return healthTotal;
    }

    /**
     * Returns true if the total health of the party
     * is greater than 0.
     * @return true if party health > 0; false otherwise.
     */
    public boolean isActive() {
        return getHealth() > 0;
    }

}
