package lesson6;

public class Bag {
    static Item[] bag;
    public static void sort() {
        Item tmp;
        for (int i = bag.length-1; i >= 0; i--) {
            float unitPriceI = bag[i].price/bag[i].weight;

            for (int j = bag.length-1; j>0; j--) {


                float unitPriceJ = bag[j-1].price/bag[j-1].weight;
                //System.out.println(unitPriceI +" ===  "+unitPriceJ);
                if(unitPriceI<unitPriceJ) {
                    tmp = bag[j-1];
                    bag[j-1]=bag[i];
                    bag[j]=tmp;

                }
            }
        }
    }

    public static void main(String[] args) {
        bag = new Item[10];
        for (int i = 0; i < bag.length; i++) {
            bag[i] = new Item();
        }
//        bag[0].weight=6;
//        bag[0].price=10;
//
//        bag[1].weight=8;
//        bag[1].price=10;
//
//        bag[2].weight=3;
//        bag[2].price=10;

        System.out.println(Bag.pringBag());
        Bag.sort();
        System.out.println(Bag.pringBag());
    }

    public static String pringBag() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < bag.length; i++) {
            result.append(bag[i].toString());
            result.append("\n");
        }
        return result.toString();
    }
}

class Item {
    public int weight;
    public int price;
    public Item() {
        this.weight = (int) (Math.random()*9)+1;
        this.price = (int) (Math.random()*900)+100;
    }
    @Override
    public String toString() {
        return String.format("Вес: %d, Цена: %d, UnitPrice: %f", this.weight, this.price, (float) this.price/this.weight);
    }
}