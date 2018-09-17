package lesson6;

import lesson4.Cat;

public class Homework {
    public static void main(String[] args) {
        Tree[] forest = new Tree[10];
        int balanced = 0;
        for (int i = 0; i < forest.length; i++) {
            forest[i] = new Tree();
            for (int j = 1; j <= 100; j++) {
                forest[i].insert(new Cat( getRand(), "cat "+j ));
            }
            //forest[i].displayTree();
            forest[i].isBalanced();
            if(forest[i].is_balanced) balanced++;
            System.out.println("###########################");
        }
        System.out.println("Несбалансированных="+( 100- Math.round( (float)balanced/(float)forest.length*100 ) )+"%" );
    }

    public static int getRand() {
        return (int) (Math.random()*201-100);
    }
}
