public static void printALlSumEqualsK(int index, ArrayList<Integer> ds, int[] arr,int sums,int k){

        if(index==arr.length){
            if(sums==k){
                for(int i: ds){
                    System.out.print(i + " ");
                }
                System.out.println();

            }
            return;
        }

//        take
        ds.add(arr[index]);
        sums+=arr[index];
        printALlSumEqualsK(index+1,ds,arr,sums,k);


        ds.remove(ds.size()-1);
        sums-=arr[index];
        //        not take
        printALlSumEqualsK(index+1,ds,arr,sums,k);


    }
    public static void main(String[] args) {
        int[] arr = {3,1,2};
        int k = 3;
        ArrayList<Integer> ds = new ArrayList<>();
//        printAllSub(0,ds, arr);
        printALlSumEqualsK(0, ds, arr, 0,k);
    }
