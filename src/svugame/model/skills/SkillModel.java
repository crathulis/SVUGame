/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package svugame.model.skills;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Lab Admin
 */
//@XmlRootElement(name = "skill")
@XmlType(propOrder = {"name", "id", "sdesc", "ldesc", "attrib1", "attrib2"})
public class SkillModel {

    public SkillModel() {

    }

    public SkillModel(String name, int id, String sdesc, String ldesc, int attrib1, int attrib2) {
        this.name = name;
        this.id = id;
        this.sdesc = sdesc;
        this.ldesc = ldesc;
        this.attrib1 = attrib1;
        this.attrib2 = attrib2;

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

    public String toString() {
        return String.format("<SkillModel: %s, %d, \"%s\", \"%s\", %d, %d>",
                name, id, sdesc, ldesc, attrib1, attrib2);
    }

    private String name;
    private int id;
    private String sdesc;
    private String ldesc;
    private int attrib1;
    private int attrib2;

}
