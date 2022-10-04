/**
 *  Program sorts cards in InsertionSort Algorithm, omitting graphics
 *
 *  @author Ramsha Rauf
 *  @version March 2022
 */
import java.util.*;
public class InsertionSortTimer {

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
  *Sorts the list in insertion Sort algorithm
  *@param unsorted cardpile and record 
  *@return a sorted cardpile
  */
  public static CardPile sort(CardPile unsorted) {

    // Here is the result list you will be creating
    CardPile sorted = new CardPile(2,2);
  
    // ***********************************************************
    // Here is where you'll do the "work" of InsertionSort:
    //   - Use sorted to store the "sorted portion"
    //   - Don't forget to register the new state with the
    //     recorder after each card is transferred:
    //        record.next();        // tell it this is a new step
    //        record.add(sorted);   // the sorted pile
    //        record.add(unsorted); // the unsorted pile
    // ***********************************************************


    while (unsorted.size()>0){
      Card firstCard = unsorted.removeFirst();
      if (sorted.size()==0){
        sorted.addFirst(firstCard);
      }else{
        if (firstCard.compareTo(sorted.getFirst())<0){
          sorted.addFirst(firstCard);
        }else if (sorted.getLast().compareTo(firstCard)<0){
          sorted.addLast(firstCard);
        }else{
          ListIterator<Card> iter = sorted.listIterator();
          while(iter.hasNext()){
            Card c = iter.next();
            if (firstCard.compareTo(c) < 0){
              iter.previous();
              iter.add(firstCard);
              break;
            }
          }
        }
      }

    }
    return sorted;
  }
}
