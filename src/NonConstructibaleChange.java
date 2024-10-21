import java.util.Arrays;

public class NonConstructibaleChange {
    public static int nonConstructibleChange(int[] coins) {
        if(coins.length == 0) return 1;
        Arrays.sort(coins);
        int currentTestedChange = 0;
        for(int coin: coins) {
            int delta = coin - currentTestedChange;
            if(delta > 1) {
                break;
            }
            currentTestedChange += coin;
        }
        return currentTestedChange + 1;
    }

    public static void main(String... args) {
        int[] coins = {5, 7, 1, 1, 2, 3, 22};
        System.out.println(nonConstructibleChange(coins));

        coins = new int[]{1, 1, 2, 3, 8};
        System.out.println(nonConstructibleChange(coins));

        coins = new int[]{6, 4, 5, 1, 1, 8, 9};
        System.out.println(nonConstructibleChange(coins));
    }
}
