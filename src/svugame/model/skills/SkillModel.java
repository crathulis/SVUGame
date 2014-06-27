package svugame.model.skills;

import javax.xml.bind.annotation.XmlType;

/**
 * SkillModel describes the basic parameters of skills. Everything the player
 * attempts to do is modeled by a skillCheck. Skills have a level, and most
 * skills can be trained. Skills are governed by two attributes, which represent
 * the base chance of success without training. Levels of training improve the
 * chance of success beyond the base amount. The exercise of a skill requires
 * the expenditure of focus.
 * 
 * @author Lab Admin
 */
//@XmlRootElement(name = "skill")
@XmlType(propOrder = {"name", "id", "sdesc", "ldesc", "attrib1", "attrib2", "spirit"})
public class SkillModel implements Comparable {

    public SkillModel() {
        this(0);
    }

    public SkillModel(int id) {
        this("", id, "", "", 0, 0, 1);
    }

    public SkillModel(String name, int id, String sdesc, String ldesc, int attrib1, int attrib2, int spirit) {
        this.name = name;
        this.id = id;
        this.sdesc = sdesc;
        this.ldesc = ldesc;
        this.attrib1 = attrib1;
        this.attrib2 = attrib2;
        this.spirit = spirit;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSdesc() {
        return sdesc;
    }

    public void setSdesc(String description) {
        this.sdesc = description;
    }

    public String getLdesc() {
        return ldesc;
    }

    public void setLdesc(String description) {
        this.ldesc = description;
    }

    public int getAttrib1() {
        return attrib1;
    }

    public void setAttrib1(int attrib1) {
        this.attrib1 = attrib1;
    }

    public int getAttrib2() {
        return attrib2;
    }

    public void setAttrib2(int attrib2) {
        this.attrib2 = attrib2;
    }

    public int getSpirit() {
        return spirit;
    }

    public void setSpirit(int focus) {
        this.spirit = focus;
    }
    
    @Override
    public int compareTo(Object o) {
        if ((o == null) || (!(o instanceof SkillModel))) {
            return 1;
        }
        return this.id - ((SkillModel) o).getId();
    }

    @Override
    public String toString() {
        return String.format("<%s: %d, %d, %d, %d >", name, id, attrib1, attrib2, spirit);
    }

    private String name;
    private int id;
    private String sdesc;
    private String ldesc;
    private int attrib1;
    private int attrib2;
    private int spirit;

    

}
