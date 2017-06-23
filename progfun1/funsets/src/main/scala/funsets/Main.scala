package funsets

object Main extends App {

  import FunSets._
  //  println(contains(singletonSet(1), 1))

  val s1 = singletonSet(1)
  val s2 = singletonSet(2)
  val s3 = singletonSet(3)
  val s4 = singletonSet(4)
  val s5 = singletonSet(5)

  //  if (contains(s1, 1)) println("Contains")
  //  if (!contains(s1, 2)) println("Not contains")

  val s_u1 = union(union(s1, s2), s3)
  val s_u2 = union(union(s3, s4), s5)
  val s_diff1 = diff(s_u1, s_u2)
  val s_diff2 = diff(s_u2, s_u1)
  //  printSet(s_u1)
  //  printSet(s_diff1)

  val s_u_b = union(s_u1, s_u2)
  //  printSet(filter(s_u_b, (x) => x > 2 && x < 4))
  //  println(exists(s_u_b, (x) => x <= 1))
  //  printSet(union(s1, s3))
  println(forall(union(s1, s3), x => x > 1))

  val map_1 = map(union(union(s1, s2), s3), x => 2 * x)
  printSet(map_1)
}
