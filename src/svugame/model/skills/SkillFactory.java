package svugame.model.skills;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import static svugame.model.skills.SkillConstants.NUM_SKILLS;

/**
 *
 * @author Lab Admin
 */
class SkillFactory {

    static {
        final String SKILLLIST_XML = "./data/skillset-jaxb.xml";
        try {
            JAXBContext context = JAXBContext.newInstance(SkillList.class);
            Unmarshaller um = context.createUnmarshaller();
             skillList = (SkillList) um.unmarshal(new FileReader(SKILLLIST_XML));
        } catch (JAXBException ex) {
            Logger.getLogger(SkillFactory.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SkillFactory.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex);
        }
    }

    public static SkillModel getModel(int skillId) {
        return skillList.getSkillModelById(skillId);
    }
    
    public static SkillModel getModel(String name){
        return skillList.getSkillModelByName(name);
    }
    
    public static void main(String [] args){
        for(int i=0;i<NUM_SKILLS;++i){
            SkillModel sm = SkillFactory.getModel(i);
            System.out.println(i + ": " + sm);
        }
    }
    
    private static SkillList skillList;

}
