import java.util.ArrayList;
import java.util.Collections;

public class BucketShort {

    static void print(float arry[]){
        for(float i : arry){
            System.out.print(i + " ");
        }
    }

    static void bucketShort(float arry[]){

        ArrayList<Float>[] bucket = new ArrayList[arry.length];

        for(int i = 0; i < arry.length; i++){
            bucket[i] = new ArrayList<Float>();
        }

        for(int i = 0; i < arry.length; i++){
            int bucketIndex = (int) arry[i] * arry.length;
            bucket[bucketIndex].add(arry[i]);
        }

        for (int i = 0; i < bucket.length; i++) {
            Collections.sort(bucket[i]);
        }

        int Idx = 0;

        for(int i = 0; i < bucket.length; i++){
            ArrayList<Float> curr = bucket[i];
            for(int j = 0; j < curr.size(); j++){
                arry[Idx++] = curr.get(j);
            }
        }

    }
    
    public static void main(String[] args) {
        float arry [] = {0.5f, 0.4f, 0.3f,0.2f,0.1f};
        System.out.println("Before Sort ");
        print(arry);
        bucketShort(arry);
        System.out.println("\nAfter Sort");
        print(arry);
    }
}
