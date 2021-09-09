package sort;

public abstract class Sort {
    int[] arr;

    public Sort(int[] arr){
        this.arr = arr;
        sort();
    }

    public abstract void sort();

    public void print(){
        System.out.println();
        System.out.println("sorted by " + this.getClass().getSimpleName());
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        System.out.println();
    }
}
