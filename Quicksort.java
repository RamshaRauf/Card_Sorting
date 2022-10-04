/**
 *  Program sorts cards in QuickSort Algorithm with graphics
 *
 *  @author Ramsha Rauf
 *  @version March 2022
 */
public class Quicksort {
  /**
  *Sorts the list in quick Sort algorithm
  *@param unsorted cardpile and record 
  *@return a sorted cardpile
  */
  public static CardPile sort(CardPile unsorted, SortRecorder record) {
    
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
    record.next();
    record.add(smaller);
    record.add(pivot);
    record.add(bigger);
    

    // This will hold the assembled result
    CardPile result = new CardPile(2,2);
    
    
    // ***********************************************************
    // Here is where you'll do the remaining work of Quicksort:
    //   - Make recursive calls on the partitions
    //   - Assemble the sorted results into a single pile
    // ***********************************************************

      result.addAll(sort(smaller,record));
      result.addLast(pivot);
      result.addAll(sort(bigger,record));
    // record the sorted result
    record.next();
    record.add(result);
    
    
    // return the sorted result here
    return result;
    }
  }
}
