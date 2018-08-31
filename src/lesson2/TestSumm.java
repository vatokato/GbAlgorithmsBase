package lesson2;

public class TestSumm {
    public int a;
    public int b;

    public TestSumm(int a, int b) {
        this.a = a;
        this.b = b;
    }

    private int summ() {
        return this.a+this.b;
    }

    public String toString(){
        StringBuilder result = new StringBuilder();
        result.append("[").append(a).append("+").append(b).append("=").append(this.summ()).append("]");
        return result.toString();
    }
}
