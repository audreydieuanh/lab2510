import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * A simple way to sort arrays using merge sort.
 *
 * @author Shuta Shibue
 * @author Audrey Trinh
 * @author Samuel A. Rebelsky
 */
public class MergeSorter {

  // +------------------+--------------------------------------------
  // | Exported methods |
  // +------------------+

  /**
   * Sort an array using the merge sort algorithm.
   */
  public static <T> void sort(T[] vals, Comparator<? super T> comparator) {
    int midIndex = vals.length / 2;
    int rightIndex = 0;
    int leftIndex = midIndex;
    // sort left half and then right half
    sort(vals, comparator);
    merge(vals, rightIndex, midIndex, leftIndex, comparator);
  
  } // sort

  // +-----------------+---------------------------------------------
  // | Local utilities |
  // +-----------------+

  /**
   * Merge the values from positions [lo..mid) and [mid..hi) back into
   * the same part of the array.
   *
   * Preconditions: Each subarray is sorted accorting to comparator.
   */
  @SuppressWarnings("unchecked")
  static <T> void merge(T[] vals, int lo, int mid, int hi, Comparator<? super T> comparator) {
    int loi = lo;
    int hii = mid;
    ArrayList<T> temp = new ArrayList<T>();

    while (loi < mid && hii < hi) {
      if(comparator.compare(vals[loi], vals[hii]) > 0){
        temp.add(vals[hii]);
        hii++;
      }
      else{
        temp.add(vals[loi]);
        loi++;
      }
    }
    if(loi == mid){
      while(hii < hi){
        temp.add(vals[hii]);
        hii++;
      }
    }
    else if(hii == mid){
      while(hii < hi){
        temp.add(vals[loi]);
        loi++;
      }
    }
    vals = (T[]) temp.toArray().clone();
  } // merge

} // class MergeSorter
