public class SuperArray {
  private String[] array;
  private int size = 0;

  public SuperArray() {
    array = new String[10];
    size = 10;
  }

  public void clear() {
    array = new String[0];
    size = 0;
  }

  private boolean isEmpty() {
    if (size == 0) {
      return true;
    }
    return false;
  }

  public boolean add(String a) {
    if (array[array.length-1]==null) {
      array[size-1] = a;
      return true;
    }
    return false;
  }

  public String toString() {
    String ans = "[";
    for (int i=0; i<size-1;i++) {
      ans = ans + array[i] + ",";
    }
    ans = ans + array[size-1] + "]";
    return ans;
  }

  public String toStringDebug() {
    String ans = "[";
    for (int i=0; i<array.length-1;i++) {
      ans = ans + array[i] + ",";
    }
    ans = ans + array[array.length-1] + "]";
    return ans;
  }

  public String get(int i) {
    if (i < 0 || i >= size) {
      return null;
    }
    return array[i];
  }

  public String set(int i, String a) {
    if (i < 0 || i >= size) {
      return null;
    }
    String original = array[i];
    array[i] = a;
    return original;
  }

  
}
