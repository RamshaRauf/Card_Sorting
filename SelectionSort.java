/**
 *  Program sorts cards in Selection Sort Algorithm with graphics
 *
 *  @author Ramsha Rauf
 *  @version March 2022
 */
public class SelectionSort {
  /**
  *Sorts the list in selection Sort algorithm
  *@param unsorted cardpile and record 
  *@return a sorted cardpile
  */
  public static CardPile sort(CardPile unsorted, SortRecorder record) {
    
    // register the starting configuration with the recorder
    record.add(unsorted);

    // Here is the result list you will be creating
    CardPile sorted = new CardPile(2,2);
  
    // ***********************************************************
    // Here is where you'll do the "work" of SelectionSort:
    //   - Use sorted to store the "sorted portion"
    //   - Don't forget to register the new state with the
    //     recorder after each card is transferred:
    //        record.next();        // tell it this is a new step
    //        record.add(sorted);   // the sorted pile
    //        record.add(unsorted); // the unsorted pile
    // ***********************************************************
    while (unsorted.size() > 0){
      Card smallest = unsorted.getFirst();
      for (Card c : unsorted){
        if (smallest.compareTo(c) > 0){
          smallest=c;
        } 
      }
      unsorted.remove(smallest);
      sorted.addLast(smallest);
      record.next();     
      record.add(sorted);  
      record.add(unsorted);
    }
    // return the sorted result here
    return sorted;
  }
}
