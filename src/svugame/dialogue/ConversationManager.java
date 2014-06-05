/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package svugame.dialogue;

import java.io.File;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author craig.reese
 */
public class ConversationManager {
    //dialoguemanager needs to get an arraylist of all conversations and make it available to the game
    //it should also keep track of where you are in a conversation and should pass this along to the ui

    private ArrayList<Conversation> allConversations;
    String[] pointer;

    public ConversationManager() throws ParserConfigurationException, TransformerException {
        //only ran when instantiated, we need an arraylist of conversations here.
        //CreateXML();
        allConversations = GetAllConversations();
    }

    public Dialogue GetNextDialogue(String conversationName, String choice) {

        return null;  //TODO:  fix this
    }

    private ArrayList<Conversation> GetAllConversations() {
        try {
            File conversationsFile = new File("ConversationList.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(conversationsFile);
            //doc.getDocumentElement().normalize();
            Element docEle = doc.getDocumentElement();
            
            NodeList nodes = docEle.getElementsByTagName("Dialogue");

            for (int i = 0; i < nodes.getLength(); i++) {
                Node node = nodes.item(i);

                Conversation conv = new Conversation();
                conv.setConversationName(null);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
/*
    private void CreateXML() throws ParserConfigurationException, TransformerConfigurationException, TransformerException {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

        // root elements
        Document doc = docBuilder.newDocument();
        Element rootElement = doc.createElement("ConversationList");
        doc.appendChild(rootElement);

        Element conversation = doc.createElement("Conversation");
        rootElement.appendChild(conversation);

        Element conversationName = doc.createElement("conversationName");
        conversationName.appendChild(doc.createTextNode("Opening Dialogue"));
        conversation.appendChild(conversationName);

        Element dialogueTree = doc.createElement("Dialogue");
        conversation.appendChild(dialogueTree);

        Element id = doc.createElement("id");
        id.appendChild(doc.createTextNode("a"));
        dialogueTree.appendChild(id);
        
        Element text = doc.createElement("text");
        text.appendChild(doc.createTextNode("Where am I?"));
        dialogueTree.appendChild(text);

        Element pointer = doc.createElement("pointer");
        pointer.appendChild(doc.createTextNode("b"));
        dialogueTree.appendChild(pointer);

        /*
        //Element conversation = doc.createElement("conversation");
        Node item = null;
        item = xmlDoc.createElement("Opening Dialogue");

        Element conversationName = doc.createElement("conversationName");
        conversationName.setValue("Opening Dialogue");
        conversation.setAttributeNode(conversationName);

        Element dialogueTree = doc.createElement("dialogueTree");
        conversation.appendChild(dialogueTree);

        Element id = doc.createElement("id");
        id.appendChild(doc.createTextNode("a"));
        dialogueTree.appendChild(id);

        Element text = doc.createElement("text");
        text.appendChild(doc.createTextNode("Where am I?"));
        dialogueTree.appendChild(text);

        Element pointer = doc.createElement("pointer");
        pointer.appendChild(doc.createTextNode("b"));
        dialogueTree.appendChild(pointer);

        Element id2 = doc.createElement("id");
        id2.appendChild(doc.createTextNode("b"));
        dialogueTree.appendChild(id2);

        Element text2 = doc.createElement("text");
        text2.appendChild(doc.createTextNode("How did i get here?"));
        dialogueTree.appendChild(text2);

        Element pointer2 = doc.createElement("pointer");
        pointer2.appendChild(doc.createTextNode("c"));
        dialogueTree.appendChild(pointer2);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File("ConversationList.xml"));

        // Output to console for testing
        // StreamResult result = new StreamResult(System.out);
        transformer.transform(source, result);

        System.out.println("File saved!");

    }
*/
}
