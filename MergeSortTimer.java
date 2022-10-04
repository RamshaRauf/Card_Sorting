/**
 *  Program sorts cards in MergeSort Algorithm ommiting graphics
 *
 *  @author Ramsha Rauf
 *  @version March 2022
 */
import java.util.ArrayDeque;
public class MergeSortTimer {
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
  *Sorts the list in mergeSort algorithm
  *@param unsorted cardpile and record 
  *@return a sorted cardpile
  */
  public static CardPile sort(CardPile unsorted) {
    
    ArrayDeque<CardPile> queue = new ArrayDeque<CardPile>();
  
    
    // return the sorted result here
    //add each element of the unsorted list in a singleton cardPile
    for (Card element:unsorted){
      Card[] oneelement = new Card[]{element}; 
      CardPile singleton = new CardPile(oneelement,2,2);
      queue.addLast(singleton);
    }
    
    while(queue.size()>1){
    CardPile list1 = queue.removeFirst();
    CardPile list2 = queue.removeFirst();
    CardPile mergedList = mergeTwoLists(list1, list2);
    queue.addLast(mergedList);
    }

    return queue.remove();
  }

  /**
  *Merges and sorts two lists into 1 merged list
  *@param 2 sorted lists 
  *@return a merged and sorted list 
  */
  public static CardPile mergeTwoLists(CardPile list1, CardPile list2){
    CardPile mergedList = new CardPile(2,2);
    while (list1.size()>0 && list2.size()>0){
      Card list1First = list1.peek();
      Card list2First = list2.peek();
 
      if (list1First.compareTo(list2First) < 0){
        list1.remove(list1First);
        mergedList.addLast(list1First);
      }else{
        list2.remove(list2First);
        mergedList.addLast(list2First);
      }
    }

    if (list1.size()==0){
      while(list2.peek()!=null){
        mergedList.addLast(list2.removeFirst());
      }
    }else if (list2.size()==0){
      while(list1.peek()!=null){
        mergedList.addLast(list1.removeFirst());
      }
    }
    return mergedList;
  }
}
