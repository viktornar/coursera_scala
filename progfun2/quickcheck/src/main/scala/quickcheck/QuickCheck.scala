package quickcheck

import common._

import org.scalacheck._
import Arbitrary._
import Gen._
import Prop._


abstract class QuickCheckHeap extends Properties("Heap") with IntHeap {
  def removeHeap(h: H, as: List[Int]): List[Int] = {
    if (isEmpty(h)) as
    else findMin(h) :: removeHeap(deleteMin(h), as)
  }

  property("min1") = forAll { a: Int =>
    val h = insert(a, empty)
    findMin(h) == a
  }

  lazy val genHeap: Gen[H] = for {
    a <- arbitrary[Int]
    h <- oneOf(const(empty), genHeap)
  } yield insert(a, h)

  implicit lazy val arbHeap: Arbitrary[H] = Arbitrary(genHeap)

  property("gen1") = forAll { (h: H) =>
    val m = if (isEmpty(h)) 0 else findMin(h)
    findMin(insert(m, h)) == m
  }

  property("should_get_the_smallest_of_the_two_elements_1") = forAll { (a1: Int, a2: Int) =>
    val h = insert(a2, insert(a1, empty))
    val smaller = if (a1 < a2) a1 else a2
    findMin(h) == smaller
  }

  property("heap_should_be_empty_1") = forAll { a: Int =>
    val h1 = insert(a, empty)
    val h2 = deleteMin(h1)
    h2 == empty
  }

  property("should_return_a_minimum_of_one_or_the_other_1") = forAll { (h1: H, h2: H) =>
    val min1 = findMin(h1)
    val min2 = findMin(h2)
    val melded = meld(h1, h2)
    val minMeld = findMin(melded)
    minMeld == min1 || minMeld == min2
  }

  property("should_get_a_sorted_sequence_of_elements_when_continually_finding_and_deleting_min_1") = forAll { h: H =>
    val xs = removeHeap(h, Nil)
    xs == xs.sorted
  }

  property("should_get_the_same_heaps_after_removing_melded_heaps_1") = forAll { (h1: H, h2: H) =>
    val melded1 = meld(h1, h2)
    val min = findMin(h1)
    val melded2 = meld(deleteMin(h1), insert(min, h2))
    val xs1 = removeHeap(melded1, Nil)
    val xs2 = removeHeap(melded2, Nil)
    xs1 == xs2
  }

  property("should_get_different_heaps_after_removing_melded_heap_1") = forAll { (h1: H, h2: H) =>
    val melded1 = meld(h1, h2)
    val min = findMin(h1)
    val melded2 = meld(deleteMin(h1), insert(min, h2))
    val xs1 = removeHeap(melded1, Nil)
    xs1 != melded2
  }

  property("should_get_the_same_heaps_after_removing_melded_heaps_1") = forAll { (h1: H, h2: H, h3: H) =>
    val melded1 = meld(h1, h2)
    val min = findMin(h1)
    val melded2 = meld(deleteMin(h1), insert(min, h2))
    val xs1 = removeHeap(melded1, Nil)
    val xs2 = removeHeap(melded2, Nil)
    xs1 == xs2
  }

  property("should_get_different_heaps_after_removing_melded_heap_1") = forAll { (h1: H, h2: H, h3: H) =>
    val melded1 = meld(h1, h2)
    val min = findMin(h1)
    val melded2 = meld(deleteMin(h1), insert(min, h2))
    val xs1 = removeHeap(melded1, Nil)
    xs1 != melded2
  }
}
