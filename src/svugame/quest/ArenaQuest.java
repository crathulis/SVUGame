/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package svugame.quest;

/**
 *
 * @author Jordan
 */
public class ArenaQuest {
    
    public ArenaQuest(){
        this.example = new Quest("example");
        constructQuest();
    }
    
    public Quest getQuest(){
        return example;
    }
    
    private void constructQuest(){
        example.addStage(0, "You are in the arena and must fight. Start a fight "
                + "by speaking with the arena master and keep your eyes open"
                + "for a way to get out.");
        example.addStage(5, "Go through the door to fight your first arena battle.");
        example.addStage(10, "You've won your first battle. Talk to the Arena Master to start the second.");
        example.addStage(15, "You've won the second arena fight. Ask around the arena to "
                + "see if anyone knows how to escape the arena, or fight your "
                + "third fight.");
        example.addStage(20, "You've told the Arena Master that you want to fight "
                + "the third battle. Good luck with that!");
        example.addStage(25, "The Mage Trainer has suggested that he might be able to"
                + "teleport you out if you can find a ritual ingrediant around the arena"
                + "called a Gloomy Mushroom.");
        example.addStage(30, "The Warrior Trainer has mentioned that one of the "
                + "arena battlers isn't exactly mentally stable and that if you "
                + "insult him he might attack you. If you do get in a fight you'll be thrown"
                + "in solitary confinement, where it is said that one prisoner once"
                + "escaped through a secret tunnel.");
        example.addStage(35, "Both the Mage Trainer and the Warrior Trainer have "
                + "suggested ways to escape the Arena.");
        example.addStage(40, "You've been thrown into solitary confinement. Where could"
                + "that secret tunnel be?");
        example.addStage(50, "You've defeated the Rellian Bloodletter and the dark"
                + "energy blast that emitted from his body upon his death has blown"
                + "the arena gate open. Escape quickly!");
        example.addStage(100, "You've escaped the arena!");
    }
    
    private Quest example;
    
}
