/**
 *  Program sorts cards in InsertionSort Algorithm with graphics
 *
 *  @author Ramsha Rauf
 *  @version March 2022
 */
import java.util.*;
public class InsertionSort {
  
  /**
  *Sorts the list in insertion Sort algorithm
  *@param unsorted cardpile and record 
  *@return a sorted cardpile
  */
  public static CardPile sort(CardPile unsorted, SortRecorder record) {
    
    // register the starting configuration with the recorder
    record.add(unsorted);

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
      record.next();     
      record.add(sorted);  
      record.add(unsorted);
    }
    return sorted;
  }
}


     //previous attempts
    //Integer location = 0;
    // Card firstCard;
    // ListIterator <Card> position = sorted.listIterator();
    // while(unsorted.size() > 0){
    //   firstCard = unsorted.removeFirst();
    //   while(position.hasNext()){
    //     Card c = position.next();
    //     if(firstCard.compareTo(c)>0){
    //       sorted.addLast(firstCard);
    //       unsorted.remove(firstCard);
    //     }else{
    //       unsorted.remove(firstCard);
    //       position.add(firstCard);
    //       break;
    //     }
    //   }
    //   record.next();     
    //   record.add(sorted);  
    //   record.add(unsorted);

    // }
    // return sorted;

    // return the sorted result here
    // Integer location = 0;
    // Card firstCard;
    // while(unsorted.size() > 0){
    //   firstCard = unsorted.removeFirst();
    //   for (Card c : sorted){
    //     if (firstCard.compareTo(c) < 0){
    //       location = sorted.indexOf(c);
    //       unsorted.remove(firstCard);
    //       break;
    //     }else{
    //       location = sorted.size();
    //     }
    //   }
    //   sorted.add(location, firstCard);
    //   record.next();     
    //   record.add(sorted);  
    //   record.add(unsorted);

    // }
    // return sorted;

    
    // boolean inserted = false;
    // Card insertCardBefore = sorted.peekLast();

    // while (unsorted.size()>0){
    //   Card firstCard = unsorted.removeFirst();
    //   for (Card c :sorted){
    //     if (firstCard.compareTo(c)<0){
    //       //first card is smaller then c so insert firstcard before c
    //       insertCardBefore = c;
    //       inserted = true;
    //       break;
    //     }else{
    //       insertCardBefore = sorted.peekLast();
    //       inserted =false;
    //     }
    //   }
    //   if (inserted){
    //     sorted.insertBefore(firstCard,insertCardBefore);
    //     unsorted.remove(firstCard);
    //   }else{
    //     sorted.addLast(firstCard);
    //     unsorted.remove(firstCard);
    //   }
    //   record.next();     
    //   record.add(sorted);  
    //   record.add(unsorted);
    // }
    // return sorted;

    //return the sorted result here
   

    // while(unsorted.size() > 0){
    //   Card firstCard = unsorted.removeFirst();

    //   if (sorted.size()!=0 && sorted.getFirst().compareTo(firstCard)>0){
    //     sorted.addFirst(firstCard);
    //     System.out.println("1 " +sorted);
    //   }else if(sorted.size()!=0 && sorted.getLast().compareTo(firstCard)<0) {
    //     sorted.addLast(firstCard);
    //     System.out.println("2 " +sorted);
    //   }else{
    //      ListIterator<Card> iter= sorted.listIterator(0);
    //     while(iter.hasNext()){
    //     Card c = iter.next();
    //     if (firstCard.compareTo(c) < 0){
    //       iter.previous();
    //       iter.add(firstCard);
    //       System.out.println("3  " +sorted);
    //       break;
       
    //     }

    //     }
    //     }
    //   System.out.println(sorted);
    //   record.next();     
    //   record.add(sorted);  
    //   record.add(unsorted);

    // }
    // return sorted;