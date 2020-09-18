import java.util.Scanner;

class Main{
  public static void main(String[] args) {
    IntBag object = new IntBag();
    int opt = 0;
    int val, index;
    Scanner input = new Scanner(System.in);
    while(true) {
      System.out.println("1.Create a new empty collection(any previous values are lost!)\n2.Read a set of positive values into the collection (use zero to indicate all the values have been entered.)\n3.Print the collection of values.\n4.Add a value to the collection of values at a specified location.\n5.Remove the value at a specified location from the collection of values.\n6.Remove all instances of a value within the collection* (see note below).\n7.Quit the program.\n");

      opt = input.nextInt();
      if (opt == 7) break;
      switch (opt) {
        case 1:
          IntBag tempobj = new IntBag();
          object = tempobj;
          break;
        case 2:
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
          System.out.println("Enter value then index:  ");
          val = input.nextInt();
          index = input.nextInt();
          object.addTo(val, index);
          break;
        case 5:
          System.out.println("Enter index:  ");
          index = input.nextInt();
          object.removeAt(index);
          break;
        case 6:
          System.out.println("Enter the value to be removed:  ");
          val = input.nextInt();
          object.removeAll(val);
         break;
        default:
          System.out.println("Enter a valid number");
      }
    }
  }
}
