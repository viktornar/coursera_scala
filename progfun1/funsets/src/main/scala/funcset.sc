type Set = Int => Boolean

def contains(s: Set, elem: Int): Boolean = s(elem)
def singletonSet(elem: Int): Set = (x: Int) => contains(x => elem == x, x)
def union(s: Set, t: Set): Set = (x: Int) => contains(x => s(x) || t(x) , x)
def intersect(s: Set, t: Set): Set = (x: Int) => contains(x => s(x) && t(x) , x)
def diff(s: Set, t: Set): Set = (x: Int) => contains(x => s(x) && !t(x) , x)
def filter(s: Set, p: Int => Boolean): Set = (x: Int) => contains(x=>p(x) && s(x), x)

val s1 = singletonSet(1)
val s2 = singletonSet(2)
val s3 = singletonSet(3)
val s4 = singletonSet(4)
val s5 = singletonSet(5)

if (contains(s1, 1)) println("Contains")
if (contains(s1, 2)) println("Not contains")

val s_u1 = union(union(s1, s2), s3)
val s_u2 = union(union(s3, s4), s5)

val s_diff1 = diff(s_u1, s_u2)
val s_diff2 = diff(s_u2, s_u1)

contains(s_diff1, 1)
contains(s_diff2, 4)

val s_f1 = filter(s_u1, (elem) => elem > 2)

contains(s_f1, 1)