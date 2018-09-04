package lesson3;

class ReverseReading {
    public static void reading(String input) {
        int size = input.length();
        if(size==0) return;

        StackSimple ss = new StackSimple(size);
        for (int i = 0; i < size; i++) {
            ss.push(input.charAt(i));
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < ss.getSize(); i++) {
            result.append(ss.pop());
        }
        System.out.println("Наоборот: "+result);
    }
}
