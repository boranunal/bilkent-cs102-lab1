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
  public void add(int val){
    if(elCount == size)
      expand();
    arr[elCount] = val;
    ++elCount;
    if(elCount == size)
      expand();
    arr[elCount] = -1;
  }
  protected void expand() {
    int[] tempArr = new int[size*2];
    System.arraycopy(arr, 0, tempArr, 0, size);
    size *= 2;
    arr = tempArr;
  }
  public void addTo(int value, int index) {
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
  public int removeAt(int index){
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
  public boolean search(int i) {
    for(int n = 0; n < elCount; ++n) {
      if(arr[n] == i)
        return true;
    }
    return false;
  }
  public String toStr() {
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
  public int size() {
    return elCount;
  }
  public int valueAt(int index) {
    if(index < elCount)
      return arr[index];
    else
      System.out.println("valueAt: given index is not within boundaries");
      return -1;
  }
  public void removeAll(int x) {
    int i = 0;
    while(i < elCount) {
      if(arr[i] == x)
        arr[i] = arr[(elCount--)-1];
      else ++i;
    }
  }
}
