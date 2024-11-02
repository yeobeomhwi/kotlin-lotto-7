package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.model.Rank

class LottoView {
    fun displayWinningNumbers(winningNumbers: List<Int>) {
        println("당첨 번호: $winningNumbers")
    }

    fun displayBonusNumber(bonusNumber: Int) {
        println("보너스 번호: $bonusNumber")
    }

    fun displayError(message: String) {
        println("[ERROR] $message")
    }

    fun readWinningNumbers(): List<Int?> {
        println()
        println("당첨 번호를 입력해 주세요.")
        val input = Console.readLine()
        val numbers = input.split(",").map { it.trim().toIntOrNull() }

        if (numbers.any { it == null }) {
            displayError("당첨 번호는 정수만 입력해야 합니다.")
            return emptyList()
        }

        return numbers
    }

    fun readBonusNumber(): Int {
        println()
        println("보너스 번호를 입력해 주세요.")
        val input = Console.readLine()

        if (input.isEmpty()) {
            displayError("보너스 번호는 비워둘 수 없습니다.")
            return -1
        }

        return input.toIntOrNull() ?: run {
            displayError("유효한 정수를 입력해야 합니다.")
            -1
        }
    }

    fun displayPurchaseCount(count: Int) {
        println()
        println("${count}개를 구매했습니다.")
    }

    fun displayStatistics(statistics: Map<Rank, Int>) {
        Rank.values().forEach { rank ->
            val count = statistics.getOrDefault(rank, 0)
            println("${rank.message} $count")
        }
    }

    fun displayYield(yield: Double) {
        println("총 수익률은 ${"%.1f".format(yield)}%입니다.") // 소수점 1자리까지 포맷하여 출력
    }

    fun displayWinningStatistics() {
        println("당첨 통계")
        println("---")
    }
}
