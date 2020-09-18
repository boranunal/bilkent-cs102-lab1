class CharBag {
  int size = 4;
  int elCount = 0;
  char[] str = new char[size];
  public void add(char c) {
    if(elCount == size)
      expand();
    str[elCount] = c;
    ++elCount;
  }
  protected void expand() {
    char[] tempCArr = new char[size*2];
    System.arraycopy(str, 0, tempCArr, 0, size);
    size *= 2;
    str = tempCArr;
  }
}
