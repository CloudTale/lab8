package Labs;

public class Lab8 {
	public int coinChange(int[] coins, int amount) {
	       int n = coins.length;
	        Integer[][] dp = new Integer[n][amount + 1];

	        if (amount == 0) return 0;
	        int ans = find(coins, amount, 0, dp);

	        if (ans == (int)1e9) return -1;
	        return ans;
	    }

	    public int find(int[] coins, int tar, int ind, Integer[][] dp) {
	        if (tar == 0) return 0;
	        if (ind >= coins.length) return (int)1e9;
	        if (dp[ind][tar] != null) return dp[ind][tar];

	        int take = (int)1e9;
	        int ntake = (int)1e9;

	        if (coins[ind] <= tar) take = 1 + find(coins, tar - coins[ind], ind, dp);
	        ntake = find(coins, tar, ind + 1, dp);

	        return dp[ind][tar] = Math.min(take, ntake);
	    }
}
