package com.example.bringyourownbook;

    public class Card {
    //the one private instance variable that holds the prompt of the card
    private String prompt;

    public Card(String p) {
        prompt = p;
    }
    //default prompt when a new card is made
    public Card() {
        prompt = "Lyrics from a Christmas song";
    }
    //sets the prompt of card
    public void setPrompt(String p) {
        prompt = p;
    }
    //returns the prompt of a card
    public String getPrompt() {
        return prompt;
    }
    //returns what the prompt of the card is in a sentence structure
    public String toString() {
        return "the prompt is:" + prompt;
    }
    //returns if the prompt of 2 cards is equal or not
    public boolean equals(Card i) {
        if (i.getPrompt().equals(prompt))
            return true;
        else
            return false;
    }
    //returns an integer corresponding to whether the original prompt is larger, smaller or equal to the other prompt
    public int compareTo(Card i) {
        return prompt.compareTo(i.getPrompt());

    }

}
