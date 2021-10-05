package BST;

class Interval{
    int low, high;
}
class ITNode{
    Interval i;
    int max;
    ITNode left, right;
}



public class ConflictAppintment {

    static Interval newNode(int l, int h){
        Interval temp = new Interval();
        temp.low = l;
        temp.high = h;
        return temp;
    }

    static ITNode newNode(Interval i){
        ITNode temp = new ITNode();
        temp.i = i;
        temp.max = i.high;
        temp.left = temp.right = null;
        return temp;
    }

    static ITNode insert(ITNode root, Interval i){
        if(root == null){
            return newNode(i);
            
        }

        int l = root.i.low;

        if(i.low < l){
            root.left = insert(root.left, i);
        }else{
            root.right = insert(root.right, i);
        }

        if(root.max < i.high)
            root.max = i.high;

        return root;    
    }

    static boolean doOverlap(Interval i1, Interval i2){
        if(i1.low < i2.high && i2.low < i2.high){
            return true;
        }

        return false;
    }
    static Interval overlapSearch(ITNode root, Interval i){
        if(root == null){
            return null;
        }

        if(doOverlap(root.i, i))
            return root.i;

        if(root.left != null && root.left.max >= i.low)
            return overlapSearch(root.left, i);


        return overlapSearch(root.right, i);
    }
    
    static void printConflict(Interval appt[], int n){
        ITNode root = null;
        root = insert(root, appt[0]);

        for(int i = 1; i< n; i++){
            Interval res = overlapSearch(root, appt[i]);

            if(res != null){
                System.out.print(appt[i].low +","+appt[i].high+" --- "+ res.low+","+res.high+"\n");
            }

            root = insert(root,appt[i]);
        }
    }
    public static void main(String[] args) {
        Interval appt[] = new Interval[6];
        appt[0] = newNode(1,5);
        appt[1] = newNode(3,7);
        appt[2] = newNode(2,6);
        appt[3] = newNode(10,15);
        appt[4] = newNode(5,6);
        appt[5] = newNode(4,100);

        int n = appt.length;
        
        System.out.print("Folllowing are the conflicting interviews");
        printConflict(appt, n);

    }
}