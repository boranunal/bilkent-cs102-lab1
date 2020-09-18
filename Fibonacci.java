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
