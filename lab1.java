import java.util.Scanner;
class Array {
  public static void prIntArray(int[] arr){
    for(int i : arr)
      System.out.print(i+" ");
    System.out.println("\n");
  }

}
class IntBag {
  int[] bag, arr;
  int size = 4;
  int elCount = 0;
  int r;
  IntBag() {
    arr = new int[size];
  }
  void add(int val){
    if(elCount == size)
      expand();
    arr[elCount] = val;
    ++elCount;
  }
  void expand() {
    int[] tempArr = new int[size*2];
    System.arraycopy(arr, 0, tempArr, 0, size);
    size *= 2;
    arr = tempArr;
  }
  void contract() {
    int[] tempArr = new int[size/2];
    System.arraycopy(arr, 0, tempArr, 0, elCount);
    size /= 2;
    arr = tempArr;
  }
  void addTo(int value, int index) {
    int tempv1, tempv2;
    if(elCount < index){
      System.out.println("addTo: given index is not within boundaries");
      return;
    }
    if(elCount == size)
      expand();
    int l = index;
    tempv1 = arr[l];
    arr[l] = value;
    ++l;
    while(l < elCount) {
      tempv2 = arr[l];
      arr[l] = tempv1;
      tempv1 = tempv2;
      ++l;
    }
    arr[l] = tempv1;
    ++elCount;
  }
  int removeAt(int index){
    if(index < elCount){
      r = arr[index];
      arr[index] = arr[elCount-1];
      arr[elCount-1] = 0;
      --elCount;
      if(elCount == size/2)
        contract();
      return r;
    }
    else
      System.out.println("removeAt: given index is not within boundaries");
      return -1;

  }
  boolean search(int i) {
    for(int n = 0; n < elCount; ++n) {
      if(arr[n] == i)
        return true;
    }
    return false;
  }
  int size() {
    return elCount;
  }
  int valueAt(int index) {
    if(index < elCount)
      return arr[index];
    else
      System.out.println("valueAt: given index is not within boundaries");
      return -1;
  }
}

class Main{
  public static void main(String[] args) {
    IntBag test = new IntBag();
    Scanner scan = new Scanner(System.in);
    int var;
    while(true) {
      var = scan.nextInt();
      if(var == 0)
        break;
      test.add(var);
    }

    Array.prIntArray(test.arr);
    test.addTo(9,2);
    Array.prIntArray(test.arr);
    int removed = test.removeAt(2);
    Array.prIntArray(test.arr);
    System.out.println("removed: " + removed);
    System.out.println("array size: " + test.size());
    System.out.println("value at index 2: " + test.valueAt(2));
    if(test.search(7))
      System.out.println("array contains 7");
    else
      System.out.println("array does not contain 7");

  }
}
