public class RadixShort {

    static void print(int arry[]){
        for(int i : arry){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    static int findMax(int arry[]){
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < arry.length; i++){
            if(arry[i] > max){
                max = arry[i];
            }
        }
        return max;
    }

    static void countShort(int arry[],int place){

        int [] frq = new int[10];
        int [] out = new int[arry.length];

        for(int i = 0; i < arry.length; i++){
            frq[(arry[i]/place)%10]++;
        }

        for(int i = 1; i < frq.length; i++){
            frq[i] += frq[i-1];
        }

        for(int i = arry.length-1; i >= 0; i--){
            int idx = frq[(arry[i]/place)%10] - 1;
            out[idx] = arry[i];
            frq[(arry[i]/place) % 10]--;
        }

        for(int i = 0; i < arry.length; i++){
            arry[i] = out[i];
        }
    }

    static void radix(int arry[]){
        int max = findMax(arry);

        for(int place = 1; max/place > 0; place *= 10){
            countShort(arry,place);
        }
    }
    
    public static void main(String[] args) {
        int arry [] = {170,45,75,90,802,2};
        System.out.println("Before Shorting ");
        print(arry);
        radix(arry);
        System.out.println("After Shorting ");
        print(arry);
    }
}