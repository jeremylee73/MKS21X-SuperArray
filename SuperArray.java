public class SuperArray {
  private String[] array;
  private int size = 0;

  public SuperArray() {
    array = new String[10];
  }

  public SuperArray(int startingCapacity) {
    if (startingCapacity < 0) {
      throw new IllegalArgumentException();
    }
    array = new String[startingCapacity];
  }

  public void clear() {
    array = new String[0];
    size = 0;
  }

  public int size() {
    return size;
  }

  public boolean isEmpty() {
    if (size == 0) {
      return true;
    }
    return false;
  }

  public boolean add(String a) {
    if (size() == array.length) {
      resize();
    }
    array[size()] = a;
    size++;
    return true;
  }

  public String toString() {
    String ans = "[";
    for (int i=0; i<size-1;i++) {
      ans = ans + array[i] + ", ";
    }
    ans = ans + array[size-1] + "]";
    return ans;
  }

  public String toStringDebug() {
    String ans = "[";
    for (int i=0; i<array.length;i++) {
      ans = ans + array[i] + ", ";
    }
    if (!ans.equals("[")) {
        ans = ans.substring(0, ans.length()-2);
    }
    ans += "]";
    return ans;
  }

  public String get(int i) {
    if (i < 0 || i >= size) {
      throw new IndexOutOfBoundsException();
    }
    return array[i];
  }

  public String set(int i, String a) {
    if (i < 0 || i >= size) {
      throw new IndexOutOfBoundsException();
    }
    String original = array[i];
    array[i] = a;
    return original;
  }

  private void resize() {
    String[] newArray = new String[(array.length*2) + 1];
    for (int i=0; i<size; i++) {
      newArray[i] = array[i];
    }
    array = newArray;
  }

  public boolean contains(String target) {
    for (int i=0; i<size; i++) {
      if (array[i].equals(target)) {
        return true;
      }
    }
    return false;
  }

  public int indexOf(String target) {
    for (int i=0; i<size; i++) {
      if (array[i].equals(target)) {
        return i;
      }
    }
    return -1;
  }

  public int lastIndexOf(String target) {
    for (int i=size-1; i>=0; i--) {
      if (array[i].equals(target)) {
        return i;
      }
    }
    return -1;
  }

  public void add(int index, String a) {
    if (index >= 0 && index <= size) {
      if (size() == array.length) {
        resize();
      }
      for (int i=size()-1; i>=index; i--) {
        array[i+1] = array[i];
      }
      array[index] = a;
      size++;
    } else {
      throw new IndexOutOfBoundsException();
    }
  }

  public String remove(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException();
    }
    String original = array[index];
    String[] ans = new String[array.length];
    for (int i=0; i<index; i++) {
      ans[i] = array[i];
    }
    for (int i=index; i<size; i++) {
      ans[i] = array[i+1];
    }
    array = ans;
    size -= 1;
    return original;
  }

  public boolean remove(String target) {
    String[] ans = new String[array.length];
    boolean check = false;
    for (int i=0; i<indexOf(target); i++) {
      ans[i] = array[i];
    }
    for (int i=indexOf(target); i<size; i++) {
      if (array[i].equals(target)) {
        size -= 1;
        check = true;
      }
      ans[i] = array[i+1];
    }
    array = ans;
    return check;
  }

}
