/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package svugame.dialogue;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import svugame.model.skills.Skill;
import svugame.model.skills.SkillList;

/**
 *
 * @author craig.reese
 */
public class ConversationManager {
    //dialoguemanager needs to get an arraylist of all conversations and make it available to the game 
    //it should also keep track of where you are in a conversation and should pass this along to the ui
    //TODO:Conditional Dialogue Choices
    //TODO:Results at the end of a conversation

    String[] pointer;
    private static final String CONVERSATIONS_XML = "./conversation-jaxb.xml";

    ConversationList list = new ConversationList();
    ArrayList<Conversation> allConversations = new ArrayList();
    Conversation convo = new Conversation();
    String currentString;
    ArrayList<Dialogue> convoList;

  
    
    public ConversationManager(String conversationName) throws JAXBException {
        //only ran when instantiated, we need an arraylist of conversations here.
        //CreateXML();
        allConversations = GetAllConversations();
        for(Conversation con : allConversations)
        {
            if(con.getConversationName().equals(conversationName))
            {
                convo = con;
            }
        }
        currentString = convo.GetDialogue("start").getText();
        convoList = convo.GetAllLinkingDialogues("start");
        //at this point we should have our starting info.
        System.out.println("test");
        
    }
    
      public String getCurrentString() {
        return currentString;
    }

    public ArrayList<Dialogue> getConvoList() {
        return convoList;
    }
    
    
    //here's what we need to do
    //at the start of the conversation we will always need to get the starter and display it as a label
    //we also need to get all of its children and add them as buttons
    //so we should probably load an instance of this class using a conversation name as the input

    public void GetNextDialogue(String choice) {
           Dialogue tempDialogue = convo.GetDialogue(choice);
           String tempDialoguePointer = tempDialogue.getPointer()[0];
           Dialogue nextDialogue = convo.GetDialogue(tempDialoguePointer);
           currentString = nextDialogue.getText();
           convoList = convo.GetAllLinkingDialogues(nextDialogue.getId());
    }

    private ArrayList<Conversation> GetAllConversations() {
        ArrayList<Conversation> conversationList = null;
        try {

            // create JAXB context and initializing Marshaller
            JAXBContext jaxbContext = JAXBContext.newInstance(ConversationList.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            // specify the location and name of xml file to be read
            File XMLfile = new File("./Arena1_conversation.xml");

            // this will create Java object - country from the XML file
            //Country countryIndia = (Country) jaxbUnmarshaller.unmarshal(XMLfile);
            ConversationList list = (ConversationList) jaxbUnmarshaller.unmarshal(XMLfile);

            //System.out.println("Conversation Name: " + countryIndia.getCountryName());
            //System.out.println("Country Population: " + countryIndia.getCountryPopulation());

            //ArrayList<state> listOfStates = countryIndia.getListOfStates();
             conversationList = list.getAllConversations();

            /*
            int i = 0;
            for (State state : listOfStates) {
                i++;
                System.out.println("State:"+i + ' ' + state.getStateName());
            }*/
            
            
            
            

        } catch (JAXBException e) {
            // some exception occured
            e.printStackTrace();
        }

        return conversationList;
    }

    /* THIS WORKS YAAAAY */
    private void CreateXML() throws PropertyException, JAXBException {
        ArrayList<Dialogue> dialogueList = new ArrayList<Dialogue>();
        ArrayList<Dialogue> dialogueList2 = new ArrayList<Dialogue>();
        ArrayList<Conversation> conversationList = new ArrayList<Conversation>();

        //create dialogues
        Dialogue dialogue0 = new Dialogue("start", new String[]{""}, "this is the begining dialogue", new String[]{"b1", "b2"}, new String[]{""});
        Dialogue dialogue1 = new Dialogue("b1", new String[]{"STR>=10", "SNEAK >=5"}, "this is the test dialogue", new String[]{"c1", "c2"}, new String[]{"STR + 2", "FACTIONEVIL - 10"});
        Dialogue dialogue2 = new Dialogue("c1", new String[]{""}, "this is the test dialogue2", new String[]{"d1", "d2"}, new String[]{""});

        dialogueList.add(dialogue0);
        dialogueList.add(dialogue1);
        dialogueList.add(dialogue2);

        Conversation convo = new Conversation();
        convo.setConversationName("test convo");
        convo.setDialogueList(dialogueList);

        Dialogue dialogue3 = new Dialogue("start", new String[]{""}, "this is the begining dialogu6e", new String[]{"b1", "b2"}, new String[]{""});
        Dialogue dialogue4 = new Dialogue("b1", new String[]{"END>=10", "HIT >=5"}, "this is the test dialogue", new String[]{"c1", "c2"}, new String[]{"STR + 2", "FACTIONEVIL - 10"});
        Dialogue dialogue5 = new Dialogue("c1", new String[]{""}, "this is the test dialogue5", new String[]{"d1", "d2"}, new String[]{""});

        dialogueList2.add(dialogue3);
        dialogueList2.add(dialogue4);
        dialogueList2.add(dialogue5);

        Conversation convo2 = new Conversation();
        convo2.setConversationName("test convo2");
        convo2.setDialogueList(dialogueList2);

        conversationList.add(convo);
        conversationList.add(convo2);

        list.setAllConversations(conversationList);
        JAXBContext context = JAXBContext.newInstance(ConversationList.class);
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        // Write to System.out
        //m.marshal(skillSet, System.out);
        // Write to File
        m.marshal(list, new File(CONVERSATIONS_XML));

    }

}
