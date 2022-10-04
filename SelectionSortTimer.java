/**
 *  Program sorts cards in selection Sort Algorithm, omitting graphics
 *
 *  @author Ramsha Rauf
 *  @version March 2022
 */
public class SelectionSortTimer {

  /** Starts the program running */
  public static void main(String args[]) {
    
    if (args.length<1) {
      System.err.println("Please specify how many cards to sort!");
    } else {
      Card[] deck = Card.newDeck(true);
      CardPile cards = new CardPile(2,2);
      
      for (int i = 0; i<Integer.parseInt(args[0]); i++ ) {
        cards.add(deck[(int)(52*Math.random())]);
      }

      sort(cards);
      
    }
  }
  
  /**
  *Sorts the list in selection Sort algorithm
  *@param unsorted cardpile and record 
  *@return a sorted cardpile
  */
  public static CardPile sort(CardPile unsorted ) {
    
    // Here is the result list you will be creating
    CardPile sorted = new CardPile(2,2);
  
   
    while (unsorted.size() > 0){
      Card smallest = unsorted.getFirst();
      for (Card c : unsorted){
        if (smallest.compareTo(c) > 0){
          smallest=c;
        } 
      }
      unsorted.remove(smallest);
      sorted.addLast(smallest);
    }
    // return the sorted result here
    return sorted;
  }
}
