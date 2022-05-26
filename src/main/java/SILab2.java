import java.util.ArrayList;
import java.util.List;

public class SILab2 {

    public static List<String> function(List<String> list) {
        if (list.size() <= 0) { // 1
            throw new IllegalArgumentException("List length should be greater than 0"); // 2
        } // 3
        int n = list.size();// 4
        int rootOfN = (int) Math.sqrt(n);// 5
        if (rootOfN * rootOfN  != n) { // 6
            throw new IllegalArgumentException("List length should be a perfect square"); // 7
        } // 8
        List<String> numMines = new ArrayList<>(); //9
        for (int i = 0; i < n; i++) { // 10
            if (!list.get(i).equals("#")) { //11
                int num = 0; //12
                if ( (i % rootOfN != 0 && list.get(i - 1).equals("#")) || (i % rootOfN != rootOfN - 1 && list.get(i + 1).equals("#")) ) { //13
                    if ( (i % rootOfN != 0 && list.get(i - 1).equals("#")) && (i % rootOfN != rootOfN - 1 && list.get(i + 1).equals("#")) ){ //14
                        num += 2; //15
                    }//16
                    else { //17
                        num  += 1;//18
                    } // 19
                }//20
                if (i - rootOfN >= 0 && list.get(i - rootOfN).equals("#")){//21
                    num++;//22
                }//23
                if (i + rootOfN < n && list.get(i + rootOfN).equals("#")){//24
                    num++;//25
                }//26
                numMines.add(String.valueOf(num));//27
            }//28
            else {//29
                numMines.add(list.get(i));//30
            }//31
        }//32
        return numMines;//33
    }//34
}
