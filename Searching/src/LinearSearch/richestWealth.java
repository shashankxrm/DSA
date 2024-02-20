package LinearSearch;

public class richestWealth {
    public static void main(String[] args) {
        int[][] accounts = {
                {1, 5},
                {7, 3},
                {3, 5}
        };
        System.out.println(maximumWealth(accounts));
    }

    static int maximumWealth(int[][] accounts) {
        int ans = 0;
        for (int person = 0; person < accounts.length; person++) {
            int wealth = 0;
            for (int account = 0; account < accounts[person].length; account++) {
                wealth = wealth + accounts[person][account];
            }
            if (wealth > ans) {
                ans = wealth;
            }

        }
        return ans;

    }
}
