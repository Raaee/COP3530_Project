/* 
* This class provides a variety of words within three methods: EasyWords, MidWords, and HardWords. 
* Each method returns an array of strings that contains words of varying difficulty levels of the Womble word game.
*/

public class WombleWordsData {

    public String[] EasyWords() {
        String[] easyWords = { "Skirt", "Tonic", "Flute", "Bluff", "Apple", "Grasp",
                "Shift", "Karma", "Fudge", "Jolly", "Fable", "Spicy", "Gloom", "Diver" };
        return easyWords;
    }

    public String[] MidWords() {
        String[] midWords = { "Witty", "Flair", "Thyme", "Haste", "Niche", "Haunt",
                "Mural", "Caper", "Plaid", "Tweak", "Gorge", "Braid", "Drown", "Muted" };
        return midWords;
    }

    public String[] HardWords() {
        String[] hardWords = { "Mirth", "Heist", "Pique", "Quilt", "Prawn", "Nymph",
                "Merge", "Latch", "Hinge", "Knack", "Chant", "Joust", "Nexus", "Glaze" };
        return hardWords;
    }
}