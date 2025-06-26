class CountAlgo {

    static void print(int arry[]){
        for(int i : arry){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    static int findMax(int arry[]) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arry.length; i++) {
            if (arry[i] > max)
                max = arry[i];
        }
        return max;
    }

    /*static void fun(int arry[]) {
        int[] frq = new int[findMax(arry) + 1];

        for (int i = 0; i < arry.length; i++) {
            frq[arry[i]]++;
        }

        int k = 0;
        for (int i = 0; i < frq.length; i++) {
            for (int j = 0; j < frq[i]; j++) {
                arry[k++] = i;
            }
        }
    } */

    static void fun(int arry[]) {
        int[] frq = new int[findMax(arry) + 1];
        int out[] = new int[arry.length];

         for (int i = 0; i < arry.length; i++) {
            frq[arry[i]]++;
        }

        for(int i = 1; i < frq.length; i++){
            frq[i] += frq[i-1];
        }

        for(int i = arry.length-1; i >= 0; i--){
           int idx = frq[arry[i]]-1;
           out[idx] = arry[i];
           frq[arry[i]]--;
        }
        
        for(int i = 0; i < out.length; i++){
            arry[i] = out[i];
        }
    }

    public static void main(String[] args) {
        int arry[] = { 4, 3, 1, 5, 3, 1, 3, 5 };
        print(arry);
        fun(arry);
        print(arry);
    }
}