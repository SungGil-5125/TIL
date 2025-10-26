class Bank(private val balance: LongArray) {
    fun transfer(account1: Int, account2: Int, money: Long): Boolean {
        if (!isValidAccount(account1) || !isValidAccount(account2)) return false
        return if (hasMoreMoney(account1, money)) {
            this.withdraw(account1, money) && this.deposit(account2, money)
        } else {
            false
        }
    }

    fun deposit(account: Int, money: Long): Boolean {
        if (!isValidAccount(account)) return false
        balance[account - 1] = balance[account - 1] + money
        return true
    }

    fun withdraw(account: Int, money: Long): Boolean {
        if (!isValidAccount(account)) return false
        return if (hasMoreMoney(account, money)) {
            balance[account - 1] = balance[account - 1] - money
            true
        } else {
            false
        }
    }

    private fun isValidAccount(account: Int): Boolean {
        return try {
            balance[account - 1]
            true
        } catch (e: Exception) {
            false
        }
    }

    private fun hasMoreMoney(account: Int, money: Long): Boolean {
        return money <= balance[account - 1]
    }
}
