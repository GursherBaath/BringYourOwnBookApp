package com.example.bringyourownbook;

public class Deck {
    private int count;
    //TO DO: make the length that matches your number of cards
    private Card data[] = new Card[144];

    public Deck() {
        shuffle();
    }

    public void shuffle() {
        //array for the prompt instance variable
        String[] prompts = {"Lyrics from a Christmas song", "A line from a horoscope", "The title of a buddy cop movie", "A passage from a religious text", "The best part of a vacation", "The meaning of life is…", "Words on a welcome mat", "Something the government doesn't want people to know", "A sentence in a fortune cookie", "Text on a birth announcement", "Part of a birthday message", "Text from a sitcom script", "Text from a book about conspiracy theories", "A line in an eviction notice", "A line on a worker's performance evaluation", "Lyrics from a hip hop song", "Lyrics from a country-western song", "Something shouted at another driver in traffic", "Overheard at a sporting event", "The moment in a fairy tale when someone is cursed", "Something that demands an apology", "The name of a television legal drama", "Spoiler Alert:______________", "A line from a manifesto", "Part of a superhero's origin story", "Don't open an email with this subject header", "A line from an unpublished Dr. Seuss book", "An error message on a computer", "Part of a wedding toast", "Lyrics from a power ballad", "A euphemism for going to the bathroom", "Lyrics from a blues song", "Part of a letter home from summer camp", "The name of a new party game", "Overheard on a CB radio channel where truckers are talking", "The 11th Commandment", "Part of an online product review", "Lyrics from a lullaby", "Overheard at a garage sale", "Minutes from a government meeting", "Part of a driver's education manual", "An unusual item on an airplane safety card", "Overheard while toddlers are playing with toys", "An excuse for being late", "Step 5 in my evil plan to take over the world", "The last line of a haiku (5 syllables)", "Lyrics from a punk rock song", "When I was a kid, this is where they said that babies came from", "The repeated lyrics in a techno dance song", "Part of an online restaurant review", "Something that deserves applause", "Part of an outdated law", "Something written on an IOU", "The moment in a sci-fi novel when a robot behaves unexpectedly", "The moment in a sci-fi novel when a new world is discovered", "A reaction to discovering treasure", "This sounds cooler when you say it with a French accent", "Code words passed between secret agents to confirm their identities", "The moment in a western when gunfighters have a showdown", "A word that sounds awesome when read backwords", "Overheard at the zoo", "A stage direction in a comedic play", "A phrase you wouldn't want to hear your grandparents say", "A bit of bad news", "A good warning to children", "The title of a long-lost Alfred Hitchcock thriller", "The punchline of a joke", "A line from a science textbook", "Something spoken by an animal in a fairy tale", "A sentence that's twice as dramatic when read slowly", "A curious footnote on a tax form", "Text from a soap opera script", "The name of an all-purpose household cleaner", "Famous last words", "Rejected book title: Harry Potter and the ___________", "A town slogan", "Text from a cookbook", "In my cult, everybody has to do this twice a day", "The words that bring an end to an argument", "The award-winning moment in a dramatic film", "A name for a dog", "A line you would print on the back cover to sell your book", "A clue that there will be a sequel to your book", "A phrase you could see on a t-shirt", "This is the way the world ends", "The yoga instructor makes us chant this mantra over and over again", "Narration from a nature documentary about animals", "The title of a post-apocalyptic sci-fi novel", "Text on a motivational poster", "The name of a beauty product", "Words from a magic spell", "The title of a self-help book", "The most important ingredient in a magic potion", "The name of the latest trendy soft drink", "Part of a fortune teller's prophecy", "A line that's sarcastic when you replace a name with \"Captain Obvious\"", "A name for a cat", "The moment in a horror novel before someone goes missing", "A line from an obituary", "A sentence that's funnier when you replace one word with \"pants\"", "The name of a fast food restaurant", "A line from a concert review", "The name of a popular new indie band", "The moment a bad omen appears in a horror novel", "The name of an unpublished Stephen King novel", "Text from a nature guide", "The name of a store that sells almost everything", "Fine print on a long contract", "A hero's catchphrase", "A line from a movie review", "The slogan on a bumper sticker", "The moment in a romance novel when love blooms", "A doctor's note on a patient's chart", "Something you'll lie awake thinking about tonight", "The last thing you want to hear on a first date", "An item in a police report", "The title of _____'s autobiography", "The name of a craft beer", "The name of a battleship", "Something used as money in a post-apocalyptic society", "Something a hypnotist would repeat to induce a trance", "Something shouted at a fleeing criminal", "Advice for graduating seniors", "Part of a note passed between desks in elementary school", "The moment in a mystery novel when an important clue is found", "The title of a murder mystery novel", "The name of a candy bar", "The name of a television sitcom", "Part of a big fight scene in a superhero's story", "Text on a warning label", "Overheard in a dream", "A euphemism for going to bed", "The first thing you think when you wake up", "The description of the villain in an adventure film", "The part in a children's film where a kid outsmarts an adult", "A universal truth", "Something you'd be surprised to find in a coat pocket", "Part of a tearful reunion in a romance novel", "A line in a ransom note", "A statement likely to be challenged if presented as fact", "A line from a passive-aggressive note", "The name of a doctoral thesis", "The name of a specialized clothing store", "An excuse for forgetting a birthday"};

        //Randomizez the order of the array
        for (int i = 0; i < 144; i++) {
            int r1 = (int) (Math.random() * prompts.length);
            int r2 = (int) (Math.random() * prompts.length);
            String temp = prompts[r1];
            prompts[r1] = prompts[r2];
            prompts[r2] = temp;
        }
        count = 0;
        //pushes all cards (now in random order) into the Deck
        for (int i = 0; i < prompts.length; i++) {
            Card c = new Card(prompts[i]);
            push(c);
        }
    }

    //pushes a card onto the deck and updates the new number of cards in the deck
    public void push(Card addMe) {
        data[count] = addMe;
        count++;
    }

    //returns the number of cards in the deck
    public int size() {
        return count;
    }

    //returns if the deck is full or not
    public boolean isFull() {
        return (count == 144);
    }

    //takes a card off the deck and returns it. Also updates the number of cards in the deck
    public Card pop() {
        count--;
        return data[count];
    }

    //returns the card in the deck without popping it off
    public Card peek() {
        return data[count-1];
    }

    //returns if the deck if empty or not
    public boolean isEmpty() {
        return count == 0;
    }

    //sets the variable that holds the number of cards in the deck to zero
    public void clear() {
        count = 0;
    }
}
