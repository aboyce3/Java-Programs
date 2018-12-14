import java.util.stream.*;
import java.util.*;
public class QuickSort{
  
    private static void swap(int arr[], int f, int s){
	int temp = arr[f];
	arr[f] = arr[s];
	arr[s] = temp;
    }

    private static int partition(int arr[], int first, int last){
	int pivot = arr[first];
	int i = first;
	int j = last;
	while(i <= j){
	    while(i <= j && arr[i] <= pivot)i++;
	    while(i <= j && arr[j] > pivot)j--;
	    if(i <= j){
		swap(arr, i, j);

	    }
	}
	
	swap(arr,first,i-1);
	return i-1;
}
  
    private static void quickSort(int arr[], int first, int last){
	if (first < last){
	    int index = partition(arr, first, last);
            quickSort(arr, first, index-1);
            quickSort(arr, index+1, last);
	}
    }
  
    public static void sort(int[] arr) {
	quickSort(arr, 0, arr.length-1);
    }
  
    public static void main(String[] args){
	Random r = new Random();
	int[] arr = new int[40000];
        for(int i = 0; i < 40000; i++){
	    arr[i] = r.nextInt(60000);
	}
	
	System.out.print("Random List:");
	IntStream arrStream = Arrays.stream(arr);
	System.out.print("\n");
	//arrStream.forEach(e -> System.out.print(e + " "));
	System.out.println("\n");
	long start = System.currentTimeMillis();
	sort(arr);
	long end = System.currentTimeMillis();
	System.out.println("Total time for a random list: " + (end-start));
	
	System.out.println("Random Sorted:");
	arrStream = Arrays.stream(arr);
	//arrStream.forEach(e -> System.out.print(e + " "));
	System.out.println("\n");
	
	System.out.println("Backwards List:");
	int[] arr2 = new int[40000];
	int j = arr2.length;
	    for(int i = 0; i < arr2.length; i++){
		arr2[i] = j--;
	    }
        arrStream = Arrays.stream(arr2);
        //arrStream.forEach(e -> System.out.print(e + " "));
	sort(arr2);
	System.out.println("\n");
	
	System.out.println("Backwards Sorted:");
	arrStream = Arrays.stream(arr2);
        for(int i = 0; i < arr2.length; i++)
	System.out.print(arr2[i] + " " );
	
	
    }
  
}
