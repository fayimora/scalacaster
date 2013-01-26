/**
 * This file is part of Scalacaster project, https://github.com/vkostyukov/scalacaster
 * and written by Vladimir Kostyukov, http://vkostyukov.ru
 *
 * Merge Sort http://en.wikipedia.org/wiki/Quicksort
 *
 * Worst - O(n log n)
 * Best - O(n log n)
 * Average - O(n log n)
 */

def mergesort(input: Array[Int]): Array[Int] = {
  if (input.length == 1) {
    return input
  }

  val n = input.length / 2

  val left = mergesort(input.slice(0, n))
  val right = mergesort(input.slice(n, input.length))

  var result: Array[Int] = new Array(input.length)

  var i = 0
  var j = 0
  result.indices foreach { k =>
    if (i == left.length) {
      result(k) = right(j)
      j += 1
    } else if (j == right.length) {
      result(k) = left(i)
      i += 1
    } else if (left(i) > right(j)) {
      result(k) = right(j)
      j += 1
    } else {
      result(k) = left(i)
      i += 1
    }
  }

  return result
}

assert { mergesort(Array(5, 2, 1, 3, 4)).deep == Array(1, 2, 3, 4, 5).deep }