/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package svugame.model.skills;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author alan.whitehurst
 */
public class Test {

    private static final String SKILLLIST_XML = "./skillset-jaxb.xml";

    public static void main(String[] args) throws JAXBException, IOException {

        ArrayList<Skill> skillList = new ArrayList<Skill>();

        // create books
        Skill skill1 = new Skill("One-handed", 3, 0, 0, "");
        skillList.add(skill1);
        Skill skill2 = new Skill("Two-handed", 0, 3, 0, "");
        skillList.add(skill2);
        SkillList skillSet = new SkillList(skillList);

        // create JAXB context and instantiate marshaller
        JAXBContext context = JAXBContext.newInstance(SkillList.class);
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        // Write to System.out
        //m.marshal(skillSet, System.out);
        // Write to File
        m.marshal(skillSet, new File(SKILLLIST_XML));
        // get variables from our xml file, created before
        System.out.println();
        System.out.println("Output from our XML File: ");
        Unmarshaller um = context.createUnmarshaller();
        SkillList skillList2 = (SkillList) um.unmarshal(new FileReader(SKILLLIST_XML));
        ArrayList<Skill> list = skillList2.getListOfSkills();
        for (Skill skill : list) {
            System.out.println("Skill: " + skill.getName() + " Level: "
                    + skill.getLevel());
        }
    }

}
