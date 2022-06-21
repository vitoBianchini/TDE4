import java.util.Stack;

//public class Quicksort {

  //   // method to find the partition position
  // static int partition(int array[], int low, int high) {
    
  //   // choose the rightmost element as pivot
  //   int pivot = array[high];
    
  //   // pointer for greater element
  //   int i = (low - 1);

  //   // traverse through all elements
  //   // compare each element with pivot
  //   for (int j = low; j < high; j++) {
  //     if (array[j] <= pivot) {

  //       // if element smaller than pivot is found
  //       // swap it with the greatr element pointed by i
  //       i++;

  //       // swapping element at i with element at j
  //       int temp = array[i];
  //       array[i] = array[j];
  //       array[j] = temp;
  //     }

  //   }

  //   // swapt the pivot element with the greater element specified by i
  //   int temp = array[i + 1];
  //   array[i + 1] = array[high];
  //   array[high] = temp;

  //   // return the position from where partition is done
  //   return (i + 1);
  // }

  // static void quickSort(int array[], int low, int high) {
  //   if (low < high) {

  //     // find pivot element such that
  //     // elements smaller than pivot are on the left
  //     // elements greater than pivot are on the right
  //     int pi = partition(array, low, high);
      
  //     // recursive call on the left of pivot
  //     quickSort(array, low, pi - 1);

  //     // recursive call on the right of pivot
  //     quickSort(array, pi + 1, high);
  //   }
  // }

//}


// Quick sort in Java

// import java.util.Arrays;

// class Quicksort {

//   // method to find the partition position
//   static int partition(int array[], int low, int high) {
    
//     // choose the rightmost element as pivot
//     long pivot = array[high];
    
//     // pointer for greater element
//     int i = (low - 1);

//     // traverse through all elements
//     // compare each element with pivot
//     for (int j = low; j < high; j++) {
//       if (array[j] <= pivot) {

//         // if element smaller than pivot is found
//         // swap it with the greatr element pointed by i
//         i++;

//         // swapping element at i with element at j
//         int temp = array[i];
//         array[i] = array[j];
//         array[j] = temp;
//       }

//     }

//     // swapt the pivot element with the greater element specified by i
//     int temp = array[i + 1];
//     array[i + 1] = array[high];
//     array[high] = temp;

//     // return the position from where partition is done
//     return (i + 1);
//   }

//   static void quickSort(int array[], int low, int high) {
//     if (low < high) {

//       // find pivot element such that
//       // elements smaller than pivot are on the left
//       // elements greater than pivot are on the right
//       int pi = partition(array, low, high);
      
//       // recursive call on the left of pivot
//       quickSort(array, low, pi - 1);

//       // recursive call on the right of pivot
//       quickSort(array, pi + 1, high);
//     }
//   }
// }

// // Main class
// class Main {
//   public static void main(String args[]) {

//     int[] data = { 8, 7, 2, 1, 0, 9, 6 };
//     System.out.println("Unsorted Array");
//     System.out.println(Arrays.toString(data));

//     int size = data.length;

//     // call quicksort() on array data
//     Quicksort.quickSort(data, 0, size - 1);

//     System.out.println("Sorted Array in Ascending Order: ");
//     System.out.println(Arrays.toString(data));
//   }
// }

class Quicksort {
  static void quickSort(int[] vetor) {
    Stack<Integer> stack = new Stack<>();
    stack.push(0);
    stack.push(vetor.length);

    while (!stack.isEmpty()) {
        int end = stack.pop();
        int start = stack.pop();
        if (end - start < 2) {
            continue;
        }
        int p = start + ((end - start) / 2);
        p = separarQuicksort(vetor, p, start, end);

        stack.push(p + 1);
        stack.push(end);

        stack.push(start);
        stack.push(p);
    }
  }

static private int separarQuicksort(int[] vetor, int p, int inicio, int fim) {
    int l = inicio;
    int h = fim - 2;
    int piv = vetor[p];
    troca(vetor, p, fim - 1);
    while (l < h) {
        if (vetor[l] < piv) {
            l++;
        } else if (vetor[h] >= piv) {
            h--;
        } else {
            swap(vetor, l, h);
        }
    }
    int idx = h;
    if (vetor[h] < piv) {
        idx++;
    }
    swap(vetor, fim - 1, idx);
    return idx;
}
private static void troca(int[] arr, int i, int j) {
  int temp = arr[i];
  arr[i] = arr[j];
  arr[j] = temp;
}

private static void swap(int[] a, int i, int j) {
  int temp = a[i];
  a[i] = a[j];
  a[j] = temp;
}

}