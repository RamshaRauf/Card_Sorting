/**
 *  Program sorts cards in Quick Sort Algorithm, omitting graphics
 *
 *  @author Ramsha Rauf
 *  @version March 2022
 */
public class QuicksortTimer {
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
  *Sorts the list in quick Sort algorithm
  *@param unsorted cardpile and record 
  *@return a sorted cardpile
  */
  public static CardPile sort(CardPile unsorted) {
    
    if (unsorted.size()==0 || unsorted.size()==1){
      return unsorted;
    }else{
    // ***********************************************************
    // Here is where you'll check the stop condition and return
    // if it is satisfied.
    // ***********************************************************
    // Here are the two partitions you will be creating
    CardPile smaller = new CardPile(2,2);
    CardPile bigger = new CardPile(2,2);
   
    // ***********************************************************
    // Here is where you'll do the partition part of Quicksort:
    //   - Choose a pivot
    //   - Partition the unsorted list into two piles
    // ***********************************************************
    Card pivot = unsorted.poll();  // edit this!
    for (Card element:unsorted){
      if (element.compareTo(pivot)<0){
          smaller.addLast(element);
        }else{
          bigger.addLast(element);
        }
      }
    //register the partitions with the recorder

    // This will hold the assembled result
    CardPile result = new CardPile(2,2);
    
    
    // ***********************************************************
    // Here is where you'll do the remaining work of Quicksort:
    //   - Make recursive calls on the partitions
    //   - Assemble the sorted results into a single pile
    // ***********************************************************

      result.addAll(sort(smaller));
      result.addLast(pivot);
      result.addAll(sort(bigger));

    // return the sorted result here
    return result;
    }
  }
}
