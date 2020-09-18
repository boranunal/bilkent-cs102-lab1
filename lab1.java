import java.util.Scanner;

class CharBag {
  int size = 4;
  int elCount = 0;
  char[] str = new char[size];
  void add(char c) {
    if(elCount == size)
      expand();
    str[elCount] = c;
    ++elCount;
  }
  private void expand() {
    char[] tempCArr = new char[size*2];
    System.arraycopy(str, 0, tempCArr, 0, size);
    size *= 2;
    str = tempCArr;
  }
}
class IntBag {
  int[] bag, arr;
  int size;
  int elCount = 0;
  int r;
  IntBag() {
    size = 4;
    arr = new int[size];
  }
  IntBag(int s) {
    size = s;
    arr = new int[size];
  }
  void add(int val){
    if(elCount == size)
      expand();
    arr[elCount] = val;
    ++elCount;
    if(elCount == size)
      expand();
    arr[elCount] = -1;
  }
  private void expand() {
    int[] tempArr = new int[size*2];
    System.arraycopy(arr, 0, tempArr, 0, size);
    size *= 2;
    arr = tempArr;
  }

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
  String toStr() {
    int q;
    CharBag bruh = new CharBag();
    for(int i = 0; i < elCount; ++i){
      CharBag temp = new CharBag();
      q = arr[i];
      do {
        temp.add((char) (q % 10 + '0'));
        q /= 10;
      } while (q != 0);
      for(int j = temp.elCount-1; 0 <= j; --j)
        bruh.add(temp.str[j]);
      bruh.add(' ');
    }
    String string = new String(bruh.str);
    return string;
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
  void removeAll(int x) {
    int i = 0;
    while(i < elCount) {
      if(arr[i] == x)
        arr[i] = arr[(elCount--)-1];
      else ++i;
    }
  }
}

class Main{
  public static void main(String[] args) {
    IntBag object = new IntBag();
    int opt = 0;
    int val;
    while(true) {
      System.out.println("1.Create a new empty collection(any previous values are lost!)\n2.Read a set of positive values into the collection (use zero to indicate all the values have been entered.)\n3.Print the collection of values.\n4.Add a value to the collection of values at a specified location.\n5.Remove the value at a specified location from the collection of values.\n6.Remove all instances of a value within the collection* (see note below).\n7.Quit the program.\n");
      Scanner input = new Scanner(System.in);
      opt = input.nextInt();
      input.close();
      if (opt == 7) break;
      switch (opt) {
        case 1:
          IntBag tempobj = new IntBag();
          object = tempobj;
          break;
        case 2:
          Scanner input = new Scanner(System.in);
          while(true) {
            val = input.nextInt();
            if(val == 0) break;
            object.add(val);
          }
          break;
        case 3:
          System.out.println(object.toStr());
          break;
        case 4:
          System.out.println("Enter value - index:  ");
          object.addTo(Menu.readInt(),Menu.readInt());
          break;
        case 5:
          System.out.println("Enter index:  ");
          object.removeAt(Menu.readInt());
          break;
        case 6:
          System.out.println("Enter the value to be removed:  ");
          object.removeAll(Menu.readInt());
         break;
        default:
          System.out.println("Enter a valid number");
      }
    }
  }
}

class Fibonacci {
  public static void fibonacci(int range) {
    IntBag fibo = new IntBag();
    int j = 0;
    range -= 2;
    fibo.add(0);
    fibo.add(1);
    while(j<range)
      fibo.add(fibo.arr[j] + fibo.arr[(j++)+1]);
    System.out.println(fibo.toStr());
  }
}
